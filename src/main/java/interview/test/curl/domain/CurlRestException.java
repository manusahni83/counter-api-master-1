package interview.test.curl.domain;

import java.util.ArrayList;
import java.util.List;

public class CurlRestException {

    private List<String> errorMessage;

    public List<String> getErrorMessage() {
        if (errorMessage == null) {
            errorMessage = new ArrayList<String>();
        }
        return errorMessage;
    }

    public void setErrorMessage(List<String> errorMessage) {
        this.errorMessage = errorMessage;
    }

}
