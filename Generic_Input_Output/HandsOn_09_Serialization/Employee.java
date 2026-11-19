import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    String name;
    int age;
    String department;
    transient String password;   // transient: TIDAK ikut diserialisasi

    Employee(String name, int age, String department, String password) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{name=" + name + ", age=" + age
                + ", department=" + department + ", password=" + password + "}";
    }
}
