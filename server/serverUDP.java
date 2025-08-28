package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class serverUDP {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket server = new DatagramSocket(2207);
        System.out.println("Server started");
        while (true) {
            // receive packet
            byte[] buff = new byte[1024];
            DatagramPacket dpRequest = new DatagramPacket(buff, 0, buff.length);
            server.receive(dpRequest);
            // extract data
            String strReq = new String(dpRequest.getData());
            // process data
            String strRes = new StringBuilder(strReq).reverse().toString();
            byte[] buffRes = strRes.getBytes();
            // send response packet
            DatagramPacket dpResponse = new DatagramPacket(buffRes, buffRes.length,
                    dpRequest.getAddress(),
                    dpRequest.getPort());
            server.send(dpResponse);
            System.out.println("Request: " + strReq + " - Response: " + strRes);

        }
    }

}
