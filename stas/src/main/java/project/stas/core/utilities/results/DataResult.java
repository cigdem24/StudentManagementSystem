package project.stas.core.utilities.results;

//DATA İLE GÖNDERİLEN RESULT CLASSI
public class DataResult<T> extends Result {

	private T data;

	// SUCCESS PARAMETRELİ CONSTRUCTOR
	public DataResult(boolean success) {
		super(success);
	}

	// SUCCESS, MESSAGE PARAMETRELİ BOŞ CONSTRUCTOR
	public DataResult(boolean success, String message) {
		super(success, message);
	}

	// SUCCESS,MESSAGE,DATA PARAMETRELİ BOŞ CONSTRUCTOR
	public DataResult(T data, boolean success, String message) {
		super(success, message);
		this.data = data;

	}

	// GETTER SETTER METODLARI
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
