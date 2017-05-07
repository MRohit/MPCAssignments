package com.psl;

import java.util.*;

import com.bean.Category;
import com.bean.Complexity;
import com.bean.Criteria;
import com.bean.Question;
import com.util.DataManagerImpl;

public class Client {
	public static void main(String[] args) {
		// Call your functionalities from here to test your code.
		DataManagerImpl i=new DataManagerImpl();
		List<Question> ls=i.populateData();
		
		for(Question q:ls){
			System.out.println(q.getQuestion());
		}
		
		
		System.out.println("Questions by Category");
		List<Question> ls2=i.getQuestionByCategory(Category.Geography, ls);
		for(Question q:ls2){
			System.out.println(q.getQuestion());
		}
		
		System.out.println("Questions by Complexity");
		List<Question> ls3=i.getQuestionByComplexity(Complexity.Complex, ls);
		for(Question q:ls3){
			System.out.println(q.getQuestion());
		}
		
		List<Criteria> lc=new ArrayList<Criteria>();
		Criteria c=new Criteria(Category.Geography, Complexity.Medium, 3);
		lc.add(c);
		Criteria c2=new Criteria(Category.GK, Complexity.Simple, 3);
		lc.add(c2);
		
		
		List<Criteria> template=new ArrayList<Criteria>();
		template.add(new Criteria(Category.GK,Complexity.Simple,2));
		template.add(new Criteria(Category.GK,Complexity.Medium,1));
		template.add(new Criteria(Category.GK,Complexity.Complex,1));
		
		template.add(new Criteria(Category.Science,Complexity.Complex,1));
		template.add(new Criteria(Category.History,Complexity.Simple,2));
		template.add(new Criteria(Category.History,Complexity.Medium,2));
		
		template.add(new Criteria(Category.Geography,Complexity.Medium,1));
		
		System.out.println("\n\n\nQuestions by Template");
		Set<Question> templateQuestion=i.generateQuestionPaper(ls, template);
		for(Question q:templateQuestion){
			System.out.println(q);
		}
		System.out.println("\n\n\nQuestions by Template");
	//	Set<Question> set=i.generateQuestionPaper(ls, lc);
		
		System.out.println("Sort by Category");
		i.sortByCategory(ls);
		for(Question q:ls){
			System.out.println("Category:"+q.getCategory()+" Question:"+q.getQuestion());
		}
		
		System.out.println("Sort by Complexity");
		i.sortByComplexity(ls);
		for(Question q:ls){
			System.out.println("Complexity:"+q.getComplexity()+" Question:"+q.getQuestion());
		}
		
	}
}
