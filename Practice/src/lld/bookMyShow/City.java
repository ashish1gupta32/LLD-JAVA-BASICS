package lld.bookMyShow;

public class City {
    String cityName;

    public City(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return STR."\{cityName}";
    }
}
