public class User {
    private String userId;
    private String email;
    private String mobile;
    private Location location;

    public User(String userId, String email, String mobile, Location location) {
        this.userId = userId;
        this.email = email;
        this.mobile = mobile;
        this.location = location;
    }

    public String getUserId() {
        return this.userId;
    }
    public String getEmail() {
        return this.email;
    }
}
