package com.psl.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.psl.bean.Sector;
import com.psl.bean.Stock;

public class StockMarketSystemImpl implements StockMarketSystem{

	
	
	@Override
	public Map<Sector, List<Stock>> readData() {
		
		Map<Sector, List<Stock>> map=new HashMap<Sector, List<Stock>>();
		
		for (Sector sector:Sector.values()){
			map.put(sector,new ArrayList<Stock>());
		}
		
		List<Stock> listStock=new ArrayList<Stock>();
		
		Connection connection=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		connection=new ConnectionManagerImpl().getConnection();
//		if(connection!=null)System.out.println("Connected succefully !");
		
		try {
			stmt=connection.createStatement();
			rs=stmt.executeQuery("SELECT * FROM stockmarketdb.stock s;");
			while (rs.next()) {
				
				String stockName=rs.getString(2);
				Sector sectorType=Sector.valueOf(rs.getString(3).trim());
				double costPrice=rs.getDouble(4);
				double presentPrice=rs.getDouble(5);
				Date purchaseDate=rs.getDate(6);
				int numberOfShares=rs.getInt(7);
				double totalProfit=0;
				
				listStock.add(new Stock(stockName, sectorType, costPrice, presentPrice, purchaseDate, numberOfShares, totalProfit));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				rs.close();
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
//		System.out.println(listStock.size());
//		for (Stock stock : listStock) {
//			System.out.println(stock);
//		}
		
		
		Set<Map.Entry<Sector, List<Stock>>> set=map.entrySet();
		for (Entry<Sector, List<Stock>> entry : set) {
			for (Stock stock:listStock) {
				if(stock.getSectorType().equals(entry.getKey())){
					map.get(entry.getKey()).add(stock);
				}
			}
		}
		
		return map;
	}

	@Override
	public void calculateProfit(Map<Sector, List<Stock>> map) {
		
		Set<Map.Entry<Sector, List<Stock>>> set=map.entrySet();
		for (Entry<Sector, List<Stock>> entry : set) {
			for(Stock stock:entry.getValue()){
			
				stock.setTotalProfit((stock.getPresentPrice()-stock.getCostPrice())*stock.getNumberOfShares());
			}
		}
		
		
	}

	@Override
	public List<Stock> getsStockSectorwise(Map<Sector, List<Stock>> map,Sector sectorType) {
		
		Collections.sort(map.get(sectorType),new Comparator<Stock>() {
			@Override
			public int compare(Stock s1, Stock s2) {
				return s1.getPurchaseDate().compareTo(s2.getPurchaseDate());
			}
		});
		
		
		return map.get(sectorType);
	}

	@Override
	public List<Stock> stockToSell(Map<Sector, List<Stock>> map) {
		
		
		long current=Calendar.getInstance().getTimeInMillis();
		List<Stock> returnList=new ArrayList<Stock>();
		Set<Map.Entry<Sector, List<Stock>>> set=map.entrySet();
		for (Entry<Sector, List<Stock>> entry : set) {
			for(Stock stock:entry.getValue()){
				if(stock.getTotalProfit()<1){
					
					long given=stock.getPurchaseDate().getTime();
					int numberOfDays=(int)((current-given)/(24*60*60*1000));
					int numberOfWeaks=(int)(numberOfDays/7);
					System.out.println(numberOfWeaks+"\t"+stock.getStockName());
					if(numberOfWeaks>50){
						returnList.add(stock);
					}
				}
			}
		}
		
		return returnList;
	}
}
