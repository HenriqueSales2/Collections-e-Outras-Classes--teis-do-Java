package WorkingWithSet;

import java.util.Objects;

import static java.util.Objects.hash;
import static java.util.Objects.isNull;

public class Users implements Comparable<Users> {

    private int id;
    private String name;

    public Users(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Users(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Users[id=%d, name='%s']", id, name);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if ((isNull((o))) || (!(o instanceof Users user))) return false;
        return this.id == user.getId() && Objects.equals(this.name, user.getName());

    }

    @Override
    public int hashCode() {
        return hash(this.id, this.name);
    }

    @Override
    public int compareTo(Users users) {
        int compareResult = 0;
        if (this.id < users.getId()) compareResult = -1;
        if (this.id > users.getId()) compareResult = 1;
        return compareResult;
    }
}
