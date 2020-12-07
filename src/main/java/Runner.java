import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import dto.Fixture;
import dto.Player;
import dto.Position;
import dto.Team;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Runner
{
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("running up");

        var httpClient = HttpClient.newHttpClient();
        var httpRequest =
                HttpRequest.newBuilder(URI.create("https://fantasy.premierleague.com/api/bootstrap-static/"))
                .header("accept", "application/json")
                .build();
        var response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        Date date = new Date();
        System.out.println(formatter.format(date));
        try {
            FileWriter myWriter = new FileWriter("filename" + formatter.format(date) + ".txt");
            myWriter.write(response.body());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //parsing teams
        JsonObject jo = (JsonObject)JsonParser.parseString(response.body());
        JsonArray jsonArr = jo.getAsJsonArray("teams");
        final Gson gson = new Gson();
        final List<Team> teamList = gson.fromJson(jsonArr, new TypeToken<List<Team>>(){}.getType());
        teamList.forEach(t -> System.out.println(t.getName()));

        //parsing positions
         jo = (JsonObject)JsonParser.parseString(response.body());
         jsonArr = jo.getAsJsonArray("element_types");
        final List<Position> positions = gson.fromJson(jsonArr, new TypeToken<List<Position>>(){}.getType());
        positions.forEach(t -> System.out.println(t.getPluralName()));

        //parsing players
        jsonArr = jo.getAsJsonArray("elements");
        final List<Player> players = gson.fromJson(jsonArr, new TypeToken<List<Player>>(){}.getType());
        players.forEach(t -> System.out.println(t.getPoints()));

        //parsing fixtures
         httpRequest =
                HttpRequest.newBuilder(URI.create("https://fantasy.premierleague.com/api/fixtures/"))
                        .header("accept", "application/json")
                        .build();
         response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        final List<Fixture> fixtures = gson.fromJson(response.body(), new TypeToken<List<Fixture>>(){}.getType());

        fixtures.forEach(t -> System.out.println(t.getTeamAway()));

    }
}
