public class EmailException extends Exception{
    public EmailException() {
        super("Email không được để trống");
    }

    public EmailException(String message) {
        super(message);
    }
}
