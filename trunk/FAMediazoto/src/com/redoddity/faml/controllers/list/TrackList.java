package com.redoddity.faml.controllers.list;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.redoddity.faml.controllers.BaseController;
import com.redoddity.faml.model.Track;
import com.redoddity.faml.model.mediagenres.Genre;
import com.redoddity.faml.model.mediagenres.TrackGenre;
import com.redoddity.faml.model.people.Person;


public class TrackList extends BaseController {
	private String success;

    public TrackList() {
    }

    public void setSuccess(String success) {
        this.success = success;
    }


    protected ModelAndView handleRequestInternal(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        try {
        	Map<String,List<Track>> model = new HashMap<String,List<Track>>();
            List<Track> tracks = new ArrayList<Track>();
            String genre = null;
            genre = request.getParameter("genre");
            if(genre!=null){            	
            	tracks=getTrackDAO().getByGenre(genre);
            }else{
            	tracks=getTrackDAO().get();
            }                      
            model.put("tracks", tracks);
            return new ModelAndView(success, model);
        } catch (Exception e) {
            return new ModelAndView(getError(), "error","Errore");
        }
    }
}