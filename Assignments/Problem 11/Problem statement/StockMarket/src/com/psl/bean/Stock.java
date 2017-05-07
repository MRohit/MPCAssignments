package com.psl.bean;

import java.sql.Date;

public class Stock {

	private String stockName;
	private Sector sectorType;
	private double costPrice;
	private double presentPrice;
	private Date purchaseDate;
	private int numberOfShares;
	private double totalProfit;
	
	
	@Override
	public String toString() {
		return "Stock [stockName=" + stockName + ", sectorType=" + sectorType
				+ ", costPrice=" + costPrice + ", presentPrice=" + presentPrice
				+ ", purchaseDate=" + purchaseDate + ", numberOfShares="
				+ numberOfShares + ", totalProfit=" + totalProfit + "]";
	}
	public Stock(String stockName, Sector sectorType, double costPrice,
			double presentPrice, Date purchaseDate, int numberOfShares,
			double totalProfit) {
		super();
		this.stockName = stockName;
		this.sectorType = sectorType;
		this.costPrice = costPrice;
		this.presentPrice = presentPrice;
		this.purchaseDate = purchaseDate;
		this.numberOfShares = numberOfShares;
		this.totalProfit = totalProfit;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public Sector getSectorType() {
		return sectorType;
	}
	public void setSectorType(Sector sectorType) {
		this.sectorType = sectorType;
	}
	public double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}
	public double getPresentPrice() {
		return presentPrice;
	}
	public void setPresentPrice(double presentPrice) {
		this.presentPrice = presentPrice;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public int getNumberOfShares() {
		return numberOfShares;
	}
	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}
	public double getTotalProfit() {
		return totalProfit;
	}
	public void setTotalProfit(double totalProfit) {
		this.totalProfit = totalProfit;
	}
	
	
	
	
	
	
}
