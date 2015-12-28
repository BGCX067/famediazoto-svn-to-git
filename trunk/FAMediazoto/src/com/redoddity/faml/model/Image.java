package com.redoddity.faml.model;

import java.io.*;
import java.net.URI;

import com.redoddity.faml.Utils;

public class Image {
	private transient InputStream fis = null;
	private URI uri;

	//CONSTRUCTORS
	public Image() {}
	public Image(URI uri) {
		this.uri = uri;
	}
	//GETTERS
	public URI getUri() {
		return uri;
	}

	//SETTERS
	public void setUri(URI uri) {
		this.uri = uri;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this==o)	return true;
		if(o==null || !(o instanceof Image)) return false;
		Image other = (Image) o;		
		return Utils.equals(this.getUri(),other.getUri());
	}

	// USEFUL METHODS
	public InputStream getImage(boolean buffered) throws FileNotFoundException {
		File imgFile = getFileIfReadable();
		if(buffered){
			fis = new BufferedInputStream(new FileInputStream(imgFile));
		}else{
			fis= new FileInputStream(imgFile);
		}
		return fis;

	}
	private File getFileIfReadable() {
		File ret = new File(getUri());
		if (!ret.exists() || !ret.canRead()) {
			return null;
		}
		return ret;
	}

	
/*	// useful for copy-and-paste
	private boolean copy(File file, File destination, boolean buffered) {
		if (file.equals(destination))
			return false;
		InputStream fis = null;
		OutputStream fos = null;
		boolean success = false;
		try {
			fis = new BufferedInputStream(new FileInputStream(file));
			fos = new BufferedOutputStream(new FileOutputStream(destination));
			long start = System.currentTimeMillis();
			if (buffered) {
				final int size = 8192;
				byte[] buffer = new byte[size];
				int read;
				while ((read = fis.read(buffer, 0, size)) != -1) {
					fos.write(buffer, 0, read);
				}

			} else {
				int read;
				while ((read = fis.read()) != -1) {
					fos.write(read);
				}
			}
			success = true;
			print("copy duration: " + (System.currentTimeMillis() - start));

		} catch (IOException ioe) {
			success = false;
		} finally {
			try {
				if (fos != null)
					fos.close();
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				success = false;
			}
		}

		return success;
	}
	*/
}
