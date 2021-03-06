package pro.sky.secondcoursework.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionExistsException extends RuntimeException {

    public QuestionExistsException() {
        super("This question already exists!");
    }
}
