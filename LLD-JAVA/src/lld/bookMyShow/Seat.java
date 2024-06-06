package lld.bookMyShow;

public class Seat {
    SeatType seatType;
    int seatNo;
    int price;

    public Seat(SeatType seatType, int seatNo, int price) {
        this.seatType = seatType;
        this.seatNo = seatNo;
        this.price = price;
    }

    @Override
    public String toString() {
        return STR."Seat{seatType=\{seatType}, seatNo=\{seatNo}, price=\{price}\{'}'}";
    }
}
