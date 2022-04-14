package pro.sky.secondcoursework.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class ActionNotAllowedException extends RuntimeException {

    public ActionNotAllowedException() {
        super("Method is not allowed");
    }
}
