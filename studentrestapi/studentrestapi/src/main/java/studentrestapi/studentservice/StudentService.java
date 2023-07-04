package studentrestapi.studentservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import studentrestapi.stduententity.Student;
import studentrestapi.studentrepo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	StudentRepo student;
	public String calculateAverageMark(Student stud)
	{
		    int totalMarks = stud.getMarks();
	        int average = totalMarks;
	        String result = (totalMarks >= 35) ? "Pass" : "Fail";
	        String firstname  = stud.getFirstname();
	        String lastname = stud.getLastname();
	        String dob = stud.getDob();
	        String section = stud.getSection();
	        String gender = stud.getGender();
	        int mark1 = stud.getMarks1();
	        int mark2 = stud.getMarks2();
	        int mark3  = stud.getMark3();
	        // Set values in student object
	        //stud.setFirstname()
	        stud.setTotal(totalMarks);
	        stud.setAverage(average);
	        stud.setResult(result);
	        Student savedStudent = student.save(stud);
			return "success";
		
	}
	
	
	public int calculateAverage(Student stud)
	{
		
		 Iterable<Student> students = student.findAll();
		 int totalMarks = 0;
	        int count = 0;

		 int marks = stud.getMarks();
		 for (Student student : students) {
	            totalMarks += student.getTotal();
	            count++;
	        }
		 int averageMarks = totalMarks / count;
		 
		
		 
		 
		 
		return averageMarks;
		
		
	}
	
	
	public String UpdateMark(int student_Id, int marks1, int marks2, int mark3)
	{
		Student stud = new Student();
		int student_id  = stud.getStudent_Id();
		Optional<Student> optionalStudent = student.findById(student_id);
		if(optionalStudent.isPresent())
		{
			Student stud1 = optionalStudent.get();
			stud1.setMarks1(marks1);
			stud.setMarks2(marks2);
			stud.setMark3(mark3);
			int totalMarks = stud.getMarks();
			stud.setTotal(totalMarks);
			  int average = totalMarks;
			  String result = (totalMarks >= 35) ? "Pass" : "Fail";
			  stud.setAverage(average);
			  stud.setResult(result);
			student.save(stud);
			return  "Student Marks updated successfully";
		}
		return "Student Marks Not updated successfully";
		
		
	}
	
	
	
}
