package com.redoddity.faml.model.daos;

import java.util.ArrayList;
import java.util.List;
import com.redoddity.faml.model.Media;

public class MediaDAO {
   private List<Media> media=new ArrayList<Media>();
   
   public void setMedia(List<Media> media){
	   this.media=media;
   }
   
   public List<Media> getMedia(){
	   return media;
   }
}
