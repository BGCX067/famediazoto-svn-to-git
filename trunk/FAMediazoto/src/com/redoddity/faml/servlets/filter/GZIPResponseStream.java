package com.redoddity.faml.servlets.filter;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;


public class GZIPResponseStream extends ServletOutputStream {
  protected ByteArrayOutputStream baos = null;
  protected GZIPOutputStream gzipstream = null;
  protected boolean closed = false;
  protected HttpServletResponse response = null;
  protected ServletOutputStream output = null;
  private static Log logger =   LogFactory.getLog(GZIPResponseStream.class);

  protected GZIPResponseStream(HttpServletResponse resp) throws IOException{
    super();
    closed = false;
    this.response=resp;
    this.output=response.getOutputStream();
    baos=new ByteArrayOutputStream();
    gzipstream = new GZIPOutputStream(baos);
  }

  public void close() throws IOException {
    if(closed){
      throw new IOException("This output stream has already been closed");
    }
    gzipstream.finish();
    byte[] bytes = baos.toByteArray();

    response.addHeader("Content-Length",Integer.toString(bytes.length));
    response.addHeader("Content-Encoding","gzip");
    output.write(bytes);
    output.flush();
    output.close();
    closed=true;
    logger.info("GZIPResponseStream stream closed");
  }
  public void flush() throws  IOException{
    if(closed){
      throw new IOException("Cannot flush a closed output stream");
    }
    gzipstream.flush();
  }

  public void write(int b) throws  IOException{
    if (closed) {
      throw new IOException("Cannot write to a closed output stream");
    }
    gzipstream.write((byte)b);
  }

  public void write(byte b[]) throws  IOException{
    write(b,0,b.length);
  }

  public void write(byte b[], int off, int len) throws  IOException{
    logger.debug("writing into a compressed stream...");
    if(closed){
      throw new IOException("Cannot write to a closed output stream");
    }
    gzipstream.write(b, off, len);
  }

  public boolean closed(){
    return closed;
  }

  public void reset(){}

}

