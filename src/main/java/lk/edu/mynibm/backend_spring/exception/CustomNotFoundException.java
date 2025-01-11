package lk.edu.mynibm.backend_spring.exception;

public class CustomNotFoundException extends RuntimeException{

    public CustomNotFoundException(String message) {
        super(message);
    }
}
