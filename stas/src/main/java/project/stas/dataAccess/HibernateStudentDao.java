package project.stas.dataAccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project.stas.entities.Student;

@Repository
public class HibernateStudentDao implements StudentDao {

	private EntityManager entityManager;

	@Autowired
	public HibernateStudentDao(EntityManager entityManager) {

		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	// session açıp kapatmak için gerekli anatasyon
	// AOP - Aspect Oriented Programming
	public List<Student> getAll() {

		Session session = entityManager.unwrap(Session.class);
		List<Student> students = session.createQuery("from Student", Student.class).getResultList();
		return students;
	}

	@Override
	@Transactional
	public void add(Student student) {
		Session session = entityManager.unwrap(Session.class);
		session.save(student);

	}

	@Override
	@Transactional
	public void update(Student student) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(student);

	}

	@Override
	@Transactional
	public void delete(Student student) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(student);

	}

	@Override
	@Transactional
	public Student getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Student student = session.get(Student.class, id);
		return student;
	}

	@Override
	@Transactional
	public Student getByEmail(String email) {
		Session session = entityManager.unwrap(Session.class);
		Student student = session.get(Student.class, email);
		return student;
	}

	@Override
	@Transactional
	public Object[] login(String email, String password) {
		Query q = entityManager
				.createNativeQuery("SELECT * FROM Student  WHERE email_address = :email and password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		Object[] student = (Object[]) q.getSingleResult();

		return student;
	}

}
