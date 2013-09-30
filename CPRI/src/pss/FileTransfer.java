package pss;

import java.io.*;
import java.net.Socket;

public class FileTransfer implements Runnable {
	private String fileName;
	private String serverName;
	private int  portNumber;
		
	
	public FileTransfer(String fileName, String ipAddress, int portNumber)
	{
		this.fileName = fileName;
		this.serverName = ipAddress;
		this.portNumber = portNumber;
	}
	
	public void sendFile()
	{
		try
		{
			System.out.println("Connecting to " + serverName + " on port " + portNumber);
			Socket sock = new Socket(serverName, portNumber);
			System.out.println("Just connected to " + sock.getRemoteSocketAddress());
			
			ObjectOutputStream outStream = new ObjectOutputStream(sock.getOutputStream());;
			
			
			File myFile = new File(fileName);
			long completed = 0;
			int step = 150000;
	 
	        // creates the file stream
	        FileInputStream fileStream = new FileInputStream(myFile);
	 
	        // sending a file name before streaming the file
	        outStream.writeObject(fileName);
	 
	        byte[] buffer = new byte[step];
	        
	        while (completed <= myFile.length()) {
	            fileStream.read(buffer);
	            outStream.write(buffer);
	            completed += step;
	        }	        
       
        	fileStream.close();
			sock.close();
		}
		catch(IOException e)
		{
			e.printStackTrace(); 
		}
		
	}

	@Override
	public void run() {
		sendFile();
	}

}
