package client.DSA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WSNguyenAm {
    public static List<String> solve(List<String> arr) {
        TreeMap<Integer, List<String>> map = new TreeMap<>();
        for (String x : arr) {
            String tmp = x;
            x = x.toLowerCase();
            int cnt = 0;
            for (char y : x.toCharArray()) {
                if (y == 'u' || y == 'e' || y == 'o' || y == 'a' || y == 'i') {
                    cnt++;
                }
            }
            if (!map.containsKey(cnt)) {
                map.put(cnt, new ArrayList<String>());
                map.get(cnt).add(tmp);
            } else {
                map.get(cnt).add(tmp);
            }
        }
        for (Map.Entry<Integer, List<String>> m : map.entrySet()) {
            Collections.sort(m.getValue());

        }
        List<String> ls = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> m : map.entrySet()) {
            System.out.print(m.getKey() + ": ");
            String res = "";
            for (String x : m.getValue()) {
                System.out.print(x + " ");
                res += x + ", ";
            }
            ls.add(res.substring(0, res.length() - 2));
            System.out.println("");
        }
        System.out.println("...");
        return ls;
    }

    public static void main(String[] args) {
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();

        List<String> arr = port.requestStringArray("B22DCVT525", "1NvRsSYe");
        for (String x : arr) {
            System.out.println(x);
        }

        port.submitCharacterStringArray("B22DCVT525", "1NvRsSYe", solve(arr));
    }
}
