package studentrestapi.stduententity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;



@javax.persistence.Entity
@javax.persistence.Table(name = "student")
public class Student {

	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int student_Id; 
	private String firstname;
	private String lastname; 
	private String dob; 
	private String section;
	private String gender;
	private int marks1;
	private int marks2;
	private int mark3;
	@JsonIgnore
	private int total;
	@JsonIgnore
	private int average;
	@JsonIgnore
	private String result;
	

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(int student_Id, String firstname, String lastname, String dob, String section, String gender,
			int marks1, int marks2, int mark3, int total, int average, String result) {
		super();
		this.student_Id = student_Id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.section = section;
		this.gender = gender;
		this.marks1 = marks1;
		this.marks2 = marks2;
		this.mark3 = mark3;
		this.total = total;
		this.average = average;
		this.result = result;
	}

	public int getStudent_Id() {
		return student_Id;
	}

	public void setStudent_Id(int student_Id) {
		this.student_Id = student_Id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getMarks1() {
		return marks1;
	}

	public void setMarks1(int marks1) {
		this.marks1 = marks1;
	}

	public int getMarks2() {
		return marks2;
	}

	public void setMarks2(int marks2) {
		this.marks2 = marks2;
	}

	public int getMark3() {
		return mark3;
	}

	public void setMark3(int mark3) {
		this.mark3 = mark3;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this.average = average;
	}

	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getMarks() {
	
		return  marks1+marks2+mark3;
	
	}

	
	
	
}
