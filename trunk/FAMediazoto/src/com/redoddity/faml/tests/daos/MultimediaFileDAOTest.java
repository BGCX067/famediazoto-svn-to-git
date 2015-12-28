package com.redoddity.faml.tests.daos;

import java.net.URI;

import junit.framework.TestCase;
import com.redoddity.faml.model.MultimediaFile;
import com.redoddity.faml.model.daos.MultimediaFileDAO;


public class MultimediaFileDAOTest extends TestCase{
	private MultimediaFileDAO mfd = new MultimediaFileDAO();
	
	protected void setUp() throws Exception {
		super.setUp();
		mfd.addFile(new MultimediaFile(1L,"immagine1",new URI("file://img.jpg"),0));
		mfd.addFile(new MultimediaFile(2L,"immagine2",new URI("file://img.jpg"),0));
		mfd.addFile(new MultimediaFile(3L,"immagine3",new URI("file://img.jpg"),0));
		mfd.addFile(new MultimediaFile(4L,"immagine4",new URI("file://img.jpg"),0));
	}
	
	public void testAddMultimediaFile() throws Exception {
		MultimediaFile file= new MultimediaFile(5L,"immagine5",new URI("file://img.jpg"),0);
		assertEquals(mfd.addFile(file),true);
	}
	
    public void testSearchMultimediaFile() throws Exception{
		MultimediaFile file= new MultimediaFile(2L,"immagine2",new URI("file://img.jpg"),0);
		assertEquals(mfd.searchMultimediaFile("immagine2"),file);
	}
	
	public void testDeleteMultimediaFile() throws Exception{
		mfd.deleteMultimediaFile(mfd.searchMultimediaFile("immagine2").getId());
		assertEquals(mfd.searchMultimediaFile("immagine2"),null);
	}
	
	public void testDeleteAllMultimediaFiles() throws Exception{
		assertEquals(mfd.deleteAllMultimediaFiles(),true);
		assertEquals(mfd.searchMultimediaFile("immagine1"),null);
		assertEquals(mfd.searchMultimediaFile("immagine2"),null);
		assertEquals(mfd.searchMultimediaFile("immagine3"),null);
		assertEquals(mfd.searchMultimediaFile("immagine4"),null);
	}
	
	public void testUpdateMultimediaFile() throws Exception{
		MultimediaFile file= new MultimediaFile(1L,"immagine35",new URI("file://img.jpg"),56);
		assertEquals(mfd.updateMultimediaFile(file),true);         // test if the multimedia file was updated succeffully
		assertEquals(mfd.searchMultimediaFile("immagine35"),file);
	}
}
