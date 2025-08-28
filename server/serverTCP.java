package server;

import java.net.*;
import java.io.*;

public class serverTCP {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(2207);
        System.out.println("Server started");
        while (true) {
            Socket conn = server.accept();
            DataInputStream dis = new DataInputStream(conn.getInputStream());
            int a = dis.readInt();
            int b = dis.readInt();

            int sum = a + b;
            System.out.println("sum: " + sum);
            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
            dos.writeInt(sum);
            dis.close();
            dos.close();
        }
    }
}