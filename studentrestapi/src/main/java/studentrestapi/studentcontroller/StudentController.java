package studentrestapi.studentcontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import studentrestapi.stduententity.Student;
import studentrestapi.studentrepo.StudentRepo;

@Controller
public class StudentController {

	@Autowired
	StudentRepo student;
	
	
	
	
	@GetMapping("/students/average")
    public ResponseEntity<String> calculateAverageMarks() {
        Iterable<Student> students = student.findAll();

        int totalMarks = 0;
        int count = 0;

        for (Student student : students) {
            totalMarks += student.getTotal();
            count++;
        }
        
        double averageMarks = totalMarks / count;
        //String result = (totalMarks >= 35) ? "Pass" : "Fail";
        
        if (count > 35) {
        	
           // double averageMarks = totalMarks / count;
       
           // return ResponseEntity.ok("Avg mark of the student"+averageMarks);
        	return ResponseEntity.ok("Pass");
        } else {
            return ResponseEntity.ok("Fail");
        	//return new ResponseEntity<>
        }
    }
	
	
	@PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student stud) {
        // Calculate total marks
        int totalMarks = stud.getMarks();
           
        // Calculate average
        int average = totalMarks;

        // Determine result
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

        // Save the student object to the database
        Student savedStudent = student.save(stud);

        return ResponseEntity.ok(savedStudent);
    }
	
	
	@PutMapping("/{student_Id}/marks1/marks2/mark3")
	public ResponseEntity<String> UpdateMarks(@PathVariable int student_Id, int marks1, int marks2, int mark3)
	{
		Optional<Student> optionalStudent = student.findById(student_Id);
		 //int totalMarks = stud.getMarks();
		 
		if(optionalStudent.isPresent())
		{
			Student stud = optionalStudent.get();
			stud.setMarks1(marks1);
			stud.setMarks2(marks2);
			stud.setMark3(mark3);
			int totalMarks = stud.getMarks();
			stud.setTotal(totalMarks);
			  int average = totalMarks;
			  String result = (totalMarks >= 35) ? "Pass" : "Fail";
			  stud.setAverage(average);
			  stud.setResult(result);
			student.save(stud);
			return  ResponseEntity.ok("Student Marks updated successfully");
		}
		else
		{
		return  ResponseEntity.notFound().build();
	}
	
	}
}
