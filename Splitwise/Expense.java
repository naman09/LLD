import java.util.Map;

public class Expense {
    String expenseId;
    Double totalAmount;
    User expenseBy;

    ExpenseType expenseType;

    Map<User, Double> userShareMap;

    Expense(String expenseId, ExpenseType expenseType, Double totalAmount, User expenseBy, Map<User, Double> userShareMap) {
        this.expenseId = expenseId;
        this.totalAmount = totalAmount;
        this.expenseBy = expenseBy;
        this.userShareMap = userShareMap;
        this.expenseType = expenseType;
    }

    Map<User, Double> getExactUserShareMap() {
        if (expenseType == ExpenseType.EXACT || expenseType == ExpenseType.EQUAL) {
            return userShareMap;
        }
        //calc for equal
        //calc from perc.
        return null;
    }

}
