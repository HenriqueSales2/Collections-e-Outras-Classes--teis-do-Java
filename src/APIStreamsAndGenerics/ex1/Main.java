package APIStreamsAndGenerics.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {

        //funcaoNumerosAleatorios(); // caso queira ver a função descomente ela

        //System.out.println("========================"); // divisória para separar os números aleatórios

        //funcaoNumerosAleatorios2(); // caso queira ver a função descomente ela

//        funcaoFiltrarNome("a");
//        funcaoFiltrarNome2("");
//            funcaoFiltrarNumero();
//            funcaoFiltrarNumeroParImpar();
        funcaoFiltrarNumeroComplexa();
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
        List<String> debugValues = new ArrayList<>();
        var value = Stream.of("Henrique", "Helena", "Gabriel", "Gabriela", "Daniel", "Daniela", "Giovanni", "Giovanna")
                .filter(name -> name.endsWith(letra))
                //.anyMatch(n -> n.contains("a")); // ver se a stream que criei tem alguma ocorrencia com a letra a
        // obs: se quiser ver o que esse anyMatch faz é só comentar as três linhas abaixo dessa e adicionar ponto e virgula ao final
        // exemplo : .anyMatch(n -> n.contains("a"));
                .peek(System.out::println)
                .toList();

        System.out.println(value);

    }

    private static void funcaoFiltrarNome2(String letra) {
        var value = Stream.of("Henrique", "Helena", "Gabriel", "Gabriela", "Daniel", "Daniela", "Giovanni", "Giovanna")
                .reduce("", (a, b) -> a + "\n" + b);

        System.out.println(value);

    }

    private static void funcaoFiltrarNumero() {
        var value = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 7, 8) // ele não adiciona o número repetido na lista
                        .distinct().toList();

        System.out.println(value);

    }

    private static void funcaoFiltrarNumeroParImpar() {
        var value = Stream.of(  1, 2, 3, 4, 5, 6, 7, 8) // essa função detecta e fala se o número é par ou impar através do TRUE(PAR) ou FALSE(IMPAR)
                .map(n -> n % 2 == 0)
                        .toList();

        System.out.println(value);

    }

    private static void funcaoFiltrarNumeroComplexa() {
        List<Integer> values1 = List.of(3, 6, 9, 12);
        List<Integer> values2 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        var newValues = values2.stream()
                .parallel() // podemos usar o parallel para não ficar muito bagunçado na hora de ver o passo a passo com o printf
                .filter(values1::contains)
                .peek(n -> System.out.printf("Filter: %s\n", n)) // usando o peek e dando um printf conseguimos ver passo a passo do que o código está rodando
                .map(n -> values1.stream().reduce(n, (n1, n2) -> n1 - n2))
                .peek(n -> System.out.printf("Map: %s\n", n))
                .collect(Collectors.toSet());
        System.out.println(newValues);
    }
}
