package controller;

import dao.MenuDao;
import dto.Menu;

public class SaveMenu {

	public static void main(String[] args) {

		MenuDao dao = new MenuDao();

		Menu menu1 = new Menu();
		menu1.setMenuName("Starter");
		dao.saveMenu(menu1);

		Menu menu2 = new Menu();
		menu2.setMenuName("Non-Veg");
		dao.saveMenu(menu2);

		Menu menu3 = new Menu();
		menu3.setMenuName("Veg");
		dao.saveMenu(menu3);

	}

}
