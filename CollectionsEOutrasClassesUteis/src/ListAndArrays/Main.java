package ListAndArrays;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        /*List <User> users = new ArrayList<>();

        var user = new User(1, "John Doe"); // criar usuários
        // criar usuários
        var user2 = new User(2, "Jane Smith"); // criar usuários
        var user3 = new User(3, "Jane Smith"); // criar usuários
        var user4 = new User(4, "Jane Smith"); // criar usuários
        users.add(user); // adicionar usuários à lista
        users.add(user2); // adicionar usuários à lista
        users.add(user3); // adicionar usuários à lista
        users.add(user4); // adicionar usuários à lista
        System.out.println(users.contains(user)); // verificar se a lista contém o usuário
        System.out.println(users.contains(new User(1, "John Doe"))); // verificar se a lista contém o usuário com código 1 e nome "John Doe"
        System.out.println(users.size()); // verificar o tamanho da lista
        System.out.println(users.isEmpty()); // verificar se a lista está vazia
        System.out.println(users.get(0)); // retornar o primeiro elemento
        System.out.println(users.get(users.size() - 1)); // retornar o ultimo elemento
        System.out.println(users.indexOf(user3)); // retornar o índice do usuário na lista
        System.out.println(users.lastIndexOf(user4)); // retornar o último índice do usuário na lista
        System.out.println((new User(1, "John Doe").equals(new User(1, "John Doe")))); // verificar se dois usuários são iguais
        System.out.println(users.remove(0)); // remover o usuário da lista
        System.out.println(users);
        users.clear(); // limpar a lista
        System.out.println(users);*/



        var arrayStart = OffsetDateTime.now();
        List<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < 100_000_000; i++) {
            arrayList.add(i);
        }

        System.out.println(Duration.between(arrayStart, OffsetDateTime.now()).toMillis());

        var vectorStart = OffsetDateTime.now();
        List<Integer> vector = new ArrayList<>();
        for(int i = 0; i < 100_000_000; i++) {
            vector.add(i);
        }

        System.out.println(Duration.between(vectorStart, OffsetDateTime.now() ).toMillis());
    }
}
