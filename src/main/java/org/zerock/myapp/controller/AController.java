package org.zerock.myapp.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


//@Log4j2
@Slf4j
@NoArgsConstructor

@RequestMapping("/A/")
@Controller
public class AController {
	
	@GetMapping("/SQL")
	void raiseSQL() throws SQLException {
		log.trace("raiseSQL() invoked.");
		
		throw new SQLException("TEST");
	} // raiseException
	
	
	// Local Exception Handler
	@ExceptionHandler(SQLException.class)
	String handleLocalException(Exception e, Model model) {
		log.trace("handleLocalException({}) invoked.", e);
		
		model.addAttribute("__EXCEPTION__", e);
		model.addAttribute("__STACKTRACE__", e.getStackTrace());
		
		// 접두사: classpath:/templates/, 접미사: .html
		return "errors/localError";	// 뷰의 이름 반환
	} // handleLocalException
	
	
	

} // end class