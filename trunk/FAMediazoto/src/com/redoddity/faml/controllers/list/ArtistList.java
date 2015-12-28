package com.redoddity.faml.controllers.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import com.redoddity.faml.controllers.BaseController;
import com.redoddity.faml.model.people.Artist;
import com.redoddity.faml.model.people.Director;
import com.redoddity.faml.model.people.Person;
import com.redoddity.faml.model.people.Photographer;


public class ArtistList extends BaseController {
	private String success;

    public ArtistList() {
    }

    public void setSuccess(String success) {
        this.success = success;
    }


    protected ModelAndView handleRequestInternal(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        try {
            Map<String,List<Person>> model = new HashMap<String,List<Person>>(1);
            List<Person> people=getPersonDAO().getPeople();
            List<Person> artists=new ArrayList<Person>();
            for (Person person : people) {
				if ((person instanceof Artist)||(person instanceof Director)||(person instanceof Photographer)){
					artists.add(person);
				}
			}
            Collections.sort(artists);
            model.put("artists",artists);
            return new ModelAndView(success, model);
        } catch (Exception e) {
            return new ModelAndView(getError(), "error","Errore");
        }
    }
}