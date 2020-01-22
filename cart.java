package com.metacube.Animeshassignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Item {
	public static HashMap<String, Double> cartItem = new HashMap<>(); // Item Name and their Price

	Item() {
		cartItem.put("vegetables", 100.00);
		cartItem.put("fruits", 200.00);
		cartItem.put("furniture", 500.00);
	}
}
// I have used 2 hash maps one for storing values of item name and price and second one for storing item name and quantity 
class Cart extends Item {
	Cart() {
		super(); 
	}

	public static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));
	public static HashMap<String, Double> cart = new HashMap<>(); // Item Name and Quantity

	public void addItem() throws IOException {
		try {
			System.out.println("Enter the item name you wish to add");
			String itemName = br.readLine().toLowerCase();
			if (cartItem.containsKey(itemName)) {
				System.out.println("Enter the quantity");
				double itemQuantity = Double.parseDouble(br.readLine());
				cart.put(itemName, itemQuantity);
			} else {
				System.out.println("We don`t have this item currently");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void itemUpdate() throws IOException {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			System.out.println("Enter the item you want to update");
			String name = br.readLine().toLowerCase();
			if (cart.get(name) == null) {
				System.out.println("You don`t have this item in the cart");
			} else {
				System.out.println("Enter the updated quantity");
				double updatedquantity = Double.parseDouble(br.readLine());
				if (cart.containsKey(name) && cart.get(name) > 0) {
					cart.put(name, updatedquantity);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void displayItem() {
		try {
			double amount = 0;
			for (Map.Entry<String, Double> entry : cart.entrySet()) {
				if (entry.getValue() > 0) {
					System.out.println("Item name = " + entry.getKey()
							+ ", Item Quantity = " + entry.getValue()
							+ ", Total Price = " + cartItem.get(entry.getKey())* entry.getValue());
					amount += cartItem.get(entry.getKey()) * entry.getValue();
				}
			}
			System.out.println("Total Cart Amount = " + amount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Cart cartobject = new Cart();
		for (Map.Entry<String, Double> entry : cartItem.entrySet()) {
			if (entry.getValue() > 0) {
				System.out.println("Item name = " + entry.getKey()+ ", Item Price = " + entry.getValue());
			}
		}
		for (int i = 1; i > 0; i++) {
			System.out.println("Enter 1 to add a product\nEnter 2 to update\nEnter 3 to print bill\nEnter 4 to exit ");
			int choice = Integer.parseInt(br.readLine());
			switch (choice) {
			case 1:
				cartobject.addItem();
				break;
			case 2:
				cartobject.itemUpdate();
				break;
			case 3:
				cartobject.displayItem();
				break;
			case 4:
				i = -1;
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
	}
}

