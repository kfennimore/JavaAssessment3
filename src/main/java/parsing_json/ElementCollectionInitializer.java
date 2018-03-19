package parsing_json;

import com.google.gson.*;

import java.io.*;

public class ElementCollectionInitializer {
    public static ElementCollection generate() throws IOException {

        String path = "/periodic_table.json";

        try (Reader reader = new InputStreamReader(ElementCollection.class.
                getResourceAsStream(path))) {
            //create new GsonBuilder
            Gson gs = new GsonBuilder().create();

            //Element collection = GsonBuilder from the Json FILE use : reader & element TYPE

            ElementCollection elements = gs.fromJson(reader, ElementCollection.class);
            return elements;
        }
    }
}




