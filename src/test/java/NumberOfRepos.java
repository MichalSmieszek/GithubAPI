import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class NumberOfRepos {
    @Test
    public void numberOfRepos() {
        /* here we take number of repos from api.github.com/users/allegro. We want to check if this number is equal to
         array length from api.github.com/users/allegro/repos?per_page=100000*/
        int arrayLength=1, repoNumber=0;
        try {
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            URL url = new URL("https://api.github.com/users/allegro");
            connection = (HttpURLConnection) url.openConnection();
            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            String finalJSON = buffer.toString();
            JSONObject allegroData = new JSONObject(finalJSON);
            repoNumber = allegroData.getInt("public_repos");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //here we take array length
           try{
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            URL url2 = new URL("https://api.github.com/users/allegro/repos?per_page=100000");
            connection = (HttpURLConnection) url2.openConnection();
            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            String line ="";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            String finalJSON = buffer.toString();
            JSONArray mainRepoArray = new JSONArray(finalJSON);
            arrayLength = mainRepoArray.length();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(repoNumber,arrayLength);

    }
}
