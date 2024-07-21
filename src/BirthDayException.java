public class BirthDayException extends Exception {
    public BirthDayException() {
        super("Ngày sinh không được để trống");
    }

    public BirthDayException(String message) {
        super(message);
    }

}
