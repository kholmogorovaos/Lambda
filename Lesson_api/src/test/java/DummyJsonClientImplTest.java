import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DummyJsonClientImplTest {
    private DummyJsonClient dummyJsonClient;
    private String username;
    private String password;
    private String token;

    @BeforeEach
    public void setUp() {
        dummyJsonClient = new DummyJsonClientImpl();
    }

    @Test
    @Order(1)
    public void getUserTest() {
        int userId = 1;

        MyResponse response = dummyJsonClient.getUser(userId);

        assertEquals(HttpStatus.SC_OK, response.getStatusCode());

        String responseBody = response.getBody();

        assertTrue(responseBody.contains("\"firstName\":\"Terry\""));

        assertTrue(responseBody.contains("\"email\":\"atuny0@sohu.com\""));
        // Сохраняем username и password
        JSONObject responseJson = new JSONObject(responseBody);
        username = responseJson.getString("username");
        password = responseJson.getString("password");
    }

    @Test
    @Order(2)
    public void loginTest() {
        User user = new User(1, username, password);

        MyResponse response = dummyJsonClient.login(user);

        assertEquals(HttpStatus.SC_OK, response.getStatusCode());

        String responseBody = response.getBody();

        assertTrue(responseBody.contains("\"username\":\"" + username + "\""));
        assertTrue(responseBody.contains("\"email\":\"atuny0@sohu.com\""));
        assertTrue(responseBody.contains("\"firstName\":\"Terry\""));
        assertTrue(responseBody.contains("\"lastName\":\"Medhurst\""));
        assertTrue(responseBody.contains("\"token\""));

        // Сохраняем token
        JSONObject responseJson = new JSONObject(responseBody);
        token = responseJson.getString("token");
        assertNotNull(token);
        assertFalse(token.isEmpty());
    }

    @Test
    @Order(3)
    public void getPostsTest() {
        User user = new User(1, username, password);
        Token tokenObject = new Token(token);

        MyResponse response = dummyJsonClient.getPosts(user, tokenObject);

        assertEquals(HttpStatus.SC_OK, response.getStatusCode());

        String responseBody = response.getBody();
        //проверяю, что у user есть posts и они не пустые
        JSONObject responseJson = new JSONObject(responseBody);
        JSONArray postsArray = responseJson.getJSONArray("posts");
        assertNotNull(postsArray);
        assertTrue(postsArray.length() > 0);
    }
}
