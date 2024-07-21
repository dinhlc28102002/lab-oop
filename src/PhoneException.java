public class PhoneException extends Exception{
    public PhoneException() {
        super("Số điện thoại không được để trống");
    }

    public PhoneException(String message) {
        super(message);
    }
}
