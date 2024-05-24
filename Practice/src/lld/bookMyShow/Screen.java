package lld.bookMyShow;

import java.util.List;

public class Screen {
    int screenId;
    List<Seat> seats;

    ScreenType screenType;

    public Screen(int screenId, List<Seat> seats, ScreenType screenType) {
        this.screenId = screenId;
        this.seats = seats;
        this.screenType = screenType;
    }

    @Override
    public String toString() {
        return STR."Screen{screenId=\{screenId}, screenType=\{screenType}\{'}'}";
    }
}
