package project.stas.core.utilities.results;

public class ErrorResult extends Result {

	// SUCCESS PARAMETRELİ BOŞ CONSTRUCTOR
	public ErrorResult() {
		super(false);
	}

	// SUCCESS VE MESSAGE PARAMETRELİ CONSTRUCTOR
	public ErrorResult(String message) {
		super(false, message);

	}

}
