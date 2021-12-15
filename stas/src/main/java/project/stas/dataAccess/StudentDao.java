package project.stas.dataAccess;

import java.util.List;

import project.stas.entities.Student;

public interface StudentDao {

	List<Student> getAll();

	void update(Student student);

	void delete(Student student);

	Student getById(int id);

	Student getByEmail(String email);

	Object[] login(String email, String password);

	void add(Student student);

}
