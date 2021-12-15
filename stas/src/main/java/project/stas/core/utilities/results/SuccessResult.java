package project.stas.core.utilities.results;

public class SuccessResult extends Result {

	// SUCCESS PARAMETRELİ BOŞ CONSTRUCTOR
	public SuccessResult() {
		super(true);
	}

	// SUCCESS VE MESSAGE PARAMETRELİ CONSTRUCTOR
	public SuccessResult(String message) {
		super(true, message);
	}

}
