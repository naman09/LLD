import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Singleton
public class App {
    Map<String, Map<String, Double>> expenseTrackerMap;
    Map<String, User> userMap;
    List<Expense> expenseList;

    private App() {
        userMap.put("u1", new User("u1"));
        userMap.put("u2", new User("u2"));
        userMap.put("u3", new User("u3"));
        userMap.put("u4", new User("u4"));
    }

    static App app;
    static App getApp () {
        if (app == null) {
            return new App();
        }
        return app;
    }
    void addExpense(Expense expense) {
        expenseList.add(expense);
        Map<String, Double> userExpenses;
        if (expenseTrackerMap.containsKey(expense.expenseBy)) {
            userExpenses = expenseTrackerMap.get(expense.expenseBy);
        } else {
            userExpenses = new HashMap<String, Double>();
        }
        Map<User, Double> userShare = expense.getExactUserShareMap();
        for(User user : userShare.keySet()) {
            Double currentOwe = 0.0;
            if (userExpenses.containsKey(user.userId)) {
                currentOwe = userExpenses.get(user.userId);
            }
            userExpenses.put(user.userId, currentOwe + userShare.get(user));
        }
    }

    void showUserExpenses(User user) {
        for (String userOwed : expenseTrackerMap.get(user.userId).keySet()) {
            Double amountOwed = expenseTrackerMap.get(user.userId).get(userOwed);
            if(amountOwed >= 0) {
                System.out.println(user.userId + " owes " + userOwed + " $" + amountOwed);
            } else {
                System.out.println(userOwed + " owes " + user.userId + " $" + amountOwed);
            }
        }
    }

    void showAllBalances() {
        for(User user : userMap.values()) {
            showUserExpenses(user);
        }
    }

}
