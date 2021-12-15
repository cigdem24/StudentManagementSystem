package project.stas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "student", uniqueConstraints = @UniqueConstraint(columnNames = "email_address"))
public class Student {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;

	@Column(name = "identity_number")
	private String identityNumber;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email_address")
	@Email
	@NotBlank
	@NotNull
	private String emailAddress;

	@Column(name = "password")
	private String password;

	public Student() {

	}

	public Student(int no, String identityNumber, String firstName, String lastName, String emailAddress,
			String password) {

		this.no = no;
		this.identityNumber = identityNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.password = password;
	}

}
