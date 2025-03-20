package Services;

import Models.Book;
import Models.BookCopy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookCatalogService {
    Map<String, Book> bookByTitleMap;

    Map<Book, List<BookCopy>> bookListMap;
    ReservationService reservationService;

    void addNewCopy(BookCopy bookCopy) {
        if (!bookListMap.containsKey(bookCopy.getBook())) {
            bookListMap.put(bookCopy.getBook(), new ArrayList<>());
        }
        bookListMap.get(bookCopy.getBook()).add(bookCopy);
        reservationService.notifyBookAvailable(bookCopy);
    }

}
