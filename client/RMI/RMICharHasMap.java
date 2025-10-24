package client.RMI;

import RMI.CharacterService;
import java.net.*;
import java.io.*;
import java.rmi.Naming;
import java.util.LinkedHashMap;
import java.util.Map;

public class RMICharHasMap {
    public static void main(String[] args) throws Exception {
        CharacterService service = (CharacterService) Naming.lookup("rmi://203.162.10.109/RMICharacterService");
        String s = service.requestCharacter("B22DCDT172", "ySSWFzjh");
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (char x : s.toCharArray()) {
            if (!map.containsKey(x)) {
                map.put(x, 1);
            } else {
                map.put(x, map.get(x) + 1);
            }
        }
        String res = "{";
        for (Map.Entry<Character, Integer> x : map.entrySet()) {
            res += "\"" + x.getKey() + "\"" + ": " + x.getValue() + ", ";
        }
        StringBuilder sb = new StringBuilder(res);
        sb.deleteCharAt(res.length() - 1);
        sb.deleteCharAt(res.length() - 2);
        sb.insert(sb.length(), "}");
        service.submitCharacter("B22DCDT172", "ySSWFzjh", sb.toString());
    }
}
