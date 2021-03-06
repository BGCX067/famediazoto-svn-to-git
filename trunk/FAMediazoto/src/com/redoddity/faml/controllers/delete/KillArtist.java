package com.redoddity.faml.controllers.delete;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.redoddity.faml.controllers.BaseController;

public class KillArtist extends BaseController{
	private String success;

    public KillArtist() {
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            Map model = new HashMap(1);
            Long id = null;
            id = new Long(request.getParameter("id"));
            model.put("person", getPersonDAO().deletePerson(id));
            return new ModelAndView(success, model);
        } catch (Exception e) {
           return new ModelAndView(getError(), "error", "error");
        }
    }
}
