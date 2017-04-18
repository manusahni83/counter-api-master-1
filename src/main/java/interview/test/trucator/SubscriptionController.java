package interview.test.trucator;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SubscriptionController {

    // as written in question, i assume following service would be spring injeted by configuring it in service-context.xml
private LogTruncator logTruncator;

public LogTruncator getLogTruncator() {
        return logTruncator;
    }

public void setLogTruncator(LogTruncator logTruncator) {
        this.logTruncator = logTruncator;
    }

@RequestMapping (value = "/subscribe" , method = RequestMethod. GET )
public String subscribe(HttpServletRequest request ) {

    // assumed that getOrderDeatils will fetch data
String orderDetails = getOrderDetails( request );
String truncatedOrderDetails = truncate( orderDetails, 250 );
log( truncatedOrderDetails );
return truncatedOrderDetails;

}

private String getOrderDetails(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return "1234567890";
}

private String truncate(String orderDetails, int length) {

    return logTruncator.truncate(orderDetails, length);
}

private void log(String truncatedOrderDetails) {
    // log using any logger framework
    
}

}
