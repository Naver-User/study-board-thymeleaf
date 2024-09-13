package org.zerock.myapp.controller;

import java.util.List;
import java.util.Vector;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


//@Log4j2
@Slf4j
@NoArgsConstructor

@Controller
public class HelloController {
	
	@GetMapping("/hello")
	void hello(Model model) {
		log.trace("hello() invoked.");
		
		model.addAttribute("GREETING", "Hello, Thymleaf");		
	} // hello
	
	@GetMapping("/hello2")
	void hello2(Model model) {
		log.trace("hello2() invoked.");
		
		Person person = new Person();
		person.setName("Yoseph");
		person.setAge(23);
		
		model.addAttribute("PERSON", person);		
	} // hello2
	
	@GetMapping("/hello3")
	void hello3(Model model) {
		log.trace("hello3() invoked.");
		
		List<Person> list = new Vector<>();
		
		IntStream.rangeClosed(1, 7).forEachOrdered(seq -> {
			Person person = new Person();
			person.setName("NAME_"+seq);
			person.setAge(20+seq);
			
			list.add(person);
		});	// .forEachOrdered
		
		model.addAttribute("LIST", list);		
	} // hello3
	
	@GetMapping("/hello4")
	void hello4(Model model) {
		log.trace("hello4() invoked.");
		
//		boolean isAuthenticated = true;		// 인증성공
		boolean isAuthenticated = false;	// 인증실패
		
		model.addAttribute("isAuthenticated", isAuthenticated);
	} // hello4
	
	@GetMapping("/hello5")
	void hello5(Model model) {	// View-Controller: 단순히 뷰만 보여주는 목적의 핸들러
		log.trace("hello5() invoked.");
	} // hello5
	
	@GetMapping("/hello6")
	void hello6(Model model) {
		log.trace("hello6() invoked.");
		
		Person newPerson = new Person();
		newPerson.setName("Yoseph");
		newPerson.setAge(23);
		
		model.addAttribute("PERSON", newPerson);
	} // hello6

} // end class


@Data
class Person {
	private String name;
	private Integer age;
	
	
} // end class
