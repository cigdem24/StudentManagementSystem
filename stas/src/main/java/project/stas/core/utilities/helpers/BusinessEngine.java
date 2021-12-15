package project.stas.core.utilities.helpers;

import project.stas.core.utilities.results.Result;
import project.stas.core.utilities.results.SuccessResult;

//YARDIMCI İŞ SINIFI
public class BusinessEngine {

	// VARİABLE ARGUMENT kullanıldı.
	// RESULTLARI TEK TEK KONTROL EDEN METOD
	public static Result run(Result... results) {
		for (Result result : results) {
			if (!result.isSuccess()) {
				return result;
			}
		}
		return new SuccessResult();

	}

}
