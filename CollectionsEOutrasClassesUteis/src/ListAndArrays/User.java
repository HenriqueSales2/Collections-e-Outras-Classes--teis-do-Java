package ListAndArrays;

import java.util.Objects;

public class User {

    private int code;

    private String name;

    public User(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public User() {
        // Default constructor
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // Compara se este objeto User é igual ao outro,
    // verificando se são a mesma instância ou se possuem o mesmo código e nome.
    @Override
    public boolean equals(final Object obj) {
        var isEqual = false;
        if(obj instanceof User user){
            if (this == user) isEqual = true;
            if (this.code == user.code && Objects.equals(this .name, user.name)) isEqual = true;
        }
        return isEqual;
    }

    // formata a representação do objeto User como uma string,
    // incluindo o código e o nome do usuário.
    @Override
    public String toString() {
        return String.format("User[code=%d, name=%s]", code, name);
    }
}
