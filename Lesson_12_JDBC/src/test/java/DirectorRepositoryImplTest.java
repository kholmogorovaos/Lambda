import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DirectorRepositoryImplTest {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "root";
    private static final String password = "user123456";
    private static DirectorRepository directorRepository;

    @BeforeEach
    void setup() throws SQLException {
       Connection connection = DriverManager.getConnection(url, username, password);
        directorRepository = new DirectorRepositoryImpl(connection);
    }

    @Test
    void testGet() {
        Director director = directorRepository.get(1);
        assertNotNull(director);
        assertEquals("Petr", director.getFirstName());
        assertEquals("Ivanov", director.getLastName());
    }

    @Test
    void testSave() {
        Director director = new Director(8,"John", "Doe", LocalDate.of(1990,01,01), "USA");
        directorRepository.save(director);
    }
    @Test
    void testDelete() {
        Director director = new Director(8, "John", "Doe", LocalDate.of(1990,01,01), "USA");
        directorRepository.delete(director);
    }
    @Test
    void testGetMovies() {
        List<String> genres = Arrays.asList("horror", "fantasy");

        List<Director> result = directorRepository.get(genres);

        assertNotNull(result);
        assertEquals(2, result.size());

        Director director1 = result.get(0);
        assertEquals(1, director1.getId());
        assertEquals("Petr", director1.getFirstName());
        assertEquals("Ivanov", director1.getLastName());
        assertEquals(LocalDate.of(1976, 5, 23), director1.getBirthDate());
        assertEquals("Russia", director1.getCountry());

        Director director2 = result.get(1);
        assertEquals(5, director2.getId());
        assertEquals("Margo", director2.getFirstName());
        assertEquals("Robins", director2.getLastName());
        assertEquals(LocalDate.of(1965, 3, 7), director2.getBirthDate());
        assertEquals("England", director2.getCountry());
    }
}


