package com.redoddity.faml.controllers.load;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.redoddity.faml.controllers.BaseController;


public class LoadArtist extends BaseController {
	
	private String success;
	
	public LoadArtist(){};
	
	public void setSuccess(String success) {
		this.success = success;
	}


	 protected ModelAndView handleRequestInternal(
	            HttpServletRequest request,
	            HttpServletResponse response) throws Exception {
	        try {
	            Map model = new HashMap(1);
	            Long id = null;
	            id = Long.parseLong(request.getParameter("id"));
	            model.put("artists", getPersonDAO().getPerson(id));
	            return new ModelAndView(success, model);
	        } catch (Exception e) {
	            return new ModelAndView(getError(), "error", "loading error");
	        }
	    }

}