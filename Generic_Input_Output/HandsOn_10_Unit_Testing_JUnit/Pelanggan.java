/** Jenis data lain yang bisa disimpan dengan FileStorage: Pelanggan. */
public class Pelanggan implements CsvRecord {
    private final String id;
    private final String nama;
    private final String email;

    public Pelanggan(String id, String nama, String email) {
        this.id = id;
        this.nama = nama;
        this.email = email;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }
    public String getEmail() { return email; }

    public static Pelanggan fromCsv(String line) {
        String[] p = line.split(",");
        return new Pelanggan(p[0], p[1], p[2]);
    }

    @Override
    public String toCsv() {
        return id + "," + nama + "," + email;
    }

    @Override
    public String toString() {
        return "Pelanggan{" + id + ", " + nama + ", " + email + "}";
    }
}
