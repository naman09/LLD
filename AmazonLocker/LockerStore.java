import java.util.List;
import java.time.LocalDateTime;

public class LockerStore {
    private List<Locker> lockers;
    private Location location;
    private LocalDateTime storeOpeningTime;
    private LocalDateTime storeClosingTime;

    public Boolean isStoreOpen() {
        return true;
    }

    private Locker requestLocker(Size requiredSize) throws LockerUnavailableException {
        // find an available locker with size >= requiredSize
        // set locker state = booked
        return null;
    }

    public void deliverItem(User user, Size itemSize) {
        // request a locker
        // after item is delivered code is sent to user
    }

    public void returnItem(User user, Size itemSize) {
        // check if item is elgible for locker services
        // request a locker
        // generate a code and send it to user
    }
}
