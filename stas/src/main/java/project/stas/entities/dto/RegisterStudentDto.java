package project.stas.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RegisterStudentDto {

	private String identityNumber;

	private String email;

	private String password;

	private String firstName;

	private String lastName;

}
