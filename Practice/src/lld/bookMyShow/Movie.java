package lld.bookMyShow;

public class Movie {
    int id;
    String name;
    int durationInMinute;

    public Movie(int id, String name, int durationInMinute) {
        this.id = id;
        this.name = name;
        this.durationInMinute = durationInMinute;
    }

    @Override
    public String toString() {
        return STR."Movie{id=\{id}, name='\{name}\{'\''}, durationInMinute=\{durationInMinute}\{'}'}";
    }
}
