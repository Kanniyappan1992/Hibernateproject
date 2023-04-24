package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Items;

public class ItemDao {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();

	public void saveItems(Items items) {
		et.begin();
		em.persist(items);
		et.commit();
		System.out.println("Item details saved successfully");
	}

	public Items getItemsById(int itemid) {

		Items items = em.find(Items.class, itemid);

		if (items != null) {
			return items;
		} else {
			return null;
		}
	}

	public List<Items> getAllItemDetails() {
		Query query = em.createQuery("select i from items i");
		List<Items> items = query.getResultList();

		if (items != null) {
			return items;
		} else {
			return null;
		}
	}

	public boolean updateItems(Items items) {
		Items items1=em.find(Items.class, items);
		try {
			et.begin();
			em.merge(items1);
			et.commit();

			return true;

		} catch (Exception e) {

		}
		return false;
	}

	public void deleteItems(int itemName) {

		Items items = em.find(Items.class, itemName);

		et.begin();
		em.remove(items);
		et.commit();
		System.out.println("Item removed successfully");
	}

}
