package project.stas.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T> {

	public SuccessDataResult() {
		super(true);
	}

	public SuccessDataResult(String message) {
		super(true, message);
	}

	public SuccessDataResult(T data, String message) {
		super(data, true, message);

	}

}
