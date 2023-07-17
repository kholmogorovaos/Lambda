import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DirectorRepositoryImpl implements DirectorRepository {
    private Connection connection;
    public DirectorRepositoryImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public Director get(int id) {
        String query = "SELECT * FROM Directors WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int directorId = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                LocalDate birthDate = resultSet.getDate("birth_date").toLocalDate();
                String country = resultSet.getString("country");

                return new Director(directorId, firstName, lastName, birthDate, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Director director) {
        String query = "INSERT INTO Directors (id, first_name, last_name, birth_date, country) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, director.getId());
            statement.setString(2, director.getFirstName());
            statement.setString(3, director.getLastName());
            statement.setDate(4, Date.valueOf(director.getBirthDate()));
            statement.setString(5, director.getCountry());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Director director) {
        String query = "DELETE FROM Directors WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, director.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Director> get(List<String> genres) {
        List<Director> directors = new ArrayList<>();
        StringBuilder placeholders = new StringBuilder();
        for (int i = 0; i < genres.size(); i++) {
            placeholders.append("?");
            if (i < genres.size() - 1) {
                placeholders.append(",");
            }
        }
        String query = "SELECT DISTINCT d.* FROM Directors d INNER JOIN Movies m ON d.id = m.directors WHERE m.genre IN (" + placeholders.toString() + ")";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            for (int i = 0; i < genres.size(); i++) {
                statement.setString(i + 1, genres.get(i));
            }

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int directorId = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                LocalDate birthDate = resultSet.getDate("birth_date").toLocalDate();
                String country = resultSet.getString("country");

                Director director = new Director(directorId, firstName, lastName, birthDate, country);
                directors.add(director);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return directors;
        }
}
