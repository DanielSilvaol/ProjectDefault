package br.edu.projectdefault.Error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ValidacaoHandler {

    private final MessageSource source;

    @Autowired
    public ValidacaoHandler(@Qualifier("messageSource") MessageSource source) {
        this.source = source;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroDeFormTO> Handler(MethodArgumentNotValidException e){

        List<ErroDeFormTO> to = new ArrayList<>();

        final List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();

        fieldErrors.forEach(error -> {
            String msg = source.getMessage(error, LocaleContextHolder.getLocale());
            ErroDeFormTO form = new ErroDeFormTO(error.getField(),msg);
            to.add(form);
        });


        return to;


    }
}
