package com.psl.main;

import java.util.List;

import com.psl.bean.Channel;
import com.psl.util.SetTopBoxManagementSystemImpl;



public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SetTopBoxManagementSystemImpl impl=new SetTopBoxManagementSystemImpl();
		List<Channel> list=impl.populateByChannelCategory("Channel.ser");
		for (Channel channel : list) {
			System.out.println(channel);
		}
		
//		
//		System.out.println("\n\n\n\n\n");
//		List<Channel> list2=impl.getByCategory(list,ChannelCategory.Cartoon);
//		for (Channel channel : list2) {
//			System.out.println(channel.getCategory());
//		}
		
		
		System.out.println("\n\n\n\n\n");
		impl.calculateBillForEachChannel(list,"Usage.ser");
		for (Channel channel : list) {
			System.out.println(channel);
		}
		
		System.out.println("\n\n\n\n\n");
		List<Channel>  channels=impl.sortByHighestHourOfUsage(list,"Usage.ser");	
		for (Channel channel : channels) {
			System.out.println(channel.getHourOfUsage());
		}
	}

}
