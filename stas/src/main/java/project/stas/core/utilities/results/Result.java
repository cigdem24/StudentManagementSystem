package project.stas.core.utilities.results;

public class Result {

	private boolean success;
	private String message;

	// SUCCESS PARAMETRELİ BOŞ CONSTRUCTOR
	public Result(boolean success) {
		this.success = success;
	}

	// SUCCESS VE MESSAGE PARAMETRELİ CONSTRUCTOR
	public Result(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	// GET AND SET METODLARI
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
