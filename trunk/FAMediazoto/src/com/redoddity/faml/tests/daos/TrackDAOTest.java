package com.redoddity.faml.tests.daos;

import com.redoddity.faml.model.Track;
import com.redoddity.faml.model.daos.TrackDAO;
import com.redoddity.faml.model.people.ArtistGroup;

import junit.framework.TestCase;

public class TrackDAOTest extends TestCase {
	TrackDAO trackDAO = new TrackDAO();
/*
	public Track createTrack() {
		Track track = new Track();
		track.setId(1L);
		track.setTitle("Eye of Tiger");
		track.setGroup(new ArtistGroup());
		//track.setArtist(new Artist());
		track.setLength(200);
		track.setGenre("rock");
		track.setYr(1982);// seconds
		
		return track;
	                
	    }
	 
	 
	    public void addTrack() throws Exception{
	        Track track= createTrack();
	        Track t = trackDAO.addTrack(track);
	        assertEquals(t.equals(track), true);
	      
	    }
	    /*
	    public void testDeleteTrack() throws Exception {	
	    	Track track = trackDAO.addTrack(createTrack());		
			Track t = trackDAO.deleteTrack(1L);
			
			assertEquals(t.equals(track), true);
			Track notFound = trackDAO.deleteTrack(2L);
			assertNull(notFound);
		}
	    
	    public void testUpdateTrack() throws Exception {
	    	trackDAO.addTrack(createTrack());
	    	Track t = trackDAO.getTrack(1L);
	    	t.setLyrics("It's the eye of the Tiger");
	    	Track updated = trackDAO.updateTrack(t);
	    	assertEquals(t.equals(updated), true);

	}
	    
	    public void testRemoveAllTracks() throws Exception {
			trackDAO.addTrack(createTrack());
			assertEquals(trackDAO.removeAllTrack(),new Integer(1));
		}

	    public void testSearchTrack() throws Exception {
			trackDAO.addTrack(createTrack());
			Track t = trackDAO.searchTrack(1L);
			assertNotNull(t);
			Track notFound = trackDAO.searchTrack(3L);
			assertNull(notFound);
		}
	    public void testSearchByTitle()throws Exception{
			Track track = trackDAO.addTrack(createTrack());
			Track t = trackDAO.searchTrackByTitle("Eye of Tiger");
			assertEquals(t.equals(track), true);
			
		}
		*/
	    
}