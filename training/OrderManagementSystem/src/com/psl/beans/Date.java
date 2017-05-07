package com.psl.beans;

import java.io.Serializable;

import com.psl.exceptions.InvalidDateException;

/**
 * 
 * @author YOGESH SHINDE
 * @since October 2014
 *
 */

public class Date implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int d, m, y;

	public Date(String date) throws InvalidDateException 
	{		
		String cd[] = date.split("[-/]");		
		int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		int d = Integer.parseInt(cd[0].trim()), 
		m = Integer.parseInt(cd[1].trim()), 
		y = Integer.parseInt(cd[2].trim());
		 
		if((y % 4 == 0 && y % 100 != 0) || y % 400 == 0)
			days[1] = 29;
		
		//int cy = (int) (System.currentTimeMillis()/1000/3600/24/365.25 + 1970);
		
		if( (y > 0) && (m > 0 && m <= 12) && (d > 0 && d <= days[m-1]) )
		{
			this.d = d;	this.m = m;	this.y = y;
		}
		else
			throw new InvalidDateException();
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() 
	{
		return d+"-"+m+"-"+y;
	}
}