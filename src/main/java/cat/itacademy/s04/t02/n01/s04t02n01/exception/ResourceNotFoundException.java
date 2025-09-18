package cat.itacademy.s04.t02.n01.s04t02n01.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
