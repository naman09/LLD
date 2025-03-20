package Models;

public class BookCopy {
    Barcode uniqueBarcode;
    String rackPosition;
    Book book;
    Boolean isAvailable;
    BookLoan bookLoan;

    public Book getBook() {
        return this.book;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public BookLoan getBookLoan() {
        return this.bookLoan;
    }

    public void setBookLoan(BookLoan bookLoan) {
        this.bookLoan = bookLoan;
    }
}
