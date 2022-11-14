package com.quickPay.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorHandle> globalException(Exception exception, WebRequest wr) {

		ErrorHandle eh = new ErrorHandle(LocalDateTime.now(), exception.getMessage(), wr.getDescription(false));

		return new ResponseEntity<ErrorHandle>(eh, HttpStatus.BAD_REQUEST);

	}

	// Customer exception
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<ErrorHandle> customerException(CustomerException exception, WebRequest wr) {

		ErrorHandle eh = new ErrorHandle(LocalDateTime.now(), exception.getMessage(), wr.getDescription(false));

		return new ResponseEntity<ErrorHandle>(eh, HttpStatus.BAD_REQUEST);

	}

	// Customer exception
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<ErrorHandle> loginException(LoginException exception, WebRequest wr) {

		ErrorHandle eh = new ErrorHandle(LocalDateTime.now(), exception.getMessage(), wr.getDescription(false));

		return new ResponseEntity<ErrorHandle>(eh, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(BeneficiaryException.class)
	public ResponseEntity<ErrorHandle> myexceptionHandler(BeneficiaryException ie, WebRequest req) {

		ErrorHandle err = new ErrorHandle();

		err.setLdt(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDescription(req.getDescription(false));

		return new ResponseEntity<ErrorHandle>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorHandle> globalException2(NoHandlerFoundException exception, WebRequest wr) {

		ErrorHandle eh = new ErrorHandle(LocalDateTime.now(), exception.getMessage(), wr.getDescription(false));

		return new ResponseEntity<ErrorHandle>(eh, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorHandle> globalException3(MethodArgumentNotValidException exception) {

		ErrorHandle eh = new ErrorHandle(LocalDateTime.now(), "Validation Error",
				exception.getBindingResult().getFieldError().getDefaultMessage());

		return new ResponseEntity<ErrorHandle>(eh, HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(TransactionException.class)
	public ResponseEntity<ErrorHandle> transactionHandler(TransactionException te, WebRequest wr) {

		ErrorHandle eh = new ErrorHandle(LocalDateTime.now(), te.getMessage(), wr.getDescription(false));

		return new ResponseEntity<ErrorHandle>(eh, HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(BillPaymentNotFoundException.class)
	public ResponseEntity<ErrorHandle> BillPaymentNotFoundException(BillPaymentNotFoundException te, WebRequest wr) {

		ErrorHandle eh = new ErrorHandle(LocalDateTime.now(), te.getMessage(), wr.getDescription(false));

		return new ResponseEntity<ErrorHandle>(eh, HttpStatus.BAD_REQUEST);

	}
	
}
