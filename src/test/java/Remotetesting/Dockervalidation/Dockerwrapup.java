package Remotetesting.Dockervalidation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;


public class Dockerwrapup {

	
	
	public void stop() throws IOException, InterruptedException {
		//To run the bat file in windows
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("cmd /c start docker-down.bat");

		//Using calendar class to have 30 sec timedelay
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.SECOND, 45);
		long stopnow = calendar.getTimeInMillis();
		
			String fileString = "output.txt";
			boolean flags = false;
			Thread.sleep(3000);
			
			while (System.currentTimeMillis()<stopnow)
			{
				if(flags==true)
				{
				break;	
				}
				BufferedReader reader = new BufferedReader(new FileReader(fileString));
				String currentline = reader.readLine();
				
			while (currentline != null && !flags) {

				if (currentline.contains("selenium-hub exited")) 
				{
					flags = true;
					System.out.println("Docker is down");
					break;
				}
				currentline=reader.readLine();
			}
			
			reader.close();
			}
			Assert.assertTrue(flags);
			Thread.sleep(3000);
			File file = new File(fileString);
			if(file.exists()) {
				file.delete();
				System.out.println("File deleted successfully on end");
			}
		
	}

}
