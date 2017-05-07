package com.psl.util;

import java.util.List;
import java.util.Map;

import com.psl.bean.HeadOffice;
import com.psl.bean.Post;

public interface SpeedPost {

	Map<HeadOffice,List<Post>> populateData(String HeadOfficeFileName,String postFileName);
	List<Post> mostOldestPost(Map<HeadOffice,List<Post>> map);//this will return the list of 5 post which oldest
	HeadOffice trackPost(Map<HeadOffice,List<Post>> map,String postId);//this will return the associate HeadOffice
	List<Post> sortByAge(Map<HeadOffice,List<Post>> map);
		
}
