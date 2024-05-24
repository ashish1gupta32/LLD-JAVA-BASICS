package lld.bookMyShow;

import java.util.ArrayList;
import java.util.List;

public class Theater {
    int theaterId;
    List<Screen> screenList;
    List<Show> showList;
    City city;

    Theater(int theaterId, City city) {
        this.theaterId = theaterId;
        screenList = new ArrayList<>();
        showList = new ArrayList<>();
        this.city = city;
    }

    void addScreen(Screen screen) {
        screenList.add(screen);
    }

    void addShow(Show show) {
        showList.add(show);
    }

    @Override
    public String toString() {
        return STR."Theater{theaterId=\{theaterId}, city=\{city}\{'}'}";
    }
}
