package interview.test.service.helper;

import java.io.ByteArrayOutputStream;

/**
 * Represents a generated report file (excel).
 */
public class ReportFile {
	
	private String fileName;
	private ByteArrayOutputStream outputStream;
	
	//-------------------------------------------------------------------------
	//PUBLIC CONSTANTS
	//-------------------------------------------------------------------------

	//-------------------------------------------------------------------------
	//PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
	//-------------------------------------------------------------------------

	// private static final Log LOG = LogFactory.getLog(ReportFile.class);

	//-------------------------------------------------------------------------
	//CONSTRUCTORS
	//-------------------------------------------------------------------------

	public ReportFile() {
	}
	
	public ReportFile(String fileName, ByteArrayOutputStream byteOutputStream) {
		this.fileName = fileName;
		this.outputStream = byteOutputStream;
	}

	//-------------------------------------------------------------------------
	//PUBLIC METHODS
	//-------------------------------------------------------------------------

	//-------------------------------------------------------------------------
	//PROTECTED METHODS
	//-------------------------------------------------------------------------

	//-------------------------------------------------------------------------
	//PRIVATE METHODS
	//-------------------------------------------------------------------------

	//-------------------------------------------------------------------------
	//PUBLIC ACCESSORS (GETTERS / SETTERS)
	//-------------------------------------------------------------------------    

	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public ByteArrayOutputStream getOutputStream() {
		return outputStream;
	}
	
	public void setOutputStream(ByteArrayOutputStream outputStream) {
		this.outputStream = outputStream;
	}

}
