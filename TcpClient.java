

import java.net.*;
import java.io.*;

public class TcpClient
{
	public static void main(String []args)
	{
		try
		{
			Socket client = new Socket("localhost", 1537);
			BufferedReader k = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Enter the file location ");
			String filename = k.readLine();
			DataOutputStream sendToserver = new DataOutputStream(client.getOutputStream());
			sendToserver.writeBytes(filename + "\n");

			BufferedReader i = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String string = i.readLine();
			if(string.equals("Yes"))
			{
				while((string = i.readLine()) != null)
					System.out.println(string);
			}
			else
			{
				System.out.println("File not found");
			}
			k.close();
			i.close();
			client.close();
			sendToserver.close();
		}
		catch(Exception e)
		{

		}
	}
}