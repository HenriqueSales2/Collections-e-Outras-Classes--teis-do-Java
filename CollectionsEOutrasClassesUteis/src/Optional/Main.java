package Optional;

import ListAndArrays.User;
import Optional.domain.SexEnum;
import Optional.domain.UserOptional;
import Optional.domain.UserOptionalV2;

import java.util.Optional;

import static Optional.domain.SexEnum.FEMALE;
import static Optional.domain.SexEnum.MALE;

public class Main {

    public static void main(String[] args) {
        Optional<UserOptional> optional = Optional.of(new UserOptional("Joao", 20, MALE));

        // primeiro exemplo

        optional.ifPresent(System.out::println);

        final int newAge = 23;

        optional.ifPresentOrElse(
                user -> {
                    System.out.printf("Usuário: %s \n", user);
                    user = new UserOptional("João", newAge, MALE);
                    System.out.printf("Usuário com nova idade: %s \n", user);
                },
                () -> System.out.println("Usuário não encontrado")
        );


        // segundo exemplo

        Optional<UserOptional> emptyOptional = Optional.empty();

        System.out.println(emptyOptional.orElse(new UserOptional("Maria", 22, FEMALE))); // se o optional estiver vazio, retorna o usuário padrão

        // terceiro exemplo

        Optional<UserOptional> optionalUser = Optional.ofNullable(null); // pode ser null
        System.out.println(optionalUser.orElse(defaultUser())); // chamou o método defaultUser para retornar um usuário padrão
        System.out.println(optionalUser.orElseGet(Main::defaultUser)); // chamou o método defaultUser para retornar um usuário padrão, mas só chama se o optional estiver vazio


        // fazer o mapeamento dos valores sem se preocupar se o optional está vazio ou não

        var newUser = optional.map(Main::toV2Domain); // mapeia o usuário para outro tipo, se o optional estiver vazio, lança uma exceção, usando lambda
        System.out.println(newUser.orElseThrow());
    }

    private static UserOptionalV2 toV2Domain(UserOptional userOptional) {
        return new UserOptionalV2(userOptional.name(), userOptional.age(), userOptional.sex());
    }

    public static UserOptional defaultUser(){
        return new UserOptional("Helena", 18, FEMALE);
    }

}
