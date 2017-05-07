package com.psl.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import com.psl.bean.Student;
import com.psl.bean.Subject;

public class StudentAssignmentImpl implements StudentAssignment {

	@Override
	public Map<Subject, List<Student>> populateData(String fileSubject,String fileStudent) {
		
		Map<Subject, List<Student>> map=new HashMap<Subject, List<Student>>();
		
		Scanner scanner=null;
		
		try {
			scanner=new Scanner(new File(fileSubject));
			while (scanner.hasNext()) {
				String[] temp=scanner.nextLine().split(",");
//				System.out.println(temp.length);
				
				String subjectName=temp[0].trim();
				SimpleDateFormat sdf=new SimpleDateFormat("dd:MM:yyyy");
				java.util.Date assignmentIssueDate=sdf.parse(temp[1]);
				map.put(new Subject(subjectName, assignmentIssueDate,0), new ArrayList<Student>());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		finally{
			scanner.close();
		}
		
		
		
		List<Student> listStudent=new ArrayList<Student>();
		try {
			scanner=new Scanner(new File(fileStudent));
			while (scanner.hasNext()) {
				String[] temp=scanner.nextLine().split(",");
//				System.out.println(temp.length);
				
				int rollNumber=Integer.parseInt(temp[0].trim());
				String studentname=temp[1];
				String subject=temp[2];
				SimpleDateFormat sdf=new SimpleDateFormat("dd:MM:yyyy");
				java.util.Date submissionDate=sdf.parse(temp[3].trim());
				int marksObtained=0;
				
				listStudent.add(new Student(rollNumber, studentname, subject, submissionDate, marksObtained, 0, false));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		finally{
			scanner.close();
		}
		
//		for (Student student : listStudent) {
//			System.out.println(student);
//		}
		
		Set<Map.Entry<Subject,List<Student>>> set=map.entrySet();
		for (Entry<Subject, List<Student>> entry : set) {
			for (Student student : listStudent) {
				if(entry.getKey().getSubjectName().equals(student.getSubject())){
					map.get(entry.getKey()).add(student);
				}
			}
		}
		
		
		return map;
	}

	@Override
	public void calculateMarks(Map<Subject, List<Student>> map) {
		Set<Map.Entry<Subject,List<Student>>> set=map.entrySet();
		for (Entry<Subject, List<Student>> entry : set) {
			
			long issueDate=entry.getKey().getAssignmentIssueDate().getTime();
			for(Student student:entry.getValue()){
				long submitDate=student.getSubmissionDate().getTime();
				
				int numberOfDays=(int)((submitDate-issueDate)/(24*60*60*1000));
				student.setNumberOfDays(numberOfDays);
				if(numberOfDays<=5){
					student.setMarksObtained(45);
				}
				else if(numberOfDays>5 && numberOfDays<=10){
					student.setMarksObtained(35);
				}
				else{
					student.setMarksObtained(0);
					student.setDefaulter(true);
				}
				
			}
		}
		
	}

	@Override
	public Map<Subject, List<Student>> generateDefaulterListSubjectWise(Map<Subject, List<Student>> map) {
		
		
		calculateMarks(map);
		Map<Subject, List<Student>> returnMap=new HashMap<Subject, List<Student>>();
		returnMap.putAll(map);
		
		Set<Map.Entry<Subject,List<Student>>> set=returnMap.entrySet();
		for (Entry<Subject, List<Student>> entry : set) {
			
			List<Student> list=entry.getValue();
			Iterator<Student> iterator=list.iterator();
			while (iterator.hasNext()) {
				
				Student student=iterator.next();
				if(!student.isDefaulter()){
					iterator.remove();
				}
			}
		}
		return returnMap;
	}

	@Override
	public void offerGraseMarks(Map<Subject, List<Student>> map) {
		
		calculateMarks(map);
		Set<Map.Entry<Subject,List<Student>>> set1=map.entrySet();
		for (Entry<Subject, List<Student>> entry : set1) {
			Collections.sort(entry.getValue(),new Comparator<Student>() {
				@Override
				public int compare(Student s1, Student s2) {
					return s1.getSubmissionDate().compareTo(s2.getSubmissionDate());
				}
			});
			
			entry.getValue().get(0).setMarksObtained(entry.getValue().get(0).getMarksObtained()+3);
		}
		
	}

}
