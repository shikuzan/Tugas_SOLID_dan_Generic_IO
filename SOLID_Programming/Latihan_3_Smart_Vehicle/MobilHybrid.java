/**
 * Jenis kendaraan BARU (contoh OCP).
 * Cukup membuat kelas baru yang menggabungkan interface yang relevan;
 * tidak ada kelas lama yang diubah.
 */
public class MobilHybrid extends Vehicle implements EngineVehicle, FuelPowered, BatteryPowered {
    public MobilHybrid(String nama) {
        super(nama);
    }

    @Override
    public void startEngine() {
        System.out.println(getNama() + ": Menyalakan sistem hybrid (mesin + motor listrik)...");
    }

    @Override
    public void isiBahanBakar() {
        System.out.println(getNama() + ": Mengisi bahan bakar...");
    }

    @Override
    public void isiBaterai() {
        System.out.println(getNama() + ": Mengisi baterai hybrid...");
    }

    @Override
    public void jalan() {
        System.out.println(getNama() + ": Melaju dengan kombinasi mesin dan baterai.");
    }
}
