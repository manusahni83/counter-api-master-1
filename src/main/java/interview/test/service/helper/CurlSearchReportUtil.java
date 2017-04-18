package interview.test.service.helper;

import interview.test.curl.domain.SearchResult;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map.Entry;
import java.util.Set;

import sunrise.xip.abusetool.service.report.ReportOutputType;



/**
 * Helper class for generating CSV report
 */
public class CurlSearchReportUtil {

    private static final String CSV_FIELD_SEPARATOR = ";";
    private static final String EMPTY_STRING = "";
    private static final String REPORT_NAME = "Report_";

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private static final SimpleDateFormat FILE_NAME_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");

    public static ReportFile generateReportInCSV(SearchResult searchResult) throws IOException {
        String reportContent = "";
        Set<Entry<String, Integer>> entrySet = searchResult.getCounts().entrySet();
        for (Entry<String, Integer> entry : entrySet) {

            reportContent = reportContent + addRecord(entry.getKey(), entry.getValue()) + addNewline();
        }
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(reportContent.getBytes());
        
        
        return new ReportFile(getReportFileName(), outputStream);
    }

    public static String addRecord(String key, Integer value) {
        // TODO Auto-generated method stub
        return cleanNull(key) + CSV_FIELD_SEPARATOR + cleanNull(value);
    }

    public static String cleanNull(Object value) {
        return value == null ? EMPTY_STRING : value.toString();
    }

    public static String getReportFileName() {
        synchronized (FILE_NAME_DATE_FORMAT) {
            return REPORT_NAME + FILE_NAME_DATE_FORMAT.format(Calendar.getInstance().getTime())  + ReportOutputType.CSV.getSuffix();
        }
    }

    public static String addNewline() {
        return LINE_SEPARATOR;
    }

}
