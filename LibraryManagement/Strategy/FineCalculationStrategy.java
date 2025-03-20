package Strategy;

import Models.BookLoan;

public interface FineCalculationStrategy {
    Double calculateFine(BookLoan bookLoan);
}
