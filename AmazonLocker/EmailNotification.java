public class EmailNotification implements Notification {
    public void sendNotification(User user, LockerCode lockerCode) {
        System.out.println("code " + lockerCode.getCode() + " user " + user.getUserId() + " email " + user.getEmail());
    }
}
