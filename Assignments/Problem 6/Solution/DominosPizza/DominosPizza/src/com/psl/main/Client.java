package com.psl.main;

import java.util.ArrayList;
import java.util.List;

import com.psl.bean.Dish;
import com.psl.bean.Location;
import com.psl.bean.Order;
import com.psl.util.DominozPizzaDeliveryImpl;

/*
 * @Author: Gandhali Inamdar
 */
public class Client {

	public static void main(String[] args) 
	{
		List<Dish>dish=new ArrayList<Dish>();
		List<Location>loc=new ArrayList<Location>();
		List<Order>order=new ArrayList<Order>();
		DominozPizzaDeliveryImpl dpd=new DominozPizzaDeliveryImpl();
		try {
			dpd.populateData("dish.txt", "location.txt", dish, loc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(dish.toString());
		System.out.println("\n"+loc.toString()+"\n");
		dpd.calculateLocationForDistance(dish, loc);
		System.out.println("\n"+dish.toString());
		
		order=dpd.calculateOrder("order.txt", dish, loc);
		System.out.println("\nOrders--\n");
		System.out.println(order);
		
		
		System.out.println("\nOrders--(After availing free delivery if applicable)\n");
		dpd.freeDelivery(order, dish, loc);
		
	}

}
