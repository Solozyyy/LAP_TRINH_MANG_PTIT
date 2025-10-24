package client.WS;

import java.util.ArrayList;
import java.util.List;

public class DataService {
    public static void main(String[] args) {
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer> nums = port.getData("B22DCDT172", "JqlPVa07");
        List<String> data = new ArrayList<>();
        for (Integer x : nums) {
            data.add(Integer.toBinaryString(x));
        }

        port.submitDataStringArray("B22DCDT172", "JqlPVa07", data);
    }
}
