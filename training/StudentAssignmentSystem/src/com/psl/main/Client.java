package com.psl.main;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.psl.bean.Student;
import com.psl.bean.Subject;
import com.psl.util.StudentAssignmentImpl;


public class Client {

	public static void main(String[] args) {
	
		StudentAssignmentImpl impl=new StudentAssignmentImpl();
		Map<Subject, List<Student>> map=impl.populateData("subject.txt","student.txt");
		impl.calculateMarks(map);
		impl.offerGraseMarks(map);
		Set<Map.Entry<Subject,List<Student>>> set=map.entrySet();
		for (Entry<Subject, List<Student>> entry : set) {
			System.out.println("..................."+entry.getKey().getSubjectName());
			for(Student student:entry.getValue()){
				System.out.println(student.getSubject()+"\t"+student.getMarksObtained()+"\t"+student.getNumberOfDays()+"\t"+student.isDefaulter());
			}
		}
		
		
//		System.out.println("\n\n\n\n\n");
//		Map<Subject, List<Student>> map1=impl.generateDefaulterListSubjectWise(map);
//		
////		impl.calculateMarks(map);
//		Set<Map.Entry<Subject,List<Student>>> set1=map1.entrySet();
//		for (Entry<Subject, List<Student>> entry : set1) {
//			System.out.println("..................."+entry.getKey().getSubjectName());
//			for(Student student:entry.getValue()){
//				System.out.println(student.isDefaulter());
//			}
//		}
		
		
		
	}
}