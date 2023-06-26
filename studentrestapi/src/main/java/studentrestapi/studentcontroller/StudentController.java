package studentrestapi.studentcontroller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import studentrestapi.stduententity.Student;
import studentrestapi.studentrepo.StudentRepo;

@Controller
public class StudentController {

	@Autowired
	StudentRepo student;
	
	
	
	
	@GetMapping("/students/average")
    public ResponseEntity<Double> calculateAverageMarks() {
        Iterable<Student> students = student.findAll();

        int totalMarks = 0;
        int count = 0;

        for (Student student : students) {
            totalMarks += student.getTotal();
            count++;
        }

        if (count > 0) {
            double averageMarks = totalMarks / count;
            return ResponseEntity.ok(averageMarks);
        } else {
            return ResponseEntity.ok(0.0);
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
	
	
}
