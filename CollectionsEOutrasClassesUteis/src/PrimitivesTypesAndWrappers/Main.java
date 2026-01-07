package PrimitivesTypesAndWrappers;

public class Main {
    public static void main(String[] args) {
        var user = new UserWrappers("Joao", 20);
        System.out.println(user); // antes de chamar o método printValue
        printValue(user); // depois de chamar o método printValue
        // O objeto user foi modificado dentro do método printValue
        System.out.println(user);

    }

    private static void printValue(final UserWrappers user) { // declarar final para nao perder a referencia do objeto
        user.setAge(30);
        user.setName("Maria");
        System.out.println(user);
    }
}
