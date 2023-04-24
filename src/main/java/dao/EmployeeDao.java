package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Employee;

public class EmployeeDao {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();

	public void saveEmployee(Employee employee) {

		et.begin();
		em.persist(employee);
		et.commit();
		System.out.println("Employee details added successfully");

	}

	public Employee getEmployeeById(int id) {
		Employee employee = em.find(Employee.class, id);

		if (employee != null) {
			return employee;
		} else {
			return null;
		}

	}

	public Employee getEmployeeByEmail(String email) {

		try {
			Query query = em.createQuery("select e from employee e where e.email=?1");
			query.setParameter(1, email);

			Employee employee = (Employee) query.getSingleResult();
			if (employee != null) {
				return employee;
			}

		} catch (Exception e) {
			return null;
		}
		return null;
	}

	public List<Employee> getEmployeeDetails() {

		Query query = em.createQuery("select e from emplyee e");

		List<Employee> employees = query.getResultList();

		if (employees != null) {
			return employees;
		} else {
			return null;
		}

	}

	public boolean deleteEmployeeByEmail(String email) {
		Employee employee = em.find(Employee.class, email);

		if (employee != null) {
			et.begin();
			em.remove(employee);
			et.commit();
			return true;
		} else {
			return false;
		}
	}

}
