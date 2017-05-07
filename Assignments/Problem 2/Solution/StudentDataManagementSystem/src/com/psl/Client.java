package com.psl;

import java.util.ArrayList;
import java.util.List;

import com.psl.beans.Student;
import com.psl.exceptions.InsufficientDataException;
import com.psl.util.StudentDataManager;

public class Client {
	
	public static void main(String[] args) {
		
		//Create instance of StudentDataManager Class here and  test your functionality from here
		StudentDataManager st=new StudentDataManager();
		List<Student> ls=new ArrayList<Student>();
		ls=st.populateData("StudentDetails.txt");
		/*for(Student s:ls){
			System.out.println(s);
		}*/
		try {
			st.validateData(ls);
		} catch (InsufficientDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		st.sortData(ls);
		for(Student s:ls){
			System.out.println(s);
		}
	}
}
