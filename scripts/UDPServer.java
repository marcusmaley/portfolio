
/**
	Java server with UDP socket to accept client's request to change its message to
	all upper case characters
	
	C:\....> javac UDPServer.java
	C:\....> java UDPServer
*/

import java.io.*;
import java.net.*;

public class UDPServer {
	public static void main(String args[]) {
		DatagramSocket serverSocket = null;

		try {
			// 1. creating a server socket, parameter is local port number 12009
			serverSocket = new DatagramSocket(12000);

			// buffer to receive incoming data
			byte[] buffer = new byte[65536];
			DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);

			// 2. Wait for an incoming data
			System.out.println("\nThe server is ready to receive......");

			// communication loop
			while (true) {
				serverSocket.receive(incoming);
				byte[] data = incoming.getData();
				String sentence = new String(data, 0, incoming.getLength());
				DatagramPacket dp = new DatagramPacket(sentence.toUpperCase().getBytes(),
						sentence.toUpperCase().getBytes().length,
						incoming.getAddress(), incoming.getPort());
				serverSocket.send(dp);
			}
		}

		catch (IOException e) {
			System.err.println("IOException " + e);
		}
	}
}
