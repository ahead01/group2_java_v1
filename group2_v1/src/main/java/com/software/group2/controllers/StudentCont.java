/**
 * 
 */
package com.software.group2.controllers;

import java.math.BigInteger;
import java.util.Optional;

/**
 * @author Austin
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.software.group2.entities.Student;
import com.software.group2.repos.StudentRepo;



@Controller    // This means that this class is a Controller
@RequestMapping(path="/student") // This means URL's start with /software (after Application path)
public class StudentCont {
	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private StudentRepo studentRepository;

	@PostMapping(path="/add" , consumes= {"application/json"}) // Map ONLY POST Requests
	public @ResponseBody String addNewStudent (@RequestBody Student n) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		System.out.println(studentRepository.save(n).toString());
		return "Saved";
	}

	@GetMapping(path="/getall")
	public @ResponseBody Iterable<Student> getAllAdmins() {
		// This returns a JSON or XML with the users
		return studentRepository.findAll();
	}
	
	@GetMapping(path="/getone/id")
	public @ResponseBody Optional<Student> getOneStudent(@RequestParam Integer id) {
		// This returns a JSON or XML with the admin
		return studentRepository.findById(id);
	}
	
	@GetMapping(path="/checkone/user")
	public @ResponseBody boolean checkOneStudentUser(@RequestParam String studentUserName) {
		// This returns a JSON or XML with the admin
		 BigInteger ret = studentRepository.checkBystudentUserName(studentUserName);
		 int result = ret.intValue();
		 System.out.println(result);
		 if(result == 1) {
			 return true;
		 }
		 return false;
		 
	}
	
	@GetMapping(path="/getone/user")
	public @ResponseBody Optional<Student> getOneStudentUser(@RequestParam String studentUserName) {
		// This returns a JSON or XML with the admin
		 return studentRepository.findBystudentUserName(studentUserName);

		 
	}
}

