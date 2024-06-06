package lld.bookMyShow;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Show {
    int showId;
    Movie movie;
    Screen screen;
    LocalDateTime startTime;
    List<Integer> bookedSeat;

    public Show(int showId, Movie movie, Screen screen, LocalDateTime startTime) {
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.bookedSeat = new ArrayList<>();
    }
    public void reserveSeat(int seatId){bookedSeat.add(seatId);}

    public List<Integer> getBookedSeat() {
        return bookedSeat;
    }

    @Override
    public String toString() {
        return STR."Show{showId=\{showId}, movie=\{movie}, screen=\{screen}, \nstartTime=\{startTime}, Already bookedSeat=\{bookedSeat.stream().map(String::valueOf).reduce((val1, val2)-> STR."\{val1},\{val2}").orElse("EMPTY")}";
    }
}
