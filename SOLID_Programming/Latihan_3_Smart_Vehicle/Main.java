import java.util.List;

public class Main {
    public static void main(String[] args) {
        MobilListrik mobilListrik = new MobilListrik("Mobil Listrik");
        MobilBensin mobilBensin = new MobilBensin("Mobil Bensin");
        Sepeda sepeda = new Sepeda("Sepeda");
        MobilHybrid mobilHybrid = new MobilHybrid("Mobil Hybrid"); // jenis baru (OCP)

        System.out.println("=== Menyalakan kendaraan bermesin ===");
        List<EngineVehicle> bermesin = List.of(mobilListrik, mobilBensin, mobilHybrid);
        for (EngineVehicle v : bermesin) {
            v.startEngine();
        }

        System.out.println("\n=== Pengisian energi ===");
        SPBU spbu = new SPBU();
        StasiunPengisianListrik spkl = new StasiunPengisianListrik();
        spbu.layani(mobilBensin);
        spbu.layani(mobilHybrid);
        spkl.layani(mobilListrik);
        spkl.layani(mobilHybrid);

        System.out.println("\n=== Semua kendaraan berjalan (polimorfisme) ===");
        List<Vehicle> semua = List.of(mobilListrik, mobilBensin, sepeda, mobilHybrid);
        for (Vehicle v : semua) {
            v.jalan();
        }
    }
}
