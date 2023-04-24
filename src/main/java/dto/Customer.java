package dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_Id;
	private String customer_Name;
	private long cutomer_Phone;
	private double total_Price;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getCustomer_Id() {
		return customer_Id;
	}

	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}

	public String getCustomer_Name() {
		return customer_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}

	public long getCutomer_Phone() {
		return cutomer_Phone;
	}

	public void setCutomer_Phone(long cutomer_Phone) {
		this.cutomer_Phone = cutomer_Phone;
	}

	public double getTotal_Price() {
		return total_Price;
	}

	public void setTotal_Price(double total_Price) {
		this.total_Price = total_Price;
	}

}
