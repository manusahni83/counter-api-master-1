package interview.test.curl.controller;

import interview.test.curl.domain.CurlRestException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RestController {
    
    public ResponseEntity<Object> responseOk(Object o) {
        return new ResponseEntity<Object>(o, HttpStatus.OK);
    }

    public ResponseEntity<Object> responseNotFound() {
        return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Object> responseGeneralException(String message) {
        CurlRestException exception = new CurlRestException();
        exception.getErrorMessage().add(message);
        return new ResponseEntity<Object>(exception, HttpStatus.BAD_REQUEST);
    }

}
