package com.psl.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.psl.beans.Address;
import com.psl.beans.Student;
import com.psl.exceptions.InsufficientDataException;

//Override all the methods of the DataManager Interface
public class StudentDataManager implements DataManager {

	@Override
	public List<Student> populateData(String fileName) {
		// TODO Auto-generated method stub
		File f=new File(fileName);
		Scanner scr;
		String record,rs[];
		List <Student> ls=new ArrayList<Student>();
		try {
			scr = new Scanner(f);
			while(scr.hasNext()){
				record=scr.nextLine();
				//System.out.println(record);
				rs=record.split(",");
				//Student st=new Student(Integer.parseInt(rs[0]),rs[1],Integer.parseInt(rs[2]),new Address(rs[3],rs[4],rs[5]));
				//ls.add(new Student(Integer.parseInt(rs[0]),rs[1],Integer.parseInt(rs[2]),new Address(rs[3],rs[4],rs[5])));
String[] studentData = record.split(",");
				
				Student student = new Student();
				// if rollno not present then assign 0
				if (studentData[0].trim().length() > 0) {
					student.setRollno(Integer.parseInt(studentData[0]));
				} else
					student.setRollno(0);
				// studentName
				if (studentData[1].trim().equals(""))
					student.setStudentName(null);
				else
					student.setStudentName(studentData[1]);
				
				//Age
				
				if (studentData[2].trim().length() > 0) {
					student.setAge(Integer.parseInt(studentData[2]));
				} else
					student.setAge(0);
				Address address=new Address();
				// Address - street 
				if (studentData[3].trim().equals(""))
					address.setStreetName(null);
				else
					address.setStreetName(studentData[3].trim());
				
				
				//Address - city
				if (studentData[4].trim().equals(""))
					address.setCity(null);
				else
					address.setCity(studentData[4].trim());
				
				//Address - ZipCode
				if (studentData[5].trim().equals(""))
					address.setCity(null);
				else
					address.setZipCode(studentData[5].trim());
				
				
				student.setAddress(address);
				ls.add(student);

				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ls;
	}

	@Override
	public void validateData(List<Student> studentList)
			throws InsufficientDataException {
		
		for(Student s:studentList){
			if(s.getStudentName()==null){
				studentList.remove(s);
				throw new InsufficientDataException();
			}
		}
		int i=0;
		for(Student s:studentList){
			System.out.println(s);
			i++;
		}
		System.out.println("Total:");
		
		
	}

	@Override
	public void sortData(List<Student> studentList) {
		// TODO Auto-generated method stub
		/*Comparable<Student> compare2=new Comparable<Student>(){

			@Override
			public int compare(Student arg0, Student arg1) {
				// TODO Auto-generated method stub
				if(arg0.getStudentName()==arg1.getStudentName()){
					if(arg0.getAge()==arg1.getAge()){
						return arg0.getRollno()-arg1.getRollno();
					}else
						return arg0.getAge()-arg1.getAge();
				}
				else
					return arg0.getStudentName().compareTo(arg1.getStudentName());
				//return 0;
			}

			@Override
			public int compareTo(Student arg0) {
				// TODO Auto-generated method stub
				if(this.getStudentName()==arg0.getStudentName()){
					if(this.getAge()==arg0.getAge()){
						return this.getRollno()-arg0.getRollno();
					}else
						return this.getAge()-arg0.getAge();
				}
				else
					return this.getStudentName().compareTo(arg0.getStudentName());
			}
			
		};*/
		Collections.sort(studentList);
	}

	
}
