package com.redoddity.faml.model.daos;

import com.redoddity.faml.model.Picture;
import java.util.ArrayList;

public class PictureDAO{
	private ArrayList<Picture> pictureList;
	
	public PictureDAO() {
		pictureList = new ArrayList<Picture>();
	}
	
	public boolean addPic(Picture p){
		return pictureList.add(p);
	}
	
	public Picture searchPic(String title) {
		for (Picture p : pictureList) {
			if (p.getTitle().equals(title))
				return p;
		}
		return null;
	}
	
	public boolean deletePic(Long id) {
		for (Picture p : pictureList) {
			if (p.getId().equals(id)) {
				pictureList.remove(pictureList.indexOf(p));
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteAllPic() {
		return pictureList.removeAll(pictureList);
	}
	
	public boolean updatePic(Picture pic) {
		for (Picture p : pictureList) {
			if (p.getId().equals(pic.getId())) {
				pictureList.set(pictureList.indexOf(p), pic);
				return true;
			}
		}
		return false;
	}
}
