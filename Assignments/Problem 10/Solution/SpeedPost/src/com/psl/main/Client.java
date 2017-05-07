package com.psl.main;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.psl.bean.HeadOffice;
import com.psl.bean.Post;
import com.psl.util.SpeedPostImpl;


public class Client {
	
	public static void main(String[] args) {
		
		SpeedPostImpl impl=new SpeedPostImpl();
		Map<HeadOffice,List<Post>> map=impl.populateData("HeadOffice.txt", "Post.txt");
		Set<Map.Entry<HeadOffice,List<Post>>> set=map.entrySet();
		for (Entry<HeadOffice, List<Post>> entry : set) {
			System.out.println(entry);
		}
		
//		System.out.println("\n\n\n\n\n");
//		List<Post> list=impl.mostOldestPost(map);
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
////		System.out.println(list.size());
//		for (Post post : list) {
//			System.out.println(sdf.format(post.getPostDate()));
//		}
		
		System.out.println("\n\n\n\n\n");
		List<Post> list=impl.sortByAge(map);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println(list.size());
		for (Post post : list) {
			System.out.println(sdf.format(post.getPostDate()));
		}
		
		
		System.out.println("\n\n\n\n\n");
		System.out.println(impl.trackPost(map,"P113"));
		
		
	}
}
