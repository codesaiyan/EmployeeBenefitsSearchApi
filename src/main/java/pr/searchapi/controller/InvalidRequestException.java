package pr.searchapi.controller;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidRequestException extends RuntimeException {

	private static final long serialVersionUID = -5546978960396755588L;

	public InvalidRequestException(String message) {
		super(message);
	}

}
