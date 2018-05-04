import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UpdateAPI {
    UpdateAPI() {
    }

    public void update() {
        try {
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            // I think, you won't have more than 100000 repos ;)
            URL url = new URL("https://api.github.com/users/allegro/repos?per_page=100000");
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
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            Date lastDate = sdf.parse("2010-01-01T1:0:0Z");
            String lastRepoName="";
            for (int repoNumber = 0; repoNumber < mainRepoArray.length(); repoNumber++) {
                JSONObject repo = mainRepoArray.getJSONObject(repoNumber);
                String updateDate = repo.getString("updated_at");
                String repoName = repo.getString("name");
                Date date = sdf.parse(updateDate);
                System.out.println(repoNumber+" "+repoName);
                if (date.after(lastDate)){
                    lastDate=date;
                    lastRepoName=repoName;
                }

            }
            System.out.print(lastRepoName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}