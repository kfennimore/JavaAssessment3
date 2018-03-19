package user_management;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import parsing_json.ElementCollection;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class UserCollectionInitializer {
    public static UserCollection generate() throws IOException {

            String path = "/users.json";

            try (Reader reader = new InputStreamReader(UserCollection.class.
                    getResourceAsStream(path))) {
                //create new GsonBuilder
                Gson gs = new GsonBuilder().create();

                //Element collection = GsonBuilder from the Json FILE use : reader & element TYPE

                UserCollection users = gs.fromJson(reader, UserCollection.class);
                return users;
            }
        }
    }
