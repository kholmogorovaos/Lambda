import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovieRepositoryImpl implements MovieRepository {
    private Connection connection;

    public MovieRepositoryImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public Movie get(int id) {
        String query = "SELECT * FROM Movies WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int movieId = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String genre = resultSet.getString("genre");
                LocalDate release = resultSet.getDate("release").toLocalDate();
                int director = resultSet.getInt("directors");
                return new Movie(movieId, title, genre, release, director);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    @Override
    public void save(Movie movie) {
        String query = "INSERT INTO Movies (id, title, genre, `release`, directors) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, movie.getId());
            statement.setString(2, movie.getTitle());
            statement.setString(3, movie.getGenre());
            statement.setDate(4, Date.valueOf(movie.getRelease()));
            statement.setInt(5, movie.getDirector());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete(Movie movie) {
        String query = "DELETE FROM Movies WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, movie.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Movie> get (Director d) {
        List<Movie> movies = new ArrayList<>();
        String query = "SELECT * FROM Movies WHERE directors = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, d.getId());

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int movieId = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String genre = resultSet.getString("genre");
                LocalDate release = resultSet.getDate("release").toLocalDate();
                int director = resultSet.getInt("directors");
                Movie movie = new Movie(movieId, title, genre, release, director);
                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
