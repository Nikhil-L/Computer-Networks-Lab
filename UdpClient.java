
import java.net.*;
import java.util.*;

public class UdpClient
{
	public static void main(String [] args)
	{
		try
		{
			DatagramSocket client = new DatagramSocket();
			int serversocket = 1537;
			InetAddress host = InetAddress.getByName("127.0.0.1");

			String message = "TextMessage";
			byte []sendMessage = message.getBytes();
			DatagramPacket request = new DatagramPacket(sendMessage, sendMessage.length, host, serversocket);
			client.send(request);

			byte []buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			client.receive(reply);

			System.out.println(new String(reply.getData()));
			client.close();
		}
		catch(Exception e)
		{
			
		}
	}
}