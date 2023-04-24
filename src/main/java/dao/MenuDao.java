package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Menu;

public class MenuDao {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();

	public void saveMenu(Menu menu) {

		et.begin();
		em.persist(menu);
		et.commit();
		System.out.println("Menu added successfully");
	}

	public Menu getMenuById(int mid) {
		Menu menu = em.find(Menu.class, mid);

		if (menu != null) {
			return menu;
		} else {
			return null;
		}
	}

	public List<Menu> getAllMenuDetails() {
		Query query = em.createQuery("select m from menu m");
		List<Menu> menus = query.getResultList();

		if (menus != null) {
			return menus;
		} else {
			return null;
		}
	}

	public boolean updateMenu(Menu menu) {

		Menu menu1 = em.find(Menu.class, menu);

		try {
			et.begin();
			em.merge(menu1);
			et.commit();
			return true;
		} catch (Exception e) {

		}
		return false;
	}

	public void deleteMenu(int mid) {
		Menu menu = em.find(Menu.class, mid);

		if (menu != null) {
			et.begin();
			em.remove(menu);
			et.commit();
			System.out.println("Menu removed successfully");
		}
	}

}
