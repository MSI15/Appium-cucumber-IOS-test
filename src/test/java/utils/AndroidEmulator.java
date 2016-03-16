package utils;

import java.io.IOException;

public class AndroidEmulator {
	
	CommandPrompt cp = new CommandPrompt();
	String launchEmulator;
	
	
	public void startDefaultEmulator()throws Exception
	{
		String availableEmulators = cp.runCommand("emulator -list-avds");
		String[] lines = availableEmulators.split("\n");
		System.out.println(lines.length + " Emulators available");
		
		String defaultEmulator = "Nexus9";
		launchEmulator = "emulator -avd "+defaultEmulator;
		System.out.println("\n launching emulator using : " + launchEmulator);
		cp.runCommand(launchEmulator);
			
		if(lines.length<=1){
			System.out.println("No Emulator available");
			createEmulator();
		}
	}
	
	public void createEmulator()
	{
		
	}

	public void startEmulator(String emulatorName) throws InterruptedException, IOException
	{
		launchEmulator = "emulator -avd "+emulatorName;
		System.out.println("\n launching emulator using : " + launchEmulator);
		cp.runCommand(launchEmulator);
	}
}
