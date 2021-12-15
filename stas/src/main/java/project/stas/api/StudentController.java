package project.stas.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import project.stas.business.StudentService;
import project.stas.core.utilities.results.DataResult;
import project.stas.core.utilities.results.ErrorDataResult;
import project.stas.entities.Student;
import project.stas.entities.dto.LoginStudentDto;

//@Controller
@RestController
@RequestMapping()
//@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

	private StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	// TÜM ÖĞRENCİLERİ LİSTELE
	@GetMapping("/getall")
	public List<Student> getAll() {
		return this.studentService.getAll();

	}

	// ÖĞRENCİ EKLE
	@PostMapping("/add")
	public DataResult<Object[]> add(@RequestBody Student student) {
		return this.studentService.add(student);
	}

	// ÖĞRENCİ GÜNCELLE
	@PostMapping("/update")
	public DataResult<Object[]> update(@RequestBody Student student) {
		return this.studentService.update(student);
	}

	// ÖĞRENCİ SİL
	@PostMapping("/delete")
	public DataResult<Object[]> delete(Student student) {
		return this.studentService.delete(student);
	}

	// ID'ye GÖRE ÖĞRENCİ BUL
	@GetMapping("/students/{id}")
	public Student getById(@PathVariable int id) {
		return this.studentService.getById(id);
	}

	// EMAİL'e GÖRE ÖĞRENCİ BUL
	@GetMapping("/students/{email}")
	public Student getByEmail(@PathVariable String email) {
		return this.studentService.getByEmail(email);
	}

	// LOGİN İŞLEMİ
	@PostMapping(value = "/login")
	public DataResult<Object[]> login(@Valid @RequestBody LoginStudentDto student) {
		return this.studentService.login(student);

	}

	// BÜTÜN İŞLEMLER İÇİN KULLANILABİLİR VALİDATİON KODU
	@ExceptionHandler(MethodArgumentNotValidException.class)

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {

		Map<String, String> validationErrors = new HashMap<String, String>();

		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());

		}

		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama Hataları");

		return errors;
	}

}
