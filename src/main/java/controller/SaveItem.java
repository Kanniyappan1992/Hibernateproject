package controller;

import java.util.ArrayList;
import java.util.List;

import dao.ItemDao;
import dto.Items;
import dto.Menu;

public class SaveItem {

	public static void main(String[] args) {
		ItemDao dao = new ItemDao();
		Menu menu=new Menu();

		Items items = new Items();
		items.setItemName("Coke");
		items.setItemprice(50.0);
		
		

	}

}
