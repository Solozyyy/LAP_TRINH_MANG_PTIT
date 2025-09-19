package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class At77Wdbh {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("203.162.10.109", 2207);
        String req = "B22DCDT172;At77Wdbh";
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF(req);
        DataInputStream dis = new DataInputStream(client.getInputStream());
        int a = dis.readInt();
        int b = dis.readInt();
        System.out.println(a + " " + b);
        dos.writeInt((int) (a + b));
        dos.writeInt((int) (a * b));
        dos.close();
        dis.close();
        client.close();
    }
}
