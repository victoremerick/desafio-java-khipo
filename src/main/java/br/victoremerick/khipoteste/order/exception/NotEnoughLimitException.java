package br.victoremerick.khipoteste.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class NotEnoughLimitException extends RuntimeException{

    public NotEnoughLimitException(){
        super("The client doesn't have limit to complete this transaction.");
    }
}
