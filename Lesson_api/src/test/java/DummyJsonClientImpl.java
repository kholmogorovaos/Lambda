import org.apache.hc.core5.net.URIBuilder;
import org.apache.hc.core5.ssl.SSLContextBuilder;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class DummyJsonClientImpl implements DummyJsonClient {

    private static final String BASE_URL = "https://dummyjson.com";

    @Override
    public MyResponse getUser(int id) {
        URIBuilder builder;
        try {
            builder = new URIBuilder(BASE_URL + "/users/" + id);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Failed to build URI", e);
        }
        HttpGet httpGet = new HttpGet(builder.toString());

        try (CloseableHttpClient client = HttpClients.createDefault();
             CloseableHttpResponse response = client.execute(httpGet)) {
            int statusCode = response.getStatusLine().getStatusCode();
            String responseBody = EntityUtils.toString(response.getEntity());
            return new MyResponse(statusCode, responseBody);
        } catch (IOException e) {
            throw new RuntimeException("Failed to execute GET request", e);
        }
    }

    @Override
    public MyResponse login(User u) {
        HttpPost httpPost = new HttpPost(BASE_URL + "/auth/login");

        try {
            httpPost.addHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());

            JSONObject requestBody = new JSONObject();
            requestBody.put("username", u.getLogin());
            requestBody.put("password", u.getPassword());
            StringEntity entity = new StringEntity(requestBody.toString());
            httpPost.setEntity(entity);

            try (CloseableHttpClient client = HttpClients.custom()
                    .setSSLContext(SSLContextBuilder.create().loadTrustMaterial((chain, authType) -> true).build())
                    .build()) {

                CloseableHttpResponse response = client.execute(httpPost);
                int statusCode = response.getStatusLine().getStatusCode();
                String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                response.close();

                return new MyResponse(statusCode, responseBody);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            } catch (KeyStoreException e) {
                throw new RuntimeException(e);
            } catch (KeyManagementException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to execute POST request", e);
        }
    }

    @Override
    public MyResponse getPosts(User u, Token token) {
        URIBuilder builder;
        try {
            builder = new URIBuilder(BASE_URL + "/users/" + u.getId() + "/posts");
        } catch (URISyntaxException e) {
            throw new RuntimeException("Failed to build URI", e);
        }
        HttpGet httpGet = new HttpGet(builder.toString());
        httpGet.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token.getToken());

        try (CloseableHttpClient client = HttpClients.createDefault();
             CloseableHttpResponse response = client.execute(httpGet)) {
            int statusCode = response.getStatusLine().getStatusCode();
            String responseBody = EntityUtils.toString(response.getEntity());
            return new MyResponse(statusCode, responseBody);
        } catch (IOException e) {
            throw new RuntimeException("Failed to execute GET request", e);
        }
    }
}
