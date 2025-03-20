public abstract class LogLevel {
    private Integer value;

    LogLevel(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public String toString() {
        return this.getClass().getName();
    }
}
