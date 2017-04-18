package interview.test.curl.controller;

import interview.test.curl.domain.Search;
import interview.test.curl.domain.SearchResult;
import interview.test.service.LookupService;
import interview.test.service.helper.CurlSearchReportUtil;
import interview.test.service.helper.ReportFile;

import java.io.IOException;

import javax.annotation.Resource;
import javax.ws.rs.Produces;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CurlRestController extends RestController {

    private static Log log = LogFactory.getLog(CurlRestController.class);

    @Resource(name = "li.service.CurlLookupService")
    private LookupService lookupService;


    @RequestMapping(value = "/rest/host/counter-api/search", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> searchRecords(@RequestBody Search search) {
        SearchResult result = null;
        result = getLookupService().search(search);

        return responseOk(result);

    }

    @RequestMapping(value = "/rest/host/counter-api/search/top/{count}", method = RequestMethod.GET)
    @ResponseBody
    @Produces({ "text/csv" })
    public ResponseEntity<Object> getReport(@PathVariable("count") String count) {
        SearchResult result = null;
        result = getLookupService().wordCount(count);
        return getReportFile(result);

    }

    private ResponseEntity<Object> getReportFile(SearchResult searchResult) {
        try {
            ReportFile file = CurlSearchReportUtil.generateReportInCSV(searchResult);
            MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
            params.add("Content-Disposition", "attachment; filename=" + file.getFileName());
            params.add("Content-Type", "text/csv");
            return new ResponseEntity<Object>(file.getOutputStream().toByteArray(), params, HttpStatus.OK);
        } catch (IOException e) {
            log.error("Exception while generating file" + e.getMessage());
            return responseGeneralException(e.getMessage());
        }
    }
    
    public LookupService getLookupService() {
        return lookupService;
    }

    public void setLookupService(LookupService lookupService) {
        this.lookupService = lookupService;
    }

}
