package ClassString;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        var value = "Hel;lo;Wor;ld";
        var values = value.split("");
        for (var v : value.split(";", 2 )) {
            System.out.println(v);
        }
        System.out.println(value.toUpperCase());
        System.out.println(value.toLowerCase());
        System.out.println(value.contains("lo"));
        System.out.println(value.indexOf("W", 10)); // procura a partir do indice 5
        System.out.println(value.startsWith("H")); // verifica se começa com a letra h

        var vazio = "  ";
        System.out.println(vazio.isBlank()); // verifica se é vazio ou só tem espaços em branco
        System.out.println(vazio.isEmpty()); // verifica se é vazio


        var value2 = """
                {"name":"Joao","age":20}
                """;

        Map<String, String> map = new HashMap<>();
        while(map.size() < 2) {
            var startkeyIndex = value2.indexOf("\"");
            var endKeyIndex = value2.indexOf("\"", startkeyIndex);
            var keyvalue = value2.substring(startkeyIndex + 1, endKeyIndex);

            var startValueIndex = value2.indexOf(":\"");
            var endValueIndex = value2.indexOf("\"", startValueIndex + 2);
        }
    }
}
