package WorkingWithMap;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, UserMap> users = new HashMap<>();
        System.out.println(users.isEmpty());
        users.put("user1@gmail.com", new UserMap("user1", 10));
        users.put("user2@gmail.com", new UserMap("user2", 20));
        users.put("user3@gmail.com", new UserMap("user3", 30));

        System.out.println(users); // imprime o mapa completo
        System.out.println("===============================");
        users.keySet().forEach(System.out::println); // imprime todas as chaves
        System.out.println("===============================");
        users.values().forEach(System.out::println); // imprime todos os valores

        System.out.println(users.containsKey("user4@gmail.com")); // nao encontrou, pois a chave nao existe
        System.out.println(users.containsValue(new UserMap("user4", 10))); // nao encontrou, pois o valor nao existe
        System.out.println(users.containsKey("user3@gmail.com")); // encontrou, pois a chave existe
        System.out.println(users.containsValue(new UserMap("user3", 30))); // encontrou, pois o valor existe

        System.out.println(users.remove("user1@gmail.com", new UserMap("user1", 10))); // removeu, pois a chave e o valor existem

        users.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println("===============================");
        users.replace("user2@gmail.com", new UserMap("user2", 60)); // substituiu o valor, pois a chave existe
        users.forEach((key, value) -> System.out.println(key + ": " + value));


        System.out.println(users.get("user2@gmail.com")); // retorna o valor associado a chave
        System.out.println(users.get("user@gmail.com       ")); // retorna null, pois a chave nao existe

        System.out.println(users.isEmpty());

        users.merge("user3@gmail.com", new UserMap("", -1), (user, user2) -> {
            System.out.println(user);
            System.out.println(user2);
            return user2;
        }); // substitui o valor de uma forma mais inteligente

        System.out.println(users);

        users.putIfAbsent("", new UserMap("", -1));
        System.out.println(users);

    }
}
