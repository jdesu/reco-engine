package scripts;

import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author bkovuri
 */
public class EmailToCustomerMapping {
    private final static String HOST = "localhost";
    private final static int PORT = 27017;
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String args[]) {
        try {
            // Connect to mongodb server on localhost
            MongoClient mongoClient = new MongoClient(HOST, PORT);

            DB db = mongoClient.getDB("amazon_dataset");
            DBCollection dbEmailMappingColl = db.getCollection("email_to_profile_mapping");
            DBCollection dbCustomers = db.getCollection("customers");

            Set<String> emailSet = fetchEmail(dbCustomers);
            Set<String> profileSet = readCustomerProfileIds();
            writeToDB(dbEmailMappingColl, emailSet, profileSet);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    private static void writeToDB(DBCollection dbCollection, Set<String> emailSet, Set<String> profileSet) {

        Iterator<String> emailIter = emailSet.iterator();
        Iterator<String> profileIter = profileSet.iterator();

        while(emailIter.hasNext()) {
            String email = emailIter.next();
            if(profileIter.hasNext()) {
                String profile = profileIter.next();
                BasicDBObject document = new BasicDBObject();
                document.put("_id", email);
                document.put("profile", profile);
                try {
                    dbCollection.insert(document);
                }
                catch(Exception e) {
                    System.out.println(String.format("Exception raised for email: %s, profile: %s", email, profile, e));
                }
            } else {
                profileIter = profileSet.iterator();
            }
        }
    }

    private static Set<String> fetchEmail(DBCollection dbCollection) {

        BasicDBObject query = new BasicDBObject();
        BasicDBObject fields = new BasicDBObject();
        fields.put("EmailAddress", 1);
        Set<String> emailSet = new HashSet<String>();
        DBCursor cursor = dbCollection.find(query, fields);
        try {
            while (cursor.hasNext()) {
                DBObject doc = cursor.next();
                String docStr = doc.get("EmailAddress").toString();
                emailSet.add(docStr);
                System.out.println(docStr);
            }
        } finally {
            cursor.close();
        }
        System.out.println("Total count of emailAddress: "+emailSet.size());
        return emailSet;
    }

    private static Set<String> readCustomerProfileIds() throws Exception {

        String filePath = "/Users/bkovuri/bhanu/jyothi/itu/capstone/project/play/book/mappings/book_ratings/customerToId/";
        String filePrefix = "part-000";
        String writeFile = "profile.txt";

        Set<String> profileSet = new HashSet<String>();
        BufferedWriter writer = Files.newWriter(new File(filePath + writeFile), Charset.defaultCharset());

        for (int i = 0; i < 100; i++) {
            String fileName = filePrefix + String.format("%02d", i);
            String file = filePath + fileName;
            BufferedReader reader = Files.newReader(new File(file), Charset.defaultCharset());
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] lineArray = line.split(",");
                String profile = lineArray[0];
                writer.write(profile);
                writer.newLine();
                profileSet.add(profile);
            }
            reader.close();
        }
        writer.close();
        return profileSet;
    }
}
