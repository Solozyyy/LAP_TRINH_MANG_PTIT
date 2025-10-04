package client.UDP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Object {
    public static void main(String[] args) throws Exception {
        DatagramSocket client = new DatagramSocket();
        byte[] req = ";B22DCDT172;gRCdN50j".getBytes();
        DatagramPacket dp1 = new DatagramPacket(req, req.length, InetAddress.getByName("203.162.10.109"), 2209);
        client.send(dp1);

        byte[] ans = new byte[4096];
        DatagramPacket dp2 = new DatagramPacket(ans, ans.length);
        client.receive(dp2);

        String id = new String(dp2.getData(), 0, 8);
        byte[] byteObj = new byte[dp2.getLength() - 8];

        System.arraycopy(dp2.getData(), id.length(), byteObj, 0, dp2.getLength() - 8);

        ByteArrayInputStream bis = new ByteArrayInputStream(byteObj);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Employee e = (Employee) ois.readObject();
        System.out.println(e);

        e.name = e.chName(e.name);
        e.hireDate = e.chYear(e.hireDate);
        e.salary = e.chSalary(e.salary, e.hireDate);
        System.out.println(e);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(e);

        byte[] idByte = id.getBytes();
        byte[] eByte = bos.toByteArray();
        byte[] sendData = new byte[idByte.length + eByte.length];
        System.arraycopy(idByte, 0, sendData, 0, idByte.length);
        System.arraycopy(eByte, 0, sendData, idByte.length, eByte.length);

        DatagramPacket dp3 = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("203.162.10.109"),
                2209);
        client.send(dp3);
        client.close();

    }
}
