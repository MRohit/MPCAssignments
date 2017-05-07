package com.psl.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import com.psl.bean.HeadOffice;
import com.psl.bean.Post;

public class SpeedPostImpl implements SpeedPost {

	@Override
	public Map<HeadOffice, List<Post>> populateData(String HeadOfficeFileName,String postFileName) {

		Map<HeadOffice, List<Post>> map=new HashMap<HeadOffice, List<Post>>();
		
//		List<HeadOffice> listHeadOffice=new ArrayList<HeadOffice>();
		List<Post> listPost=new ArrayList<Post>();
		
		Scanner scanner=null;
		try {
			scanner=new Scanner(new File(HeadOfficeFileName));
			while (scanner.hasNext()) {
				
				String[] temp=scanner.nextLine().split(",");
//				System.out.println(temp.length);
				
				String headOfficeId=temp[0].trim();
				String city=temp[1].trim();
				
//				System.out.println(temp[2]);
				String pincodes=temp[2].substring(1,temp[2].length()-1);
//				System.out.println(pincodes);
				
				String[] pinArray=pincodes.split("-");
				List<String> listOfPinCodes=new ArrayList<String>();
				for (int i = 0; i < pinArray.length; i++) {
					listOfPinCodes.add(pinArray[i]);
				}
				
//				listHeadOffice.add(new HeadOffice(headOfficeId, city, listOfPinCodes));
				map.put(new HeadOffice(headOfficeId, city, listOfPinCodes),new ArrayList<Post>());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			scanner.close();
		}
		
		
		try {
			scanner=new Scanner(new File(postFileName));
			while (scanner.hasNext()) {
				
				String[] temp=scanner.nextLine().split(",");
//				System.out.println(temp.length);
				
				String postId=temp[0].trim();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
				Date postDate=sdf.parse(temp[1].trim());
				String recepientName=temp[2];
				String pinCode=temp[3];
				
				listPost.add(new Post(postId, postDate, recepientName, pinCode));		
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		finally{
			scanner.close();
		}
		
//		System.out.println(listPost.size());
//		for (Post post : listPost) {
//			System.out.println(post);
//		}
		
		
		Set<Map.Entry<HeadOffice,List<Post>>> set=map.entrySet();
		for (Entry<HeadOffice, List<Post>> entry : set) {
			for (Post post : listPost) {
				for(String pincode:entry.getKey().getListOfPinCodes()){
					if(post.getPinCode().equals(pincode)){
						map.get(entry.getKey()).add(post);
					}
				}
			}
		}
		
		return map;
	}

	@Override
	public List<Post> mostOldestPost(Map<HeadOffice, List<Post>> map) {
		
		List<Post> returnList=new ArrayList<Post>();
		
		Set<Map.Entry<HeadOffice,List<Post>>> set=map.entrySet();
		for (Entry<HeadOffice, List<Post>> entry : set) {
			returnList.addAll(entry.getValue());
		}
		
//		System.out.println(returnList.size());
		
		Collections.sort(returnList, new Comparator<Post>() {

			@Override
			public int compare(Post p1, Post p2) {
				return p1.getPostDate().compareTo(p2.getPostDate());
			}
		});
		
		return returnList.subList(0,5);
	}

	@Override
	public HeadOffice trackPost(Map<HeadOffice, List<Post>> map, String postId) {
		
		Set<Map.Entry<HeadOffice,List<Post>>> set=map.entrySet();
		for (Entry<HeadOffice, List<Post>> entry : set) {
				for(Post post:entry.getValue()){
					if(postId.equals(post.getPostId())){
						return entry.getKey();
					}
				}
			
		}
		return null;
	}

	@Override
	public List<Post> sortByAge(Map<HeadOffice, List<Post>> map) {
		
		List<Post> returnList=new ArrayList<Post>();
		Set<Map.Entry<HeadOffice,List<Post>>> set=map.entrySet();
		for (Entry<HeadOffice, List<Post>> entry : set) {
			returnList.addAll(entry.getValue());
		}
		
		Collections.sort(returnList, new Comparator<Post>() {

			@Override
			public int compare(Post p1, Post p2) {
				return p2.getPostDate().compareTo(p1.getPostDate());
			}
		});
		
		return returnList;
	}

	

}
