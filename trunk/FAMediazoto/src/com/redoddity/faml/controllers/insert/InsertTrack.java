package com.redoddity.faml.controllers.insert;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.redoddity.faml.controllers.BaseController;
import com.redoddity.faml.model.Track;
import com.redoddity.faml.model.daos.TrackDAO;
import com.redoddity.faml.model.mediagenres.Genre;
import com.redoddity.faml.model.mediagenres.TrackGenre;
import com.redoddity.faml.model.people.Person;

public class InsertTrack extends BaseController {
	private String success;

	public InsertTrack() {
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			Map<String, List<Track>> model = new HashMap<String, List<Track>>();
			List<Track> tracks = new ArrayList<Track>();
			
			Long id = Long.parseLong(request.getParameter("id"));
			int year = Integer.parseInt(request.getParameter("yr"));
			String title = request.getParameter("title");
			Genre genre1 = new TrackGenre(request.getParameter("genre"));
			int length = Integer.parseInt(request.getParameter("length"));
			Person artist = getPersonDAO().findPerson(Long.parseLong(request.getParameter("artistId")));
			String lyrics = request.getParameter("lyrics");
			Track track = new Track(id, title, artist, genre1, length, year,
			   lyrics);
			
			TrackDAO trackDAO=getTrackDAO();
			trackDAO.addTrack(track);
			tracks = trackDAO.get();
			model.put("tracks", tracks);
			return new ModelAndView(success, model);
		} catch (Exception e) {
			return new ModelAndView(getError(), "error", "Errore");
		}
	}
}