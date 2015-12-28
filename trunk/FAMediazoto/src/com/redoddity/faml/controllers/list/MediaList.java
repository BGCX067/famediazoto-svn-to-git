package com.redoddity.faml.controllers.list;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import com.redoddity.faml.controllers.BaseController;
import com.redoddity.faml.model.Media;

public class MediaList extends BaseController {
	private String success;

    public MediaList() {
    }

    public void setSuccess(String success) {
        this.success = success;
    }


    protected ModelAndView handleRequestInternal(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        try {
            Map<String,List<Media>> model = new HashMap<String,List<Media>>(1);
            List<Media> media=getMediaDAO().getMedia();
            model.put("media",media);
            return new ModelAndView(success, model);
        } catch (Exception e) {
            return new ModelAndView(getError(), "error","Errore");
        }
    }
}