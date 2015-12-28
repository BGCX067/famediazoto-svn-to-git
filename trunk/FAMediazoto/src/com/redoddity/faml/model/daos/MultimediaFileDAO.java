package com.redoddity.faml.model.daos;

import java.net.URI;
import java.util.ArrayList;

import com.redoddity.faml.model.MultimediaFile;

public class MultimediaFileDAO{
	private ArrayList<MultimediaFile> fileList;
	
	public MultimediaFileDAO() {
		try{
		fileList = new ArrayList<MultimediaFile>();
		fileList.add(new MultimediaFile(5L,"-.-",new URI("file:///home/asd.jpg"),0));
		fileList.add(new MultimediaFile(6L,"asd",new URI("file:///home/asd1.jpg"),0));
		}catch(Throwable t){
			t.printStackTrace();
		}
	}

	public ArrayList<MultimediaFile> getFiles() {
		return fileList;
	}

	public boolean addFile(MultimediaFile file) {
		return fileList.add(file);
	}

	public MultimediaFile searchMultimediaFile(String title) {
		for (MultimediaFile file : fileList) {
			if (file.getTitle().equals(title))
				return file;
		}
		return null;
	}

	public boolean deleteMultimediaFile(Long id) {
		for (MultimediaFile file : fileList) {
			if (file.getId().equals(id)) {
				fileList.remove(fileList.indexOf(file));
				return true;
			}
		}
		return false;
	}

	public boolean deleteAllMultimediaFiles() {
		return fileList.removeAll(fileList);
	}

	public boolean updateMultimediaFile(MultimediaFile mf) {
		for (MultimediaFile file : fileList) {
			if (file.getId().equals(mf.getId())) {
				fileList.set(fileList.indexOf(file), mf);
				return true;
			}
		}
		return false;
	}

}
