package org.training.issueTracker.web.controllers;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	private final String START_PAGE = "StartPage";
		
	public LogoutController() {
	        super();
	       
	}
	   	   
   @RequestMapping(value = "/LogoutController")
    
    public void doLogout( HttpSession httpSession, HttpServletResponse res ) throws IOException {
	    if (httpSession!= null){
	    	httpSession.invalidate();
      }
      res.sendRedirect(START_PAGE);
	}
}   


