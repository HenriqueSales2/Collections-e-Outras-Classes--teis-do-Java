package APIStreamsAndGenerics.ex2;

import APIStreamsAndGenerics.ex2.domain.Contact;
import APIStreamsAndGenerics.ex2.domain.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalLong;
import java.util.stream.Collectors;

import static APIStreamsAndGenerics.ex2.domain.ContactType.EMAIL; // FAZENDO UMA IMPORTAÇÃO ESTÁTICA
import static APIStreamsAndGenerics.ex2.domain.ContactType.PHONE; // FAZENDO UMA IMPORTAÇÃO ESTÁTICA
import static APIStreamsAndGenerics.ex2.domain.Sex.MALE;
import static APIStreamsAndGenerics.ex2.domain.Sex.FEMALE;

public class Main {

    public static void main(String[] args) {

        List<User> users = new ArrayList<>(generateUsers());

//users.sort((u1, u2) -> u1.name().compareTo(u2.name())); // da pra ordenar atraves desse método
        users.sort(Comparator.comparing(User::age)); // tem essa outra forma também, que aparentemente é mais fácil
        users.sort(Comparator.comparing(User::age, Comparator.reverseOrder())); // outro exemplo aqui revertendo a ordem das idades

        var values = users.stream() // comentar essa linha caso queira colocar null no ultimo contato para testar a variavel de valuesNull
                        .filter(u -> u.contacts().size() >= 2) // comentar essa linha caso queira colocar null no ultimo contato para testar a variavel de valuesNull
                                .toList(); // comentar essa linha caso queira colocar null no ultimo contato para testar a variavel de valuesNull

        var valuesNull = users.stream()
                .filter(u -> u.contacts() == null || u.contacts().isEmpty());


        // usando o anymatch e o allMatch para pegar a lista de email dentro da lista de contatos

        var valuesEmail = users.stream()
                .filter(u -> u.contacts()
                        .stream()
                        .anyMatch(c -> c.type() == EMAIL)); // aqui ele vai puxar alguma correspondencia com email mesmo que tenha o telefone (phone) junto

        var valuesPhone = users.stream()
                .filter(u -> u.contacts()
                        .stream()
                        .allMatch(c -> c.type() == PHONE)); // aqui ele vai puxar só os telefones (phone) sem puxar o email junto

        // ou usar o noneMatch, que ai ele não aparece nenhuma correspondencia do objeto que você atribuir

        var valuesFlatMap = users.stream() // perdão pelo valuesFlatMap, fiquei sem ideia para nomes ;-;
                .flatMap(u -> u.contacts().stream())
                        .filter(c -> c.type() == EMAIL) // filtrando só os emails
//                                .sorted((c1, c2) -> c1.description().compareTo(c2.description())) temos duas formas de fazer, porem vou fazer a segunda, pois é mais simples
                                .sorted(Comparator.comparing(Contact::description)) // ordenando por ordem alfabética
                                        .toList();

        var valuesFlatMapReplace = users.stream()
                .flatMap(u -> u.contacts().stream())
                        .filter(c -> c.type() == PHONE) // bom, nesse aqui eu fiz um replace nos telefones dos contatos
                                .map(c -> c.description().replace("(", "") // ou seja tirei os parenteses em volta no DDD
                                        .replace(")", "")
                                        .replace("-", "") // e o traço( - ) no meio do numero de telefone
                                        .replace(" ", "")); // tirei até o espaço

        var valuesFilterFemale = users.stream()
                .filter(u -> u.sex() == FEMALE)
                        .collect(Collectors.toMap(User::name, u -> u)); // agora filtrei os contatos só pelos femininos







        //users.forEach(System.out::println);
        //values.forEach(System.out::println);
        //System.out.println("=====================");
        //valuesNull.forEach(System.out::println);
        valuesEmail.forEach(System.out::println);
        System.out.println("=====================");
        valuesPhone.forEach(System.out::println);
        System.out.println("=====================");
        valuesFlatMap.forEach(System.out::println);
        System.out.println("=====================");
        valuesFlatMapReplace.forEach(System.out::println);
        System.out.println("=====================");
        valuesFilterFemale.forEach((key, value) -> System.out.printf("key: %s | value: %s \n", key, value));

    }

    private static List<User> generateUsers() {


        var contacts1 = List.of(
                new Contact("(11) 99999-9999", PHONE),
                new Contact("henrique@gmail.com", EMAIL)
        );

        var contacts2 = List.of(
                new Contact("(12) 99999-9999", PHONE)
//                new Contact("ana@gmail.com", EMAIL)
        );

        var contacts3 = List.of(
//                new Contact("(13) 99999-9999", PHONE)
                new Contact("thiago@gmail.com", EMAIL)
        );

        var contacts4 = List.of(
                new Contact("helena@outlook.com", EMAIL),
                new Contact("helena@gmail.com", EMAIL)
        );

        var contacts5 = List.of(
                new Contact("(15) 99999-9999", PHONE),
                new Contact("(16) 99999-9999", PHONE)
        );


        var user1 = new User("Henrique", 18, MALE, new ArrayList<>(contacts1));
        var user2 = new User("Ana Luíza", 23, FEMALE, new ArrayList<>(contacts2));
        var user3 = new User("Thiago", 32, MALE, new ArrayList<>(contacts3));
        var user4 = new User("Helena", 19, FEMALE, new ArrayList<>(contacts4));
        var user5 = new User("Matheus", 48, MALE, new ArrayList<>(contacts5));
        var user6 = new User("Vitória", 30, FEMALE, new ArrayList<>()); // observação: se quiser colocar null no ultimo contato precisa comentar a linha 26 a 28

        return List.of(user1, user2, user3, user4, user5, user6);
    }

}
