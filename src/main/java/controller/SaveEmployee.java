package controller;

import dao.EmployeeDao;
import dto.Employee;

public class SaveEmployee {

	public static void main(String[] args) {

		EmployeeDao dao = new EmployeeDao();

		Employee e1 = new Employee();
		e1.setEname("tom");
		e1.setEmail("tom@gmail.com");
		e1.setPassword("tom@123");
		e1.setRole("manager");

		Employee e2 = new Employee();
		e2.setEname("jerry");
		e2.setEmail("jerry@gmail.com");
		e2.setPassword("jerry@123");
		e2.setRole("staff");

		dao.saveEmployee(e1);
		dao.saveEmployee(e2);

	}

}
