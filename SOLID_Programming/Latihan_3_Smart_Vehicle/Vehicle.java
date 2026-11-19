public abstract class Vehicle {
    private final String nama;

    protected Vehicle(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public abstract void jalan();
}
