package project.stas.business;

import org.springframework.stereotype.Service;

import project.stas.core.utilities.results.ErrorResult;
import project.stas.core.utilities.results.Result;
import project.stas.core.utilities.results.SuccessResult;

@Service
public class StudentCheckManager implements StudentCheckService {

	@Override
	public Result identityNumberCheck(String identity_number) {
		if (identity_number != null && !identity_number.isEmpty() && !identity_number.isBlank()) {
			if (identity_number.length() == 11) {
				return new SuccessResult();
			}
			return new ErrorResult("TC Kimlik numarası 11 haneli olmalıdır.");

		}
		return new ErrorResult("Tc Kimlik numarası alanı boş bırakılamaz.");
	}

	@Override
	public Result firstNameCheck(String firtName) {
		if (firtName != null && !firtName.isEmpty() && !firtName.isBlank()) {
			if (firtName.length() >= 2) {
				return new SuccessResult();
			}
			return new ErrorResult("Adınız en az 2 karakter olmalıdır.");

		}
		return new ErrorResult("Adınız alanı boş bırakılamaz.");

	}

	@Override
	public Result lastNameCheck(String lastName) {
		if (lastName != null && !lastName.isEmpty() && !lastName.isBlank()) {
			if (lastName.length() >= 2) {
				return new SuccessResult();
			}
			return new ErrorResult("Soy Adınız en az 2 karakter olmalıdır.");

		}
		return new ErrorResult("Soy Adınız alanı boş bırakılamaz.");

	}

	@Override
	public Result passwordCheck(String password) {
		if (password != null && !password.isEmpty() && !password.isBlank()) {
			if (password.length() > 6) {
				return new SuccessResult();
			}
			return new ErrorResult("Parolanız en az 6 karakterden oluşmalıdır !");

		}
		return new ErrorResult("Parola alanı boş bırakılamaz.");

	}

	@Override
	public Result emailCheck(String email) {
		if (email != null && !email.isBlank() && !email.isEmpty()) {
			if (EmailValidator.isEmailValid(email)) {
				return new SuccessResult();
			}
			return new ErrorResult("E-mail adresiniz e-posta formatında olmalıdır !");
		}
		return new ErrorResult("Email alanı boş bırakılamaz");
	}

}
