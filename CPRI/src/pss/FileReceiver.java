package pss;

import java.net.*;
import java.io.*;

public class FileReceiver implements Runnable 
{
	private int  portNumber;
	private ServerSocket serverSock = null;	
	
	public FileReceiver(int portNumber)
	{
		this.portNumber = portNumber;
	}	
	
	public void startServer() throws IOException
	{	
		serverSock = new ServerSocket(portNumber);
		System.out.println("running");
		while(true)
		{
			Socket socket = serverSock.accept();				
				
			Thread t = new Thread(new ClientHandler(socket));			
			t.start();
			System.out.println("got a connection");
		    
		}
	}
	
	public class ClientHandler implements Runnable 
	{		
		Socket socket;
		ObjectInputStream inStream;
		String fileName;
		
		public ClientHandler(Socket clientSocket)
		{
			try
			{
				socket = clientSocket;
				inStream = new ObjectInputStream(socket.getInputStream());
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
		@Override
		public void run(){
			try 
			{
				fileName = (String) inStream.readObject();	
				System.out.println(fileName);
				FileOutputStream outStream = new FileOutputStream(fileName);
			    byte[] buffer = new byte[200000];
	            int bytesRead = 0, counter = 0;
	 
	            while (bytesRead >= 0) 
	            {
	                bytesRead = inStream.read(buffer);
	                if (bytesRead >= 0) 
	                {
	                    outStream.write(buffer, 0, bytesRead);
	                    counter += bytesRead;
	                    System.out.println("total bytes read: " + counter);
	                }
	                if (bytesRead < 1024) 
	                {
	                    outStream.flush();
	                    break;
	                }
	            }
			
		        System.out.println("Download Successfully!");
	            outStream.close(); 
	            inStream.close();
			} 
			catch (Exception e) 
			{				
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		try
		{
			startServer();
		}
		catch(IOException e)
		{
			e.printStackTrace(); 			
		}
	}
	
}