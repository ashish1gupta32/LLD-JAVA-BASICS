package lld.bookMyShow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TheaterController {
    Map<City, List<Theater>> cityTheaterMapping;
    List<Theater> theaterList;

    TheaterController() {
        cityTheaterMapping = new ConcurrentHashMap<>();
        theaterList = new ArrayList<>();

    }
    public void addTheater(Theater theater){
        if(!theaterList.contains(theater))theaterList.add(theater);
    }

    public void addTheater(City city,Theater theater){
        addTheater(theater);
        cityTheaterMapping.computeIfAbsent(city,(_)->new ArrayList<>()).add(theater);
    }

    public List<Theater> getAllTheaterByCity(City city) {
        return cityTheaterMapping.get(city);
    }
}
