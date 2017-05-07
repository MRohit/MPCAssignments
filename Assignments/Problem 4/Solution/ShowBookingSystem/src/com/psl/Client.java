package com.psl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bean.Show;
import com.exception.InvalidSeatNumberException;
import com.exception.SeatsNotAvailableException;
import com.exception.UnknownShowException;
import com.util.DataManagerImpl;
//import com.bean.Show;

public class Client {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		DataManagerImpl dm=new DataManagerImpl();
		List<Show> showList=dm.populateDataFromFile("ShowDetails.ser");
		
		for(Show s:showList){
			System.out.println(s);
		}
		String showName = null,show_time = null,showName2="Sahi re Sahi";
		int noofSeats = 0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Show Name:");
			showName=sc.nextLine();
		System.out.println("Enter Show Time:");
			show_time=sc.nextLine();
		System.out.println("Enter No of Seats:");
			noofSeats=sc.nextInt();
		if(showName.equals(showName2)){
			System.out.println("Strings are equal");
		}
		try {
			dm.bookShow(showList, showName,show_time,noofSeats);
		} catch (SeatsNotAvailableException | UnknownShowException
				| InvalidSeatNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Call all the functionalities from here to test your code.
		/*Scanner s=new Scanner(new File("ShowDetails.ser"));
		String[] showdata;
		String time;
		List<Show> l=new ArrayList<Show>();
		while(s.hasNext()){
			String type = s.nextLine();
			
			showdata=type.split(" ");
			
				//System.out.println(showdata[i]+"\n");
//				l.add(new Show(showdata[0],showdata[1],Integer.valueOf(showdata[2])));
//				//Integer d=showdata[2];
//			
//			for(Show ss:l){
//				System.out.println(s);
//			}
			System.out.println(type);
			
			
		}*/
		/*InputStream file=new FileInputStream("ShowDetails.ser");
		InputStream buffer=new BufferedInputStream(file);
		ObjectInput input=new ObjectInputStream(buffer);
		List<String> data=(List<String>) input.readObject();
		
		for(String d:data){
			System.out.println(d);
		}*/
		//output.writeObject()
		
		
		/*
		List<Show> listChannel=new ArrayList<Show>();
		ObjectInputStream  inputStream=null;
		try {
			inputStream=new ObjectInputStream(new FileInputStream(new File("ShowDetails.ser")));
			while (true) {
				listChannel.add((Show)inputStream.readObject());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		for(Show d:listChannel){
			System.out.println(d);
		}*/
		/*finally{
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}*/
	}
}