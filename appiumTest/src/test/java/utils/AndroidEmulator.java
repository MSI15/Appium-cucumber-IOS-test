package utils;

import java.io.IOException;

public class AndroidEmulator {
	
	CommandPrompt cp = new CommandPrompt();
	String launchEmulator;
	String[] lines;
	String availableEmulators;
	String[] emulatorList;
	
	public void startDefaultEmulator()throws Exception
	{
		String availableEmulators = cp.runCommand("emulator -list-avds");
		lines = availableEmulators.split("\n");
		System.out.println(lines.length + " Emulators available");
		
		if(lines.length==0)
		{
			System.out.println("No Emulators available. Creating new emulator");
			createEmulator();
			launchEmulator = "emulator -avd testEmulator";
			
		}
		else
		{
			String defaultEmulator = "Nexus9";
			launchEmulator = "emulator -avd "+defaultEmulator;
			System.out.println("\n launching emulator using : " + launchEmulator);
		}
		
		cp.runCommand(launchEmulator);
	}
	
	public void createEmulator() throws InterruptedException, IOException
	{ 
		String output = cp.runCommand("android create avd -n testEmulator -t 8 --abi default/x86_64 --skin WVGA800 -f");
		lines = output.split("\n");
		for(int i=1;i<lines.length;i++)
		{
			lines[i]=lines[i].replaceAll("\\s+", "");
			if(lines[i].contains("Do you wish to create a custom hardware profile [no]")){
				cp.runCommand("no");
			}
		}
		
		availableEmulators = cp.runCommand("emulator -list-avds");
		emulatorList = availableEmulators.split("\n");
		for(int i=1;i<emulatorList.length;i++)
		{
			lines[i]=lines[i].replaceAll("\\s+", "");
			if(lines[i].contains("testEmulator")){
				System.out.println("\n test emulator created");
			}
		}
	}
	
	public void startEmulator(String emulatorName) throws InterruptedException, IOException
	{
		launchEmulator = "emulator -avd "+emulatorName;
		System.out.println("\n launching emulator using : " + launchEmulator);
		cp.runCommand(launchEmulator);
	}
}
