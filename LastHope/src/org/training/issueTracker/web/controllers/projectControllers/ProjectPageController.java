package org.training.issueTracker.web.controllers.projectControllers;


import java.util.ArrayList;
import java.util.List;

import org.training.issueTracker.beans.Project;
import org.training.issueTracker.service.DAO.DAOInterfaces.DAOInterface;
import org.training.issueTracker.service.exceptions.DAOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller


public class ProjectPageController {


	private final String CAUSE = "cause";
  	private final String DAO_ERROR_PAGE = "DAOErrPage";    
  	private final String PAGE = "page";
	private final String PROJECT_PAGE = "projectPage";
	private final String PROJECT_LIST ="projectList";
	private final String CURENT_PAGE ="currentPage";
	private final String PROJECT_PAGE_NUMBER ="projectPageNumber";
  
  
	@Autowired
    DAOInterface implDAO;
 
  
	@Autowired
    Project project;
  
  
 
	public ProjectPageController() {
      super();
     
	}
  
	
	@RequestMapping(value = "/ProjectPageController")
    public String prepareType( @RequestParam (PAGE) int currentPage, ModelMap model) {
		


		int offset = 0;
		int capacity = 10;
		
		List <Integer> projectPageNumber = new ArrayList<>();
	
		if (currentPage>1){
			offset = (currentPage-1)*10;
		}
		try {	
		
			List<Project>  projectList = implDAO.getSubListProject( offset,  capacity);
				
			projectPageNumber = implDAO.getRowsNumberFromProjectTable();
			
			model.addAttribute(PROJECT_LIST, projectList);
			model.addAttribute(CURENT_PAGE, currentPage);
			model.addAttribute(PROJECT_PAGE_NUMBER, projectPageNumber);
			
		
		} catch (DAOException | ClassNotFoundException e) {
			model.addAttribute(CAUSE, e.getMessage());
			return DAO_ERROR_PAGE;
			
		}
		return	PROJECT_PAGE ;
	
	}
}

