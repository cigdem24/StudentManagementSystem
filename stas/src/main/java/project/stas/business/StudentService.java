package project.stas.business;

import java.util.List;

import project.stas.core.utilities.results.DataResult;
import project.stas.entities.Student;
import project.stas.entities.dto.LoginStudentDto;

public interface StudentService {

	// Result logIn(String email_address, String password);

	List<Student> getAll();

	Student getById(int id);

	Student getByEmail(String email);

	DataResult<Object[]> login(LoginStudentDto signInStudentDto);

	DataResult<Object[]> add(Student student);

	DataResult<Object[]> delete(Student student);

	DataResult<Object[]> update(Student student);

}
