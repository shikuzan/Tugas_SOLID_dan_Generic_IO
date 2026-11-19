public abstract class Vehicle {
    private final String nama;

    protected Vehicle(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    /** Semua kendaraan bisa bergerak, dengan caranya masing-masing (polimorfisme). */
    public abstract void jalan();
}
