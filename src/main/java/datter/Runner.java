package datter;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import datter.dto.Fixture;
import datter.dto.Player;
import datter.dto.Position;
import datter.dto.Team;
import datter.repository.MongoSaver;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class Runner {
    private static final MongoSaver SAVER = new MongoSaver();

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("running up");
        Instant start = Instant.now();
        var httpClient = HttpClient.newHttpClient();
        var httpRequest =
                HttpRequest.newBuilder(URI.create("https://fantasy.premierleague.com/api/bootstrap-static/"))
                .header("accept", "application/json")
                .build();
        var response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        saveResponse(response);
        parseTeams(response);
        parsePositions(response);
        parsePlayers(response);
        parseFixtures(httpClient);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end));
    }

    private static void saveResponse(HttpResponse<String> response) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        Date date = new Date();
        try {
            try (FileWriter myWriter = new FileWriter("filename" + formatter.format(date) + ".txt")) {
                myWriter.write(response.body());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void parseFixtures(HttpClient httpClient) throws IOException, InterruptedException {
        HttpRequest httpRequest;
        HttpResponse<String> response;
        httpRequest =
               HttpRequest.newBuilder(URI.create("https://fantasy.premierleague.com/api/fixtures/"))
                       .header("accept", "application/json")
                       .build();
        response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        final List<Fixture> fixtures = gson.fromJson(response.body(), new TypeToken<List<Fixture>>(){}.getType());
        fixtures.forEach(SAVER::saveFixture);
    }

    private static void parsePlayers(HttpResponse<String> response) {

        JsonObject jo = (JsonObject)JsonParser.parseString(response.body());
        JsonArray jsonArr = jo.getAsJsonArray("elements");
        final List<Player> players = gson.fromJson(jsonArr, new TypeToken<List<Player>>(){}.getType());
        players.forEach(SAVER::savePlayer);
    }

    private static void parsePositions(HttpResponse<String> response) {
        JsonObject jo = (JsonObject)JsonParser.parseString(response.body());
        JsonArray jsonArr = jo.getAsJsonArray("element_types");
        final List<Position> positions = gson.fromJson(jsonArr, new TypeToken<List<Position>>(){}.getType());
        positions.forEach(SAVER::savePosition);
    }

    private static void parseTeams(HttpResponse<String> response) {
        JsonObject jo = (JsonObject)JsonParser.parseString(response.body());
        JsonArray jsonArr = jo.getAsJsonArray("teams");
        final List<Team> teamList = gson.fromJson(jsonArr, new TypeToken<List<Team>>(){}.getType());
        teamList.forEach(SAVER::saveTeam);
    }
}
