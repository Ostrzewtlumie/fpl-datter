package datter;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import datter.dto.*;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Runner {
    private static final MongoSaver SAVER = new MongoSaver();

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final String HEADER_VALUE = "application/json";
    private static final String HEADER_NAME = "accept";
    public static final String UNAVAILABLE_STATUS = "u";

    public static void main(String[] args) throws IOException, InterruptedException {
        Instant start = Instant.now();
        var httpRequest =
                HttpRequest.newBuilder(URI.create("https://fantasy.premierleague.com/api/bootstrap-static/"))
                .header(HEADER_NAME, HEADER_VALUE)
                .build();
        var response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        saveResponse(response);
        parseTeams(response);
        parsePositions(response);
        parsePlayers(response);
        parseFixtures();
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end));
    }

    private static void saveResponse(HttpResponse<String> response) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        Date date = new Date();
        try {
            try (FileWriter myWriter = new FileWriter("filename" + formatter.format(date) + ".json")) {
                myWriter.write(response.body());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void parseFixtures() throws IOException, InterruptedException {
        HttpRequest httpRequest =
               HttpRequest.newBuilder(URI.create("https://fantasy.premierleague.com/api/fixtures/"))
                       .header(HEADER_NAME, HEADER_VALUE)
                       .build();
        var response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        final List<Fixture> fixtures = gson.fromJson(response.body(), new TypeToken<List<Fixture>>(){}.getType());
        fixtures.forEach(SAVER::saveFixture);
    }

    private static void parsePlayers(HttpResponse<String> response) throws IOException, InterruptedException {

        JsonObject jo = (JsonObject)JsonParser.parseString(response.body());
        JsonArray jsonArr = jo.getAsJsonArray("elements");
        final List<Player> players = gson.fromJson(jsonArr, new TypeToken<List<Player>>(){}.getType());
        final List<FullPlayer> fullPlayers = parseFullPlayersData(players);
        fullPlayers.forEach(SAVER::savePlayer);
    }

    private static List<FullPlayer> parseFullPlayersData(List<Player> players) throws IOException, InterruptedException {
        final List<FullPlayer> fullPlayers = new ArrayList<>(players.size());
        for (final Player player : players) {
            if (!UNAVAILABLE_STATUS.equals(player.getStatus())) {
                HttpRequest httpRequest =
                        HttpRequest.newBuilder(URI.create("https://fantasy.premierleague.com/api/element-summary/" + player.getId() + "/"))
                                .header(HEADER_NAME, HEADER_VALUE)
                                .build();
                var response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
                final PlayerDetails playerDetails = gson.fromJson(response.body(), new TypeToken<PlayerDetails>() {
                }.getType());
                fullPlayers.add(new FullPlayer(player, playerDetails));
            }
            else
            {
                fullPlayers.add(new FullPlayer(player, null));
            }
        }
        return fullPlayers;
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
