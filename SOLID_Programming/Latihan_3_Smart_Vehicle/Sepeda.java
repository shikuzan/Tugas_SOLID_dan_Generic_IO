/**
 * Sepeda: hanya mewarisi Vehicle. Tidak mengimplementasikan EngineVehicle,
 * sehingga memanggil sepeda.startEngine() sudah DITOLAK saat kompilasi,
 * bukan error saat runtime.
 */
public class Sepeda extends Vehicle {
    public Sepeda(String nama) {
        super(nama);
    }

    @Override
    public void jalan() {
        System.out.println(getNama() + ": Dikayuh dengan tenaga manusia.");
    }
}
