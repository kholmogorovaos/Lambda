import java.time.LocalDate;
import java.util.Objects;

public class Director {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String country;

    public Director(int id, String firstName, String lastName, LocalDate birthDate, String country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getCountry() {
        return country;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Director director = (Director) obj;
        return id == director.id &&
                Objects.equals(firstName, director.firstName) &&
                Objects.equals(lastName, director.lastName) &&
                Objects.equals(birthDate, director.birthDate) &&
                Objects.equals(country, director.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthDate, country);
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", country='" + country + '\'' +
                '}';
    }
}
