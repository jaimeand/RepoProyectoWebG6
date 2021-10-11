import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.*;
import org.bson.Document;

public class Cnx {

    public MongoCursor<Document> makeCnxToMongoDB() {
        try {
            ConnectionString connectionString = new ConnectionString
                    ("mongodb+srv://dbCiclo4:mongo-mm001-user@ciclo4.ckutl.mongodb.net/test");
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(connectionString).build();
            MongoClient mongoClient = MongoClients.create(settings);
            MongoDatabase database = mongoClient.getDatabase("BaseProyectoWebG6");

            MongoCollection<Document> collection = database.getCollection("Estudiantes");
//            MongoCollection<Document> collection = database.getCollection("Proyectos");
            MongoCursor<Document> document = collection.find().iterator();
            return document;
        } catch (MongoException ex) {
            throw new MongoException(ex.getMessage());
        }
    }
}