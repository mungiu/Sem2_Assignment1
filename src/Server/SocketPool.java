package Server;

import java.net.Socket;
import java.util.ArrayList;

/**
 * There is no need to synchronize the methods in this class because they should only be accessed by one thread
 */
public class SocketPool
{
	ArrayList<Socket> socketPool;

	public SocketPool()
	{
		socketPool = new ArrayList<>();
	}

	public synchronized void addSocket(Socket socket)
	{
		socketPool.add(socket);
	}

	public synchronized ArrayList<Socket> getSocketPool()
	{
		return socketPool;
	}
}
