public class FullNameException extends Exception{
    public FullNameException() {
        super("Full name không được để trống");
    }

    public FullNameException(String message) {
        super(message);
    }
}
