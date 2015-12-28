package com.redoddity.faml.servlets.filter;

import javax.servlet.http.*;
import javax.servlet.ServletOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class GZIPResponseWrapper  extends HttpServletResponseWrapper {
  protected HttpServletResponse origResponse = null;
  protected ServletOutputStream  stream = null;
  protected PrintWriter writer = null;
  private static Log logger =   LogFactory.getLog(GZIPResponseWrapper.class);

  public GZIPResponseWrapper(HttpServletResponse response) {
    super(response);
    origResponse = response;
  }

  public ServletOutputStream createOutputStream() throws IOException{
    return new GZIPResponseStream(origResponse);
  }
  public ServletOutputStream getOutputStream() throws IOException{
    if (writer != null) {
        throw new IllegalStateException("getWriter() has already been called!");
    }
    if(stream == null){
      stream = createOutputStream();
    }
    return stream;
  }

  public PrintWriter getWriter() throws IOException{
    if (writer != null) {
      return writer;
     }
     if (stream != null) {
       throw new IllegalStateException("getOutputStream() has already been called!");
     }
     stream = createOutputStream();
     writer=new PrintWriter(new OutputStreamWriter(stream,"UTF-8"));
     return writer;
  }

  public void setContentLength(int len){
    //Set by GZIPResponseStream
  }

  public void finishResponse(){
    try {
      if (writer != null) {
        writer.close();
      }
      else {
        if (stream != null) {
          stream.close();
        }
      }
      logger.debug("Finishing GZIP response...");
    }
    catch (IOException ex) {
    }
  }

  public void flushBuffer() throws IOException{
    stream.flush();
  }

}