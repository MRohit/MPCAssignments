package com.psl.util;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.psl.bean.Channel;
import com.psl.bean.ChannelCategory;

public interface SetTopBoxManagementSysytem {
	
	List<Channel> populateByChannelCategory(String fileNameChannel);
	void calculateBillForEachChannel(List< Channel> list,String fileNameUsage);
	List<Channel> sortByHighestHourOfUsage(List<Channel> list,String fileNameUsage);
	List<Channel> getByCategory(List<Channel> list,ChannelCategory category);
	
}
