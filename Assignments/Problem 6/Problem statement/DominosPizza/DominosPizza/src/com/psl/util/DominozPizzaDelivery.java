package com.psl.util;

import java.util.List;

import com.psl.bean.Dish;
import com.psl.bean.Location;
import com.psl.bean.Order;

public interface DominozPizzaDelivery {

	void populateData(String dishFile,String locationFile,List<Dish> dishs,List<Location> locations);
	void calculateLocationForDistance(List<Dish> dishs,List<Location> locations );
	List<Order> calculateOrder(String orderFile,List<Dish> dishs,List<Location> locations);
	void freeDelivery(List<Order> orders,List<Dish> dishs,List<Location> locations);
	
}
