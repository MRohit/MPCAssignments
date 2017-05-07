package com.psl.main;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.psl.bean.Sector;
import com.psl.bean.Stock;
import com.psl.util.StockMarketSystemImpl;


public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StockMarketSystemImpl impl=new StockMarketSystemImpl();
		Map<Sector, List<Stock>> map=impl.readData();
		Set<Map.Entry<Sector, List<Stock>>> set=map.entrySet();
		for (Entry<Sector, List<Stock>> entry : set) {
//			System.out.println(entry);
			System.out.println("...................."+entry.getKey());
			for(Stock stock:entry.getValue()){
				System.out.println(stock.getSectorType());
			}
		}
		
		
		
		
		System.out.println("\n\n\n\n\n");
		List<Stock>  list=impl.getsStockSectorwise(map,Sector.Infotech);
		for (Stock stock : list) {
			System.out.println(stock.getSectorType()+"\t"+stock.getPurchaseDate());
		}
		
		System.out.println("\n\n\n\n\n");
		impl.calculateProfit(map);
		for (Entry<Sector, List<Stock>> entry : set) {
			System.out.println("...................."+entry.getKey());
			for(Stock stock:entry.getValue()){
				System.out.println(stock.getCostPrice()+"\t"+stock.getPresentPrice()+"\t"+stock.getNumberOfShares()+"\t"+stock.getTotalProfit());
			}
		}
		
		
		
		System.out.println("\n\n\n\n\n");
		List<Stock>  list1=impl.stockToSell(map);
		for (Stock stock : list1) {
			System.out.println(stock.getTotalProfit()+"\t"+stock.getStockName());
		}
		
	}

}
