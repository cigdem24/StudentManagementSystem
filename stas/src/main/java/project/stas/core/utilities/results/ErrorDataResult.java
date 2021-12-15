package project.stas.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {

	public ErrorDataResult() {
		super(false);
	}

	public ErrorDataResult(String message) {
		super(false, message);
	}

	public ErrorDataResult(T data, String message) {
		super(data, false, message);

	}

}
