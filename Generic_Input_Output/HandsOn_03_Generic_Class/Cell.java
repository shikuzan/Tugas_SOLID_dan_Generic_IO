/**
 * Generic class: T diganti dengan tipe nyata saat objek dibuat.
 */
public class Cell<T> {
    private T data;

    public void setValue(T data) {
        this.data = data;
    }

    public T getValue() {
        return data;
    }

    /** Menampilkan tipe data yang sedang disimpan. */
    public void displayType() {
        if (data == null) {
            System.out.println("Cell masih kosong (null)");
        } else {
            System.out.println("Nilai: " + data + " | Tipe data: " + data.getClass().getName());
        }
    }
}
