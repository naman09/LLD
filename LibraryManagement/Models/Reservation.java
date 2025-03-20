package Models;

import java.util.Date;

public class Reservation {
    Member reservedBy;
    Date reservationDate;

    Book reservedBook;

    public Reservation(Member reservedBy, Date reservationDate, Book reservedBook) {
        this.reservedBy = reservedBy;
        this.reservationDate = reservationDate;
        this.reservedBook = reservedBook;
    }

    public Member getReservedBy() {
        return this.reservedBy;
    }
}
