import java.time.LocalDateTime;

public class LockerCode {
    private String code;
    private LocalDateTime tLocalDateTime;

    LockerCode(String code) {
        this.code = code;
        this.tLocalDateTime = LocalDateTime.now();
    }

    public String getCode() {
        return this.code;
    }
}
