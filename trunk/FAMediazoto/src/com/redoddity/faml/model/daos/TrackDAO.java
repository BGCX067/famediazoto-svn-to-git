package com.redoddity.faml.model.daos;

import java.util.ArrayList;
import java.util.List;

import com.redoddity.faml.model.Media;
import com.redoddity.faml.model.Track;
import com.redoddity.faml.model.mediagenres.TrackGenre;

public class TrackDAO {

	private List<Track> tracks;

	public void setTestData(List<Track> testData) {
		this.tracks = testData;
	}

	public List<Track> get() {
		return tracks;
	}

	public Media getTrack(Long id) {
		return findTrack(id);
	}

	private Media findTrack(Long id) {

		for (Media track : tracks) {
			if (track.getId().equals(id))
				return track;
		}

		return null;
	}

	public Media addTrack(Track track) {
		tracks.add(track);
		return track;

	}

	public List<Track> getByGenre(String genre) {
		List<Track> ret = new ArrayList<Track>();
		for (Track t : tracks) {			
			if (((TrackGenre)t.getGenre()).getGenre().equalsIgnoreCase(genre)) {			
				ret.add(t);
			}
		}		
		return ret;
	}


	public Media deleteTrack(Long id){
		Media found = findTrack(id);
		if (found != null) {
			tracks.remove(found);
			return found;
	}else return null;
		
	}
	
	public Media update(Long id, String title, Integer yr, Integer length){
		for (Track track : tracks) {
			if (track.getId().equals(id)){
				track.setTitle(title);
				track.setYr(yr);
				track.setLength(length);
			return track;
			}
		}
		return null;
	}
}
