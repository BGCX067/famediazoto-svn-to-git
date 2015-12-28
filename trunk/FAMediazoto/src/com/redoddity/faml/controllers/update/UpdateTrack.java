package com.redoddity.faml.controllers.update;



import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.redoddity.faml.controllers.BaseController;



public class UpdateTrack extends BaseController {
	
	private String success;
	
	public UpdateTrack(){};
	
	public void setSuccess(String success) {
		this.success = success;
	}


	 protected ModelAndView handleRequestInternal(
	            HttpServletRequest request,
	            HttpServletResponse response) throws Exception {
	        try {
	            Map model = new HashMap(1);
	            String title = null;
	            Long id=null;
	            Integer yr;
	            Integer length;
	            title = request.getParameter("title");
	            yr = Integer.parseInt(request.getParameter("yr"));
	            length = Integer.parseInt(request.getParameter("length"));
	            id= Long.parseLong(request.getParameter("id"));
	            model.put("track", getTrackDAO().update(id, title, yr, length));
	            return new ModelAndView(success, model);
	        } catch (Exception e) {
	            return new ModelAndView(getError(), "error", "update error");
	        }
	    }

}