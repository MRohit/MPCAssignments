package com.util;

import java.util.List;
import java.util.Set;

import com.bean.Category;
import com.bean.Complexity;
import com.bean.Criteria;
import com.bean.Question;

public interface DataManager {
	public List<Question> populateData();
	public List<Question> getQuestionByCategory(Category category,List<Question> questionsList);
	public List<Question> getQuestionByComplexity(Complexity complexity,List<Question> questionsList);
	public Set<Question> generateQuestionPaper(List<Question> list,List<Criteria> template);
	public void sortByCategory(List<Question> questionList);
	public void sortByComplexity(List<Question> questionList);
	 
}
