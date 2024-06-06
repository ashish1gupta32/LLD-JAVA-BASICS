package lld.bookMyShow;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class BookMyShow {

    MovieController movieController;
    TheaterController theaterController;

    BookMyShow() {
        movieController = new MovieController();
        theaterController = new TheaterController();
    }

    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();

        for (int i=0;i<100;i++) {
            bookMyShow.createBooking("PUNE", "Movie1");
            bookMyShow.createBooking("PUNE", "Movie2");
            bookMyShow.createBooking("DELHI", "Movie1");
            bookMyShow.createBooking("DELHI", "Movie2");
        }

//        bookMyShow.createBooking("PUNE", "Movie1");
//        bookMyShow.createBooking("PUNE", "Movie2");
//        bookMyShow.createBooking("DELHI", "Movie1");
//        bookMyShow.createBooking("DELHI", "Movie2");
    }

    private void createBooking(String cityString, String movieString) {
        System.out.println(STR."Booking started for movie \{movieString} for city \{cityString}");
        City city = movieController.getCityByName(cityString);
//        City Movie = movieController.getCityByName(movieString);

        List<Movie> movies = movieController.getAllMovieByCity(city);

        Movie movie = movies.stream().filter(movie1 -> movie1.name.equalsIgnoreCase(movieString)).findFirst().orElse(null);

        Theater theater1 = theaterController.getAllTheaterByCity(city).stream()
                .filter((theater) -> theater.showList.stream().anyMatch(show -> show.movie.name.equalsIgnoreCase(movieString)))
                .findFirst().orElse(null);
//        System.out.println(STR."Theater selected = \{theater1}");
        if (theater1 == null) {
            System.out.println("No theater found, try again\n");
            return;
        }
        Show show = theater1.showList.stream().filter(((showTmp) -> showTmp.movie.name.equalsIgnoreCase(movieString))).findFirst().orElse(null);
        System.out.println(STR."Show selected =\{show}");

        if (show == null) {
            System.out.println("No show found, try again\n");
            return;
        }

//        Map.Entry
        List<Integer> bookedSeat = show.getBookedSeat();

        int seatId = ThreadLocalRandom.current().nextInt(100);
        System.out.println(STR."SeatId selected \{seatId}");

        if (!bookedSeat.contains(seatId)) {
            synchronized (this) {
                bookedSeat.add(seatId);
                Seat seat = show.screen.seats.stream()
                        .filter((val) -> val.seatNo == seatId)
                        .findFirst().orElse(null);
                if (seat != null) {
                    System.out.println(STR."Seat found for seatId \{seatId} = \{seat}");
                    Booking booking = new Booking(ThreadLocalRandom.current().nextInt(100), show, new ArrayList<>(List.of(seat)), new Payment());
                    booking.payment.payBill(booking);
                }
            }
        } else {
            System.out.println("seat already booked,try again\n");
            return;
        }

        System.out.println("Booking Completed\n");
    }

    private void initialize() {
        initializeMovieController();
        initializeTheaterController();
    }


    private void initializeMovieController() {
        City city1 = new City("PUNE");
        City city2 = new City("DELHI");
        Movie movie1 = new Movie(1, "Movie1", 120);
        Movie movie2 = new Movie(2, "Movie2", 135);
        movieController.addMovie(city1, movie1);
        movieController.addMovie(city1, movie2);
        movieController.addMovie(city2, movie1);
        movieController.addMovie(city2, movie2);
    }

    private void initializeTheaterController() {
        Movie movie1 = movieController.getMovieByName("Movie1");
        Movie movie2 = movieController.getMovieByName("Movie2");

        City pune = movieController.getCityByName("Pune");
        City delhi = movieController.getCityByName("Delhi");

        Screen screen1 = new Screen(1, getAllSeats(), ScreenType.HINDI3D);
        Screen screen2 = new Screen(2, getAllSeats(), ScreenType.HINDI3D);
        Screen screen3 = new Screen(1, getAllSeats(), ScreenType.HINDI3D);
        Screen screen4 = new Screen(2, getAllSeats(), ScreenType.HINDI3D);

        Theater theater1 = new Theater(1, pune);
        Theater theater2 = new Theater(2, delhi);

        theater1.addScreen(screen1);
        theater1.addScreen(screen2);
        theater2.addScreen(screen1);
        theater2.addScreen(screen2);

        Show show1 = new Show(1, movie1, screen1, LocalDateTime.now().plusMinutes(150));
        Show show2 = new Show(1, movie2, screen2, LocalDateTime.now().plusMinutes(170));
        Show show3 = new Show(1, movie1, screen3, LocalDateTime.now().plusMinutes(90));
        Show show4 = new Show(1, movie2, screen4, LocalDateTime.now().plusMinutes(189));

        theater1.addShow(show1);
        theater1.addShow(show2);
        theater2.addShow(show3);
        theater2.addShow(show4);

        theaterController.addTheater(theater1);
        theaterController.addTheater(theater2);
        theaterController.addTheater(pune, theater1);
        theaterController.addTheater(delhi, theater2);

    }

    private List<Seat> getAllSeats() {
        return IntStream.range(0, 100).mapToObj((id) -> {
            if (id < 50) return new Seat(SeatType.SILVER, id, 120);
            else if (id < 80) return new Seat(SeatType.SILVER, id, 160);
            else return new Seat(SeatType.SILVER, id, 200);
        }).toList();
    }
}
