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
        MongoClient mongoClient = MongoClients.create();
        database = mongoClient.getDatabase("test");
    }

    public void saveTeam(final Team team)
    {
        var collection = database.getCollection("teams");
        upsert(collection, team.getId(), gson.toJson(team));
    }

    public void savePlayer(final FullPlayer player)
    {
        var collection = database.getCollection("players");
        upsert(collection, player.getPlayer().getId(), gson.toJson(player));
    }

    public void savePosition(final Position position)
    {
        var collection = database.getCollection("positions");
        upsert(collection, position.getId(), gson.toJson(position));
    }

    public void saveFixture(Fixture fixture)
    {
        var collection = database.getCollection("fixtures");
        upsert(collection, fixture.getId(), gson.toJson(fixture));
    }

    private void upsert(MongoCollection<Document> collection, int id, String json) {
        Bson filter = eq("id", id);
        UpdateOptions options = new UpdateOptions().upsert(true);
        var document = Document.parse(json);
        Bson update = new Document("$set", document);
        collection.updateOne(filter, update, options);
    }
}
