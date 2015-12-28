package com.redoddity.faml.controllers.insert;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.redoddity.faml.controllers.BaseController;
import com.redoddity.faml.model.Album;
import com.redoddity.faml.model.Image;
import com.redoddity.faml.model.Picture;
import com.redoddity.faml.model.Track;
import com.redoddity.faml.model.daos.AlbumDAO;
import com.redoddity.faml.model.daos.TrackDAO;
import com.redoddity.faml.model.mediagenres.AlbumGenre;
import com.redoddity.faml.model.mediagenres.Genre;
import com.redoddity.faml.model.mediagenres.TrackGenre;
import com.redoddity.faml.model.people.Artist;
import com.redoddity.faml.model.people.Person;
import com.redoddity.faml.Utils;;

public class InsertAlbum extends BaseController {
	private String success;

	public InsertAlbum() {
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			Map<String, List<Album>> model = new HashMap<String, List<Album>>();
			List<Album> albums = new ArrayList<Album>();
			
			Long id = Long.parseLong(request.getParameter("id"));
			String title = request.getParameter("title");
			Person artist = getPersonDAO().findPerson(Long.parseLong(request.getParameter("artistId")));
			List<Track> tracks =null;
			AlbumGenre genre = new AlbumGenre(request.getParameter("genre"));
			Picture frontCover = null;
			Album album = new Album(id, title, tracks, artist, frontCover, genre);				
			AlbumDAO albumDAO=getAlbumDAO();
			albumDAO.addAlbum(album);
			albums = albumDAO.get();
			model.put("album", albums);
			return new ModelAndView(success, model);
		} catch (Exception e) {
			return new ModelAndView(getError(), "error", "Errore");
		}
	}
}