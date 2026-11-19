/**
 * Kelas dasar yang hanya berisi hal yang DIMILIKI SEMUA kendaraan.
 * Tidak ada startEngine/isiBahanBakar/isiBaterai di sini, karena tidak semua
 * kendaraan punya fitur itu (ISP & LSP).
 */
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
