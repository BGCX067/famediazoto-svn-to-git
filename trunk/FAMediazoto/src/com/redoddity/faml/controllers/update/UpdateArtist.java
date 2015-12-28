package com.redoddity.faml.controllers.update;



import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.redoddity.faml.controllers.BaseController;



public class UpdateArtist extends BaseController {
	
	private String success;
	
	public UpdateArtist(){};
	
	public void setSuccess(String success) {
		this.success = success;
	}


	 protected ModelAndView handleRequestInternal(
	            HttpServletRequest request,
	            HttpServletResponse response) throws Exception {
	        try {
	            Map model = new HashMap(1);
	            Long id=null;
	            String name = null;
	            String lastname = null;
	            String stageName = null;
	            //DATE
	            //PICTURE
	            id= Long.parseLong(request.getParameter("id"));
	            name = request.getParameter("name");
	            lastname = request.getParameter("lastname");
	            stageName = request.getParameter("stageName");
	            //date
	            //picture
	            model.put("artists", getPersonDAO().update(id, name, lastname, stageName, null, null));
	            return new ModelAndView(success, model);
	        } catch (Exception e) {
	            return new ModelAndView(getError(), "error", "update error");
	        }
	    }

}