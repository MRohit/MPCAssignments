package com.psl.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.psl.bean.Channel;
import com.psl.bean.ChannelCategory;
import com.psl.bean.Usage;

public class SetTopBoxManagementSystemImpl implements
		SetTopBoxManagementSysytem {

	@Override
	public List<Channel> populateByChannelCategory(String fileNameChannel) {
		List<Channel> listChannel=new ArrayList<Channel>();
		ObjectInputStream  inputStream=null;
		try {
			inputStream=new ObjectInputStream(new FileInputStream(new File(fileNameChannel)));
			while (true) {
				listChannel.add((Channel)inputStream.readObject());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Collections.sort(listChannel,new Comparator<Channel>() {

			@Override
			public int compare(Channel c1, Channel c2) {
				return c1.getCategory().compareTo(c2.getCategory());
			}
		});
		
		return listChannel;
	}

	@Override
	public void calculateBillForEachChannel(List<Channel> list,String fileNameUsage) {
		
		List<Usage> listUsage=new ArrayList<Usage>();
		ObjectInputStream  inputStream=null;
		try {
			inputStream=new ObjectInputStream(new FileInputStream(new File(fileNameUsage)));
			while (true) {
				listUsage.add((Usage)inputStream.readObject());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
//		for (Usage usage : listUsage) {
//			System.out.println(usage);
//		}
//		
		
		for (Channel channel : list) {
			for (Usage usage : listUsage) {
				if(channel.getChannelId().equals(usage.getChannelId())){
					double numberOfHours=(double)((double)(usage.getEndTime()-usage.getStartTime())/100);
//					System.out.println(numberOfHours+"\t"+usage.getEndTime()+"\t"+usage.getStartTime());
					channel.setHourOfUsage(channel.getHourOfUsage()+numberOfHours);
					channel.setBillAmount(channel.getBillAmount()+(numberOfHours*channel.getCost()));
				}
			}
		}
		
		
		
	}

	@Override
	public List<Channel> sortByHighestHourOfUsage(List<Channel> list,String fileNameUsage) {
		
		calculateBillForEachChannel(list, fileNameUsage);
		
		Collections.sort(list,new Comparator<Channel>() {

			@Override
			public int compare(Channel c1, Channel c2) {
				
				if(c2.getHourOfUsage()>c1.getHourOfUsage()){
					return 1;
				}
				else if(c2.getHourOfUsage()<c1.getHourOfUsage()){
					return -1;
				}
				else
				{
					return 0;
				}
				
			}
		});
		
		
		
		return list;
	}

	@Override
	public List<Channel> getByCategory(List<Channel> list,ChannelCategory category) {
		
		List<Channel> returnList=new ArrayList<Channel>();
		for (Channel channel : list) {
			if(channel.getCategory().equals(category)){
				returnList.add(channel);
			}
		}
		return returnList;
	}

	
}