package com.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import com.bean.Show;
import com.exception.InvalidSeatNumberException;
import com.exception.SeatsNotAvailableException;
import com.exception.UnknownShowException;

//Override and implement all the methods of DataManger Interface in this class
public class DataManagerImpl implements DataManager {

	@Override
	public List<Show> populateDataFromFile(String fileName) {
		// TODO Auto-generated method stub
		List<Show> ls=new ArrayList<Show>();
		try {
			InputStream i=new FileInputStream(fileName);
			InputStream buffer=new BufferedInputStream(i);
			ObjectInput input=new ObjectInputStream(buffer);
			while(true){
				ls.add((Show) input.readObject());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ls;
	}

	@Override
	public void bookShow(List<Show> showList, String showName,
			String show_time, int noOfSeats) throws SeatsNotAvailableException,
			UnknownShowException, InvalidSeatNumberException {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(noOfSeats<=0){
			throw new InvalidSeatNumberException();
		}else{
			for(Show s:showList){
				if(s.getShowName().equals(showName)){
					if(noOfSeats<=s.getSeatsAvailable()){
						System.out.println("Show has been Booked");
						flag=true;
						return;
					}else
						throw new SeatsNotAvailableException();
				}
				
			}
			if(flag==false){
				throw new UnknownShowException();
			}
		}
		
	}
	
}
