package com.redoddity.faml.controllers;

import org.springframework.web.servlet.mvc.AbstractController;

import com.redoddity.faml.model.daos.AlbumDAO;
import com.redoddity.faml.model.daos.MediaDAO;
import com.redoddity.faml.model.daos.PersonDAO;
import com.redoddity.faml.model.daos.TrackDAO;

public abstract class BaseController extends AbstractController {

    protected String error;
    protected TrackDAO trackDAO;
    protected PersonDAO personDAO;
    protected AlbumDAO albumDAO;
    protected MediaDAO mediaDAO;
    public BaseController() {
    }

    protected String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

	public TrackDAO getTrackDAO() {
		return trackDAO;
	}

	public void setTrackDAO(TrackDAO trackDAO) {
		this.trackDAO = trackDAO;
	}

	public PersonDAO getPersonDAO() {
		return personDAO;
	}

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	public AlbumDAO getAlbumDAO() {
		return albumDAO;
	}

	public void setAlbumDAO(AlbumDAO albumDAO) {
		this.albumDAO = albumDAO;
	}
	
	public MediaDAO getMediaDAO() {
		return mediaDAO;
	}

	public void setMediaDAO(MediaDAO mediaDAO) {
		this.mediaDAO = mediaDAO;
	}
}
