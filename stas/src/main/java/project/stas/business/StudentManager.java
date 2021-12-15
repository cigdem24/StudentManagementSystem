package project.stas.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.stas.core.utilities.helpers.BusinessEngine;
import project.stas.core.utilities.results.DataResult;
import project.stas.core.utilities.results.ErrorDataResult;
import project.stas.core.utilities.results.Result;
import project.stas.core.utilities.results.SuccessDataResult;
import project.stas.dataAccess.StudentDao;
import project.stas.entities.Student;
import project.stas.entities.dto.LoginStudentDto;

@Service
public class StudentManager implements StudentService {

	private StudentDao studentDao;

	private StudentCheckService studentCheckService;

	@Autowired
	public StudentManager(StudentDao studentDao, StudentCheckService studentCheckService) {
		this.studentDao = studentDao;
		this.studentCheckService = studentCheckService;
	}

	@Override
	public List<Student> getAll() {
		List<Student> students = this.studentDao.getAll();
		return students;

	}

	@Override
	public DataResult<Object[]> add(Student student) {

		Result sonuc = BusinessEngine.run(studentCheckService.emailCheck(student.getEmailAddress()),
				studentCheckService.passwordCheck(student.getPassword()),
				studentCheckService.identityNumberCheck(student.getIdentityNumber()),
				studentCheckService.firstNameCheck(student.getFirstName()),
				studentCheckService.lastNameCheck(student.getLastName()));
		if (sonuc.isSuccess()) {

			this.studentDao.add(student);
			return new SuccessDataResult<Object[]>("Başarılı bir şekilde kayıt oldunuz.");

		}

		return new ErrorDataResult<Object[]>(null, sonuc.getMessage());

	}

	@Override
	public DataResult<Object[]> update(Student student) {

		Result sonuc = BusinessEngine.run(studentCheckService.emailCheck(student.getEmailAddress()),
				studentCheckService.passwordCheck(student.getPassword()),
				studentCheckService.identityNumberCheck(student.getIdentityNumber()),
				studentCheckService.firstNameCheck(student.getFirstName()),
				studentCheckService.lastNameCheck(student.getLastName()));
		if (sonuc.isSuccess()) {
			this.studentDao.update(student);
			return new SuccessDataResult<Object[]>("Başarılı bir şekilde güncelleme yapıldı.");

		}

		return new ErrorDataResult<Object[]>(null, sonuc.getMessage());

	}

	@Override
	public DataResult<Object[]> delete(Student student) {

		Result sonuc = BusinessEngine.run(studentCheckService.emailCheck(student.getEmailAddress()),
				studentCheckService.passwordCheck(student.getPassword()),
				studentCheckService.identityNumberCheck(student.getIdentityNumber()),
				studentCheckService.firstNameCheck(student.getFirstName()),
				studentCheckService.lastNameCheck(student.getLastName()));
		if (sonuc.isSuccess()) {
			this.studentDao.delete(student);
			return new SuccessDataResult<Object[]>("Başarılı bir şekilde silme işlemi yapıldı");

		}

		return new ErrorDataResult<Object[]>(null, sonuc.getMessage());

	}

	@Override
	@Transactional
	public Student getById(int id) {

		return this.studentDao.getById(id);
	}

	@Override
	@Transactional
	public Student getByEmail(String email) {

		return this.studentDao.getByEmail(email);
	}

	@Override
	public DataResult<Object[]> login(LoginStudentDto loginStudentDto) {

		Result sonuc = BusinessEngine.run(studentCheckService.emailCheck(loginStudentDto.getEmail()),
				studentCheckService.passwordCheck(loginStudentDto.getPassword()));
		if (sonuc.isSuccess()) {

			// HİBERNATE DATA ERİŞİM KODLARI
			Object[] student = this.studentDao.login(loginStudentDto.getEmail(), loginStudentDto.getPassword());

			return new SuccessDataResult<Object[]>(student, "Başarılı Şekilde Öğrenci Girişi Yapıldı.");
		}

		return new ErrorDataResult<Object[]>(null, sonuc.getMessage());

	}

}
