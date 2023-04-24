package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Customer;
import dto.Product;

public class ProductDao {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();

	public void saveProduct(Product product) {
		et.begin();
		em.persist(product);
		et.commit();
		System.out.println("Product added successfully");
	}

	public Product getProductById(int productid) {
		Product product = em.find(Product.class, productid);

		if (product != null) {
			return product;
		} else {
			return null;
		}
	}

	public List<Product> getAllProductDetails() {

		Query query = em.createQuery("select p from product p");
		List<Product> products = query.getResultList();

		if (products != null) {
			return products;
		} else {
			return null;
		}

	}

	public Product updateProductById(Product product) {

		et.begin();
		em.merge(product);
		et.commit();

		return product;
	}

	public void deleteProductById(int productid) {
		Product product = em.find(Product.class, productid);

		if (product != null) {
			et.begin();
			em.remove(product);
			et.commit();
			System.out.println("Product removed successfully");
		}
	}

	public List<Product> getProductDetailsByCustomerId(Customer customer) {
		Query query = em.createQuery("select p from product p where p.customer=?1");
		query.setParameter(1, customer);
		List<Product> products = query.getResultList();

		if (products != null) {
			return products;
		} else {
			return null;
		}
	}

}
