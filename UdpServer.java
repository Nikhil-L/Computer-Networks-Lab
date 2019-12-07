
import java.net.*;
import java.util.*;

public class UdpServer
{
	public static void main(String [] args)
	{
		try
		{
			DatagramSocket server = new DatagramSocket(1537);

			System.out.println("Enter the server message ");

			Scanner ip = new Scanner(System.in);
			
			int count = 10;
			while(count > 0)
			{
				byte[] buffer = new byte[1000];
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				server.receive(request);

				String msg = ip.nextLine();
				byte[] sendMessage = msg.getBytes();
				DatagramPacket reply = new DatagramPacket(sendMessage, sendMessage.length, request.getAddress(), request.getPort());
				server.send(reply);


			}

			server.close();
			ip.close();
		}
		catch(Exception e)
		{

		}
	}
}