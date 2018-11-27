package Client;

import Shared.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConsumerClient
{
	private static final int PORT = 2910;

	public static void main(String[] args)
	{
		try
		{
			accessServer();
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

	private static void accessServer() throws IOException, ClassNotFoundException
	{
		Socket socket = new Socket("localhost", PORT);

		ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

		while (true)
		{
			Request giveNumberArr = new Request();
			giveNumberArr.type = Request.TYPE.GIVE_NUMARR;
			outToServer.writeObject(giveNumberArr);

			Request receivedRequestFromServer = ((Request) inFromServer.readObject());

			switch (receivedRequestFromServer.type)
			{
				case CALCULATE_NUM:
					int[] tempArr = receivedRequestFromServer.numArr;
					System.out.println("Consumer received 3 numbers: " + tempArr[0] + ", " + tempArr[1] + ", " + tempArr[2]);

					// creating request for server
					Request printNumRequest = new Request();
					printNumRequest.type = Request.TYPE.PRINT_NUM;
					printNumRequest.number = (tempArr[0] + tempArr[1]) * tempArr[2];

					// sending request to the server
					outToServer.writeObject(printNumRequest);
					break;
			}
		}
	}
}

