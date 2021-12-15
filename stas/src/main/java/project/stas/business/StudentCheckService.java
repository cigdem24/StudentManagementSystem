package project.stas.business;

import project.stas.core.utilities.results.Result;

public interface StudentCheckService {

	Result identityNumberCheck(String identity_number);

	Result firstNameCheck(String firtName);

	Result lastNameCheck(String lastName);

	Result passwordCheck(String password);

	Result emailCheck(String email);

}
