package interview.test.service.helper;

/**
 * Defines the output types for a report
 */
public enum ReportOutputType {
	
    PDF("application/pdf", ".pdf"),
    EXCEL("application/ms-excel", ".xls"),
    HTML("text/html", ".html"),
    CSV("text/csv", ".csv");
	
	private String contentType; // the mimeType
	private String suffix; // the file suffix
	
	private ReportOutputType(String contentType, String suffix) {
		this.contentType = contentType;
		this.suffix = suffix;
	}
	
	public String getContentType() {
		return contentType;
	}
	
	public String getSuffix() {
		return suffix;
	}
}
