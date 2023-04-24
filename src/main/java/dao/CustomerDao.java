package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Customer;

public class CustomerDao {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();

	public void saveCustomer(Customer customer) {

		et.begin();
		em.persist(customer);
		et.commit();
		System.out.println("Customer details saved successfully");
	}

	public Customer getCustomerById(int customerid) {

		Customer customer = em.find(Customer.class, customerid);

		if (customer != null) {
			return customer;
		} else {
			return null;
		}
	}

	public List<Customer> getAllCustomerDetails() {

		Query query = em.createQuery("select c from customer c");
		List<Customer> customers = query.getResultList();

		if (customers != null) {
			return customers;
		} else {
			return null;
		}

	}

	public Customer updateCustomerById(Customer customer) {
		Customer customer2 = em.find(Customer.class, customer);

		et.begin();
		em.merge(customer2);
		et.commit();

		return customer2;
	}

	public void deleteCustomerById(int customerid) {
		Customer customer = em.find(Customer.class, customerid);

		if (customer != null) {
			et.begin();
			em.remove(customer);
			et.commit();
			System.out.println("Customer details removed successfully");
		}
	}

}
