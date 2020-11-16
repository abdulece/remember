package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class prop {
/*	public static String writeData() throws IOException
	{
		File file=new File("C:\\Users\\abdul\\Desktop\\config.properties");
		FileOutputStream fos=new FileOutputStream(file);
		
		Properties prope=new Properties();
		prope.setProperty("Pwd", "123@abc");
		prope.setProperty("Browswer", "Chrome");
		prope.setProperty("Environment", "SIT");
		prope.store(fos, "Test Purpose");
		fos.close();
		
		return null;
	}
    */
	
	public static String readData(String key) throws IOException {
		
		File file=new File("C:\\Users\\abdul\\Desktop\\config.properties");
		
		FileInputStream fis=new FileInputStream(file);
		
		Properties proper=new Properties();
		
		proper.load(fis);
		String value=proper.getProperty(key);
		
		return value;
		
	}
	public static void main(String[] args) throws IOException {
		
	//	writeData();
		readData("Environment");
	}
}
