package Services;

import Models.Book;
import Models.BookCopy;
import Models.Member;
import Models.Reservation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ReservationService {
    Map<Book, List<Reservation>> bookReservationMap;
    NotificationService notificationService;
    void notifyBookAvailable(BookCopy bookCopy) {
        for(Reservation reservation : bookReservationMap.get(bookCopy.getBook())) {
            Member reservedBy = reservation.getReservedBy();
            notificationService.sendNotification(reservedBy.getEmail());
        }
    }
    void reserveBook(Book book, Member reservedBy, Date reservationDate) {
        if (!bookReservationMap.containsKey(book)) {
            bookReservationMap.put(book, new ArrayList<>());
        }
        bookReservationMap.get(book).add(new Reservation(reservedBy, reservationDate, book));
    }
}
