package com.redoddity.faml.model.daos;

import java.util.List;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.redoddity.faml.model.Album;
import com.redoddity.faml.model.Media;
import com.redoddity.faml.model.Track;

public class AlbumDAO{
	private transient Log log = LogFactory.getLog(AlbumDAO.class);
	private List<Album> albums;
	
	public void setTestData(List<Album> testData) {
		this.albums = testData;
	}
	
	public List<Album> get() {
		return albums;
	}
	
	public Album getAlbum(Long id){
		return findAlbum(id);
	}
	
	private Album findAlbum(Long id) {

		for (Album album : albums) {
			if (album.getId().equals(id))
				return album;
		}

		return null;
	}
	
	public Album addAlbum(Album album) {
		albums.add(album);
		return album;

	}

	public List<Album> getByGenre(String genre) {
		List<Album> ret = new ArrayList<Album>();
		for (Album a : albums) {
			log.info("Album genre: "+a.getGenre().getGenre());
			if (a.getGenre().getGenre().equalsIgnoreCase(genre)){
				log.debug("Album "+a.getTitle()+" added");
				ret.add(a);
			}
		}
		log.info("Return size: "+ret.size());
		return ret;
	}
	public Album deleteAlbum(Long id){
		Album found = findAlbum(id);
		if (found != null) {
			albums.remove(found);
			return found;
	}else return null;
		
	}
	
	public Album update(Long id, String title){
		for (Album album : albums) {
			if (album.getId().equals(id)){
				album.setTitle(title);
				
			return album;
			}
		}
		return null;
	}

}

