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
import studentrestapi.studentservice.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentRepo student;
	@Autowired
	StudentService studentservice; 
	
	
	
	@GetMapping("/students/average")
    public ResponseEntity<String> calculateAverageMarks() {
        Student stud = new Student();
		int calculateAvgMark = studentservice.calculateAverage(stud);
		return ResponseEntity.ok("AvgMark" +calculateAvgMark);
		
		
    }
	
	
	@PostMapping("/students")
    public ResponseEntity<String> addStudent(@RequestBody Student stud) {
       
		studentservice.calculateAverageMark(stud);
		
        return ResponseEntity.ok("success");
    }
	
	
	@PutMapping("/{student_Id}/marks1/marks2/mark3")
	public ResponseEntity<String> UpdateMarks(@PathVariable int student_Id, int marks1, int marks2, int mark3)
	{
		
		studentservice.UpdateMark(student_Id, marks1, marks2, mark3);
		return ResponseEntity.ok("success");
		
		
	}
}
