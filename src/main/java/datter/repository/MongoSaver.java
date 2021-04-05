package datter.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import datter.dto.*;
import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.eq;

public class MongoSaver {

    private final MongoDatabase database;

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public MongoSaver()
    {
        final MongoClient mongoClient = MongoClients.create();
        database = mongoClient.getDatabase("test");
    }

    public void saveTeam(final Team team)
    {
        final var collection = database.getCollection("teams");
        upsert(collection, team.getId(), gson.toJson(team));
    }

    public void savePlayer(final Player player)
    {
        final var collection = database.getCollection("players");
        upsert(collection, player.getPlayer().getId(), gson.toJson(player));
    }

    public void saveFixture(final Fixture fixture)
    {
        final var collection = database.getCollection("fixtures");
        upsert(collection, fixture.getId(), gson.toJson(fixture));
    }

    private void upsert(final MongoCollection<Document> collection, final int id, final String json) {
        final Bson filter = eq("id", id);
        final UpdateOptions options = new UpdateOptions().upsert(true);
        final var document = Document.parse(json);
        final Bson update = new Document("$set", document);
        collection.updateOne(filter, update, options);
    }
}
