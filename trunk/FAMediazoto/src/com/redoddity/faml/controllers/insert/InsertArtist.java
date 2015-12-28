package com.redoddity.faml.controllers.insert;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.redoddity.faml.controllers.BaseController;
import com.redoddity.faml.model.Track;
import com.redoddity.faml.model.daos.PersonDAO;
import com.redoddity.faml.model.daos.TrackDAO;
import com.redoddity.faml.model.mediagenres.Genre;
import com.redoddity.faml.model.mediagenres.TrackGenre;
import com.redoddity.faml.model.people.Artist;
import com.redoddity.faml.model.people.Person;

public class InsertArtist extends BaseController{
	private String success;

	public InsertArtist() {
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			Map<String, List<Person>> model = new HashMap<String, List<Person>>();
			List<Person> people = new ArrayList<Person>();
			
			Long id = Long.parseLong(request.getParameter("id"));
			String name = request.getParameter("name");
			String lastname = request.getParameter("lastname");
			String stageName = request.getParameter("stageName");
			//Date birthDate = request.getParameter("birthDate");
			//Picture
			Person artist = new Artist(id, null, name, lastname, stageName, null);//Date+ Picture
					
			
			PersonDAO personDAO=getPersonDAO();
			personDAO.addPerson(artist);
			people = personDAO.get();
			model.put("people", people);
			return new ModelAndView(success, model);
		} catch (Exception e) {
			return new ModelAndView(getError(), "error", "Errore");
		}
	}
}
