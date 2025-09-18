package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TCP_DataStream {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("203.162.10.109", 2207);
        String strRequest = "B22DCDT172;At77Wdbh";
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF(strRequest);
        DataInputStream dis = new DataInputStream(client.getInputStream());
        int a = dis.readInt();
        int b = dis.readInt();
        System.out.println("a + b = " + (a + b));

        dos.writeInt((int) (a + b));
        dos.writeInt((int) (a * b));
        dis.close();
        dos.close();
        client.close();
    }
}
