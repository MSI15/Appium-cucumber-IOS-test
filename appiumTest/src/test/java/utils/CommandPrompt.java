package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandPrompt {
	
	Process p;
	ProcessBuilder builder;
	
	public String runCommand(String command) throws InterruptedException, IOException
	{
		p = Runtime.getRuntime().exec(command);
		
		BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		
		String line="";
		String allLine="";
		while((line=r.readLine()) != null){
			System.out.println(line);
			allLine=allLine+""+line+"\n";
			if(line.contains("started on")||line.contains("emulator: ")) // Console LogLevel
			break;
		}
		return allLine;
	}
	
	
	public void stopServer() throws IOException {
	    if (p != null) {
	        p.destroy();
	    }
	    System.out.println("Stopped!");
	}
}

