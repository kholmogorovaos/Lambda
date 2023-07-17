import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MovieRepositoryImplTest {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "root";
    private static final String password = "user123456";
    private static MovieRepository movieRepository;

    @BeforeEach
    void setup() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        movieRepository = new MovieRepositoryImpl(connection);
    }
    @Test
    void testGet() {
        Movie movie = movieRepository.get(1);
        assertNotNull(movie);
        assertEquals("Hope", movie.getTitle());
        assertEquals("horror", movie.getGenre());
        assertEquals(LocalDate.of(2023,2,2), movie.getRelease());
    }
    @Test
    void testSave() {
        Movie movie = new Movie(8,"Trust", "horror", LocalDate.of(2020,01,01), 5);
        movieRepository.save(movie);
    }
    @Test
    void testDelete() {
        Movie movie = new Movie(8,"Trust", "horror", LocalDate.of(2020,01,01), 5);
        movieRepository.delete(movie);
    }
    @Test
    void testGetDirector() {
        Director director = new Director(2, "Denis", "Collins", LocalDate.of(1982, 7, 9), "Australia");

        List<Movie> result = movieRepository.get(director);

        assertNotNull(result);
        assertEquals(2, result.size());

        Movie retrievedMovie1 = result.get(0);
        assertEquals(2, retrievedMovie1.getId());
        assertEquals("Give", retrievedMovie1.getTitle());
        assertEquals("comedy", retrievedMovie1.getGenre());
        assertEquals(LocalDate.of(2022, 3, 5), retrievedMovie1.getRelease());
        assertEquals(director.getId(), retrievedMovie1.getDirector());

        Movie retrievedMovie2 = result.get(1);
        assertEquals(4, retrievedMovie2.getId());
        assertEquals("Second", retrievedMovie2.getTitle());
        assertEquals("fiction", retrievedMovie2.getGenre());
        assertEquals(LocalDate.of(2022, 7, 6), retrievedMovie2.getRelease());
        assertEquals(director.getId(), retrievedMovie2.getDirector());
    }
}
