package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class xgnl5g5a {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket client = new Socket("203.162.10.109", 2209);
        String req = "B22DCDT172;xgnl5g5a";
        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        oos.writeObject(req);
        oos.flush();

        Product t = (Product) ois.readObject();
        t.discount = Product.solve(t.price);

        System.out.println(t);
        oos.writeObject(t);
        ois.close();
        oos.close();
        client.close();
    }
}
