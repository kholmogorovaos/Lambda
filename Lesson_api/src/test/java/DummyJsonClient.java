public interface DummyJsonClient {
    MyResponse getUser(int id);

    MyResponse login(User u);

    MyResponse getPosts(User u, Token token);
}
