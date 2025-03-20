package Services;

import CustomExceptions.BookIssueException;
import Models.BookCopy;
import Models.BookLoan;
import Models.Member;
import Strategy.FineCalculationStrategy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static Common.Constants.MAX_ISSUE_COUNT;
import static Common.Constants.MAX_ISSUE_DAYS;

public class LendingService {
    ReservationService reservationService;
    Map<Member, List<BookLoan>> memberIssuedBooks;

    FineCalculationStrategy fineCalculationStrategy;
    public void issueBook(BookCopy bookCopy, Member issueBy, Integer issueForDays) throws BookIssueException {
        if (issueForDays > MAX_ISSUE_DAYS) {
            throw new BookIssueException("Cannot issue book for more than" + MAX_ISSUE_DAYS.toString());
        }
        if (memberIssuedBooks.get(issueBy).size() > MAX_ISSUE_COUNT) {
            throw new BookIssueException("Member " + issueBy.toString() + "has already reached max issue limit");
        }
        if (!bookCopy.getIsAvailable()) {
            reservationService.reserveBook(bookCopy.getBook(), issueBy, new Date());
            throw new BookIssueException("Book unavailable");
        }

        bookCopy.setIsAvailable(false);
        if (!memberIssuedBooks.containsKey(issueBy)) {
            memberIssuedBooks.put(issueBy, new ArrayList<>());
        }
        BookLoan bookLoan = new BookLoan(issueBy, new Date(), new Date(System.currentTimeMillis() + issueForDays * 24 * 3600 * 1000));
        bookCopy.setBookLoan(bookLoan);
        memberIssuedBooks.get(issueBy).add(bookLoan);
    }

    public void returnBook(BookCopy bookCopy) {
        BookLoan bookLoan = bookCopy.getBookLoan();
        memberIssuedBooks.get(bookLoan.getIssuedBy()).remove(bookLoan);
        fineCalculationStrategy.calculateFine(bookLoan);
        reservationService.notifyBookAvailable(bookCopy);
    }
}
