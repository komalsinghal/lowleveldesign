import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Show {
    String showId;
    Movie movie;
    Screen screen;
    LocalDateTime startTime;
    double duration;
    List<Seat> seats;

    public Show(String showId, Movie movie, Screen screen, LocalDateTime startTime, double duration) {
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.duration = duration;
        this.seats = screen.getSeats();
    }


    public String getShowId() {
        return showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public double getDuration() {
        return duration;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
