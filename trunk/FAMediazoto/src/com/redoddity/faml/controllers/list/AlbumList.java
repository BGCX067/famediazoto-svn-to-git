package com.redoddity.faml.controllers.list;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import com.redoddity.faml.controllers.BaseController;
import com.redoddity.faml.model.Album;


public class AlbumList extends BaseController {
	private transient Log log = LogFactory.getLog(AlbumList.class);
	private String success;

    public AlbumList() {
    }

    public void setSuccess(String success) {
        this.success = success;
    }


    protected ModelAndView handleRequestInternal(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
    	Map<String,List<Album>> model = new HashMap<String,List<Album>>(1);
    	List<Album> albums= new ArrayList<Album>();
        try {            
            String genre = null;
            genre = request.getParameter("genre");
            if(genre!=null){
            	log.debug("Genre: "+genre);
            	albums=getAlbumDAO().getByGenre(genre);
            }else{
            	albums=getAlbumDAO().get();
            }          
            model.put("albums", albums);
            return new ModelAndView(success, model);
        } catch (Exception e) {
        	log.error("Exception: "+e.getMessage());
            return new ModelAndView(getError(), "error","Errore");
        }
    }

}