package Models;

import java.util.Date;
import java.util.List;

public class BookLoan {
    String id;
    Member issuedBy;
    Date issuedDate;
    Date returnDate;
    Boolean isPending;

    public BookLoan(Member issuedBy, Date issuedDate, Date returnDate) {
        this.issuedBy = issuedBy;
        this.issuedDate = issuedDate;
        this.returnDate = returnDate;
        this.isPending = true;
    }

    public void setPending(Boolean pending) {
        isPending = pending;
    }

    public Member getIssuedBy() {
        return this.issuedBy;
    }

    @Override
    public boolean equals(Object obj) {
        BookLoan bookLoan = (BookLoan) obj;
        return this.id == bookLoan.id;
    }
}
