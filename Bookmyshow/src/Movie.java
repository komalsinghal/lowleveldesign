import java.util.UUID;

public class Movie {
    String movieId;
    String movieName;

    public Movie(String movieName) {
        this.movieName = movieName;
        this.movieId = UUID.randomUUID().toString();
    }
}
