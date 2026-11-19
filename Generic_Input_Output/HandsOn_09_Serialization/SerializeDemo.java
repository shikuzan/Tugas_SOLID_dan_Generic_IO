import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializeDemo {

    /** Menulis satu objek Employee ke file biner. */
    public static void serialize(Employee e, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(e);
            System.out.println("Serialized  : " + e.name + " -> " + fileName);
        } catch (IOException ex) {
            System.out.println("Error serialize: " + ex.getMessage());
        }
    }

    /** Membaca kembali satu objek Employee dari file biner. */
    public static Employee deserialize(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Employee) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error deserialize: " + ex.getMessage());
            return null;
        }
    }

    /** Menulis banyak objek sekaligus (List juga Serializable). */
    public static void serializeAll(List<Employee> list, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(new ArrayList<>(list));
            System.out.println("Serialized  : " + list.size() + " objek -> " + fileName);
        } catch (IOException ex) {
            System.out.println("Error serialize: " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Employee> deserializeAll(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error deserialize: " + ex.getMessage());
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("John", 30, "IT", "rahasia1");
        Employee e2 = new Employee("Sari", 27, "Finance", "rahasia2");
        Employee e3 = new Employee("Rudi", 41, "HRD", "rahasia3");

        System.out.println("=== Uji beberapa objek, masing-masing satu file ===");
        serialize(e1, "emp1.ser");
        serialize(e2, "emp2.ser");
        serialize(e3, "emp3.ser");

        for (String f : new String[]{"emp1.ser", "emp2.ser", "emp3.ser"}) {
            Employee restored = deserialize(f);
            System.out.println("Deserialized: " + restored);
        }

        System.out.println("\n=== Uji banyak objek dalam satu file ===");
        serializeAll(List.of(e1, e2, e3), "employees.ser");
        for (Employee emp : deserializeAll("employees.ser")) {
            System.out.println("Deserialized: " + emp);
        }

        System.out.println("\n=== Uji file yang tidak ada ===");
        System.out.println("Hasil: " + deserialize("tidak_ada.ser"));
    }
}
