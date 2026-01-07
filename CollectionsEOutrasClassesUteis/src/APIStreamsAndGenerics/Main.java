package APIStreamsAndGenerics;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {

        //funcaoNumerosAleatorios(); // caso queira ver a função descomente ela

        System.out.println("========================"); // divisória para separar os números aleatórios

        //funcaoNumerosAleatorios2(); // caso queira ver a função descomente ela

        funcaoFiltrarNome("a");

    }

    private static void funcaoNumerosAleatorios() {

        //        var test = new Integer[1]; // declarar a instancia aqui

        var value1 = Stream.generate(() -> new Random().nextInt())
                .limit(5)
                .toArray(Integer[]::new); // é a mesma coisa que aqui,só que usando Stream

        for (var v : value1) {
            System.out.println(v);

        }
    }

    private static void funcaoNumerosAleatorios2() { // só que de outra forma (coloquei o nome grande para até quem não sabe programar consiga entender)
        var value2 = IntStream.generate(() -> new Random().nextInt())
                .limit(5)
                .toArray();

        for(var v : value2) {
            System.out.println(v);

        }
    }

    private static void funcaoFiltrarNome(String letra) {
        var value = Stream.of("Henrique", "Helena", "Gabriel", "Gabriela", "Daniel", "Daniela", "Giovanni", "Giovanna")
                .filter(name -> name.endsWith(letra))
                .peek(System.out::println)
                .toList();

        System.out.println(value);
    }
}
