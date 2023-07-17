import java.time.LocalDate;
import java.util.Objects;
public class Movie {
    private int id;
    private String title;
    private String genre;
    private LocalDate release;
    private int director;

    public Movie(int id, String title, String genre, LocalDate release, int director) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.release = release;
        this.director = director;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public LocalDate getRelease() {
        return release;
    }

    public int getDirector() {
        return director;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Movie movie = (Movie) obj;
        return id == movie.id &&
                Objects.equals(title, movie.title) &&
                Objects.equals(genre, movie.genre) &&
                Objects.equals(release, movie.release) &&
                director == movie.director;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, genre, release, director);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", release=" + release +
                ", director='" + director + '\'' +
                '}';
    }
}
