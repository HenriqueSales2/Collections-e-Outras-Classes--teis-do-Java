package APIStreamsAndGenerics.Generics.domain;

import java.util.Objects;

public class UserDomain implements GenericDomain<Integer> {

    private Integer id;

    private String name;

    private int age;


    public UserDomain() {
    }

    public UserDomain(Integer id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserDomain that = (UserDomain) o;
        return age == that.age && Objects.equals(name, that.name) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, id);
    }

    @Override
    public String toString() {
        return  "id: " + id + "\n" + "name: " + name + "\n" + "age: " + age + "\n";
    }
}
