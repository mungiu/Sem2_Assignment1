package Client;

import Shared.Request;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

import static java.lang.Thread.sleep;


public class ProducerClient
{
	private static final int PORT = 2910;

	public static void main(String[] args)
	{
		try
		{
			accessServer();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	private static void accessServer() throws IOException, InterruptedException, ClassNotFoundException
	{
		Random random;
//		socket = new Socket("10.152.194.45", 2910);
		Socket socket = new Socket("localhost", 2910);
		ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());

		while (true)
		{
			// creating request for server
			Request addNumRequest = new Request();
			random = new Random();
			addNumRequest.type = Request.TYPE.ADD_NUM;
			addNumRequest.number = random.nextInt(100);

			// sending request to server
			outToServer.writeObject(addNumRequest);


			System.out.println("Producer: Number sent to server");
			sleep(1000);
		}


	}
}

