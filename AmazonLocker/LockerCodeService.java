import java.util.Map;

public class LockerCodeService {
    Map<Locker, LockerCode> lockerCodeMap;


    public Boolean isValid(Locker locker, String code) {
        // get Locker code from map
        // validate code expiry (time elapsed <= 3) 
        // validate code
        return false;
    }

    public String generate(Locker locker, Integer codeExpireAfterDays) {
        // generate pin
        // store it in map
        return "123456";
    }

    public void expire(Locker locker) {

    }
}
