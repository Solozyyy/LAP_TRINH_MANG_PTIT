package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class wy18osEG {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket client = new Socket("203.162.10.109", 2209);
        String req = "B22DCDT172;wy18osEG";
        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());

        oos.writeObject(req);
        oos.flush();

        Address a = (Address) ois.readObject();

        a.addressLine = Address.chuanHoaString(a.addressLine);
        a.postalCode = Address.chuanHoaCode(a.postalCode);
        System.out.println(a);

        oos.writeObject(a);
        ois.close();
        oos.close();
        client.close();
    }
}
