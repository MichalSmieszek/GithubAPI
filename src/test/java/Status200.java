
import com.sun.deploy.nativesandbox.comm.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Status200 {
// checking if response code is 200
    @Test
    public void testBadRequestWithOrderMisspelled() throws IOException{
        URL url = new URL("https://api.github.com/users/allegro/repos");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        int statusCode = http.getResponseCode();
        Assert.assertEquals(200,statusCode);
    }
}