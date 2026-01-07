package WorkingWithSet;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Set<Users> users = new HashSet<Users>(); // cria uma lista de usuarios que imprime de forma desordenada

        users.add(new Users(1, "John Doe"));
        users.add(new Users(2, "Jane Smith"));
        users.add(new Users(3, "Alice Johnson"));
        users.add(new Users(4, "Bob Brown"));

        System.out.println("Imprimindo a lista de usuarios HashSet: " + users);

        Set<Users> users1 = new LinkedHashSet<Users>(); // cria uma lista de usuarios que imprime na ordem que foram adicionados
        users1.add(new Users(4, "Ana"));
        users1.add(new Users(1, "Joao"));
        users1.add(new Users(3, "Pedro"));
        users1.add(new Users(2, "Maria"));

        System.out.println("Imprimindo a lista de usuarios LinkedHashSet: " + users1);


        Set<Users> users2 = new TreeSet<Users>(); // cria uma lista de usuarios que imprime em ordem crescente baseado no id

        users2.add(new Users(1, "Henrique"));
        users2.add(new Users(4, "Carla"));
        users2.add(new Users(3, "Juliana"));
        users2.add(new Users(2, "Rafael"));
        System.out.println("Imprimindo a lista de usuarios TreeSet: " + users2);

        System.out.println(new Users(12, "John Doe").hashCode());
        System.out.println(new Users(21, "Doe John").hashCode());



        users.removeAll(List.of(new Users(1, "John Doe") , new Users(2, "Smith Jane"))); // remove usuarios com id 1 e 2
        users.removeIf(u -> u.getName().equals("Alice Johnson")); // remove usuarios com nome "Alice Johnson"
        users.removeIf(Predicate.not(u -> u.getId() > 4)); // remove usuarios com id menor ou igual a 4

        users.forEach(System.out::println); // imprime todos os usuarios restantes
    }
}
