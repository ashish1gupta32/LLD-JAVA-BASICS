package lld.bookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    Map<City, List<Movie>> cityMovieMapping;
    List<Movie> movieList;

    MovieController() {
        cityMovieMapping = new HashMap<>();
        movieList = new ArrayList<>();
    }

    //scheduler to update movie mapping daily
    public void addMovie(Movie movie) {
        if (!movieList.contains(movie)) movieList.add(movie);
    }

    public void addMovie(City city, Movie movie) {
        addMovie(movie);
        cityMovieMapping.computeIfAbsent(city, (_) -> new ArrayList<>()).add(movie);
    }

    public Movie getMovieByName(String movieString) {
        return movieList.stream()
                .filter((movie) -> movie.name.equalsIgnoreCase(movieString))
                .findFirst().orElse(null);
    }

    public City getCityByName(String cityString) {
        return cityMovieMapping.keySet().stream()
                .filter((city) -> city.cityName.equalsIgnoreCase(cityString))
                .findFirst().orElse(null);
    }

    public List<Movie> getAllMovieByCity(City city){
        return cityMovieMapping.get(city);
    }

}
