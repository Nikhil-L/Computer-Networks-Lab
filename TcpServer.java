
import java.net.*;
import java.io.*;

public class TcpServer
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket se = new ServerSocket(1537);
			System.out.println("Connection waiting");
			Socket server = se.accept();
			System.out.println("Connection established");

			BufferedReader k = new BufferedReader(new InputStreamReader(server.getInputStream()));
			String filename = k.readLine();

			FileReader f = null;
			BufferedReader ff = null;

			DataOutputStream sendToclient = new DataOutputStream(server.getOutputStream());

			File file = new File(filename);

			System.out.println(file);
			if(file.exists())
			{
				sendToclient.writeBytes("Yes");
				f = new FileReader(filename);
				ff = new BufferedReader(f);
				String string;
				while((string = ff.readLine())!= null)
				{
					sendToclient.writeBytes(string + "\n");
				}
			}
			else
			{
				sendToclient.writeBytes("No\n");
			}

			server.close();
			f.close();
			ff.close();
			k.close();
			sendToclient.close();
			se.close();
		}
		catch(Exception e)
		{

		}
	}
}