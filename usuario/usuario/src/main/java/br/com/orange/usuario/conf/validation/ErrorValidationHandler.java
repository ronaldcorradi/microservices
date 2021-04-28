package br.com.orange.usuario.conf.validation;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.orange.usuario.conf.validation.dto.ErrorFormDTO;

@RestControllerAdvice
public class ErrorValidationHandler {
	
	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErrorFormDTO> handle(MethodArgumentNotValidException exception) {
		
		List<ErrorFormDTO> errors = new ArrayList<>();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e -> {
			String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErrorFormDTO error = new ErrorFormDTO(e.getField(),message);
			errors.add(error);
		});
		return errors;		
	}
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ConstraintViolationException.class)
	public List<ErrorFormDTO> handle(ConstraintViolationException exception) {
		
		List<ErrorFormDTO> errors = new ArrayList<>();		
		errors.forEach(e -> {
			String message = exception.getLocalizedMessage();
			ErrorFormDTO error = new ErrorFormDTO(e.getCampo(),message);
			errors.add(error);
		});
		return errors;		
	}
		
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(DataIntegrityViolationException.class)
	public List<ErrorFormDTO> handle(DataIntegrityViolationException exception) {
		
		List<ErrorFormDTO> errors = new ArrayList<>();	
		errors.forEach(e -> {
			String message = exception.getLocalizedMessage();
			ErrorFormDTO error = new ErrorFormDTO(e.getCampo(),message);
			errors.add(error);
		});
		return errors;		
	}
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public List<ErrorFormDTO> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException exception) {
		
		List<ErrorFormDTO> errors = new ArrayList<>();	
		errors.forEach(e -> {
			String message = exception.getLocalizedMessage();
			ErrorFormDTO error = new ErrorFormDTO(e.getCampo(),message);
			errors.add(error);
		});
		return errors;		
	}
	

	
}
