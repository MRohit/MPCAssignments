package com.util;

import java.sql.*;
import java.util.*;

import com.bean.Category;
import com.bean.Complexity;
import com.bean.Criteria;
import com.bean.Question;

// Override and implement all the methods of DataManager Interface here
public class DataManagerImpl implements DataManager {

	@Override
	public List<Question> populateData() {
		DatabaseConnectionManager db=new DatabaseConnectionManager();
		Connection con=null;
		List<Question> ls=new ArrayList<Question>();
		Statement st=null;
		ResultSet rs=null;
		String query="select * from questionbank";
		try {
			con=db.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(con!=null){
			System.out.println("Connections Established");
		}
		try {
			st=con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			rs=st.executeQuery(query);
			while(rs.next()){
				Question q=new Question();
				//System.out.println(Complexity.valueOf(rs.getString(9)));
				q.setComplexity(Complexity.valueOf(rs.getString(9)));
				q.setCorrectAns(rs.getString(7));
				q.setOption1(rs.getString(3));
				q.setOption2(rs.getString(4));
				q.setOption3(rs.getString(5));
				q.setOption4(rs.getString(6));
				q.setQuestion(rs.getString(2));
				q.setSrno(rs.getInt(1));
				q.setType(Category.valueOf(rs.getString(8)));
				ls.add(q);
				q=null;
				//System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (con != null) {
				try {
					db.closeConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		return ls;
	}

	@Override
	public List<Question> getQuestionByCategory(Category category,
			List<Question> questionsList) {
		List<Question> ls=new ArrayList<Question>();
		for(Question q:questionsList){
			if(q.getCategory()==category){
				ls.add(q);
			}
		}
		return ls;
	}

	@Override
	public List<Question> getQuestionByComplexity(Complexity complexity,
			List<Question> questionsList) {
		List<Question> ls=new ArrayList<Question>();
		for(Question q:questionsList){
			if(q.getComplexity()==complexity){
				ls.add(q);
			}
		}
		return ls;
	}

	@Override
	public Set<Question> generateQuestionPaper(List<Question> list,
			List<Criteria> template) {
		Set<Question> finalQuestionList=new HashSet<Question>();
		for(Criteria criteria:template){
			List<Question> tempList=getQuestionByComplexity(criteria.getComplexity(), getQuestionByCategory(criteria.getCategory(), list));
			for (int i = 0; i < criteria.getNoOfQuestion(); i++) {
				int index=(int) ((Math.random())*tempList.size());
				
				finalQuestionList.add(tempList.get(index));
				
				//removing duplicates
				if(i==tempList.size())
					i--;
			}
		}
		return finalQuestionList;
		
	}

	@Override
	public void sortByCategory(List<Question> questionList) {
		// TODO Auto-generated method stub
		class sortByCategory implements Comparator<Question>{

			@Override
			public int compare(Question arg0, Question arg1) {
				// TODO Auto-generated method stub
				return arg0.getCategory().compareTo(arg1.getCategory());
			}
			
		}
		Collections.sort(questionList,new sortByCategory());
	}

	@Override
	public void sortByComplexity(List<Question> questionList) {
		// TODO Auto-generated method stub
		Collections.sort(questionList,new Comparator<Question>(){

			@Override
			public int compare(Question arg0, Question arg1) {
				// TODO Auto-generated method stub
				return arg0.getComplexity().compareTo(arg1.getComplexity());
			}
			
		});
	}


}