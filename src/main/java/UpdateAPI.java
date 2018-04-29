import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdateAPI {
    UpdateAPI(){}
    public void update() {
        try {
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            URL url = new URL("https://api.github.com/users/allegro/repos");
            connection = (HttpURLConnection) url.openConnection();
            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            String finalJSON = buffer.toString();
            JSONArray mainRepoArray = new JSONArray(finalJSON);
            for(int repoNumber=0; repoNumber<mainRepoArray.length();repoNumber++){
                JSONObject repo = mainRepoArray.getJSONObject(repoNumber);
                String updateDate = repo.getString("updated_at");
                System.out.print(updateDate);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();

        }
    }

}