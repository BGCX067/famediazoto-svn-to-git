package com.redoddity.faml.tests.daos;

import com.redoddity.faml.model.Album;

import com.redoddity.faml.model.Picture;

import com.redoddity.faml.model.Track;
import com.redoddity.faml.model.daos.AlbumDAO;
import com.redoddity.faml.model.mediagenres.AlbumGenre;
import com.redoddity.faml.model.people.Artist;
import com.redoddity.faml.model.people.ArtistGroup;

import junit.framework.TestCase;

public class AlbumDAOTest extends TestCase {
	AlbumDAO albumDAO = new AlbumDAO();
/*
	public Album createAlbum1() {
		Album album = new Album();
		album.setId(1L);
		album.setTitle("Eye of the Tiger");
		album.setGenre(new AlbumGenre());
		//album.setArtist(new Artist());
		album.setGroup(new ArtistGroup());
		album.setTracks(new Track[2]);
		album.setFrontCover(new Picture());
		return album;

	}/*
	public Album createAlbum2() {
		Album album2 = new Album();
		album2.setId(2L);
		album2.setTitle("Buoni o Cattivi");
		album2.setArtist(new Artist());
		//album2.setGroup(new ArtistGroup());
		album2.setTracks(new Track[10]);
		album2.setFrontCover(new Picture());
		return album2;
	}
	

	public void testAddAlbum() throws Exception {
		Album album = createAlbum1();
		Album a = albumDAO.addAlbum(album);
		assertEquals(a.equals(album), true);
	}

	public void testDeleteAlbum() throws Exception {
		Album album = albumDAO.addAlbum(createAlbum2());
		Album a = albumDAO.deleteAlbum(2L);
		assertEquals(a.equals(album), true);
	}

	public void testDeleteAll() throws Exception {
		albumDAO.addAlbum(createAlbum1());
		assertEquals(albumDAO.deleteAllAlbum(), new Integer(1));

	}

	public void testSearchAlbum() throws Exception {
		albumDAO.addAlbum(createAlbum2());
		Album a = albumDAO.searchAlbum(2L);
		assertNotNull(a);
		Album notFound = albumDAO.searchAlbum(3L);
		assertNull(notFound);
	}

	public void testUpdateAlbum() throws Exception {
		albumDAO.addAlbum(createAlbum1());
		Album a = albumDAO.searchAlbum(1L);
		assertNotNull(a);
		a.setTitle("Top 100");
		Album updated = albumDAO.updateAlbum(a);
		assertEquals(a.equals(updated), true);

	}
	
	public void testSearchByTitle()throws Exception{
		Album album = albumDAO.addAlbum(createAlbum2());
		Album a = albumDAO.searchAlbumByTitle("Buoni o Cattivi");
		assertEquals(a.equals(album), true);
		
	}
*/
}
