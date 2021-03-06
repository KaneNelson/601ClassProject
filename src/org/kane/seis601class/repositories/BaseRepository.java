package org.kane.seis601class.repositories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BaseRepository {
	//class members 
	protected String filename;
	protected String directory;
	private boolean fileExist(){
		File f = new File(directory + filename);
		return f.exists();
	}
	
	//constructor
	public BaseRepository() {
		String currentDir = new File(".").getAbsolutePath();
		this.directory = currentDir + "/Data/";
		
	}
	
	//methods
	public void dirExist(){
		File d = new File(directory);
		if(!d.exists()){
			d.mkdir();
		}
	}
	
	//reading the object
	public Object deserializeObj(){
		dirExist();
		if(!fileExist()){
			return null;
		}
		Object returnObj = null;
		try {
			FileInputStream filein = new FileInputStream(directory + filename);
			ObjectInputStream in = new ObjectInputStream(filein);
			returnObj=in.readObject();
			in.close();
			filein.close();
			
		} catch (Exception e) {
		
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnObj;
	}
	
	//store object in a text file
	public void serialize(Object saveObj){
		try {
			FileOutputStream fileout = new FileOutputStream(directory + filename);
			ObjectOutputStream out = new ObjectOutputStream(fileout);
			out.writeObject(saveObj);
			out.close();
			fileout.close();
			
		} catch (Exception e) {
		
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


	
}
