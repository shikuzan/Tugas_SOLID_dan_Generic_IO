public class MobilListrik extends Vehicle implements EngineVehicle, BatteryPowered {
    public MobilListrik(String nama) {
        super(nama);
    }

    @Override
    public void startEngine() {
        System.out.println(getNama() + ": Menyalakan motor listrik...");
    }

    @Override
    public void isiBaterai() {
        System.out.println(getNama() + ": Mengisi baterai kendaraan listrik...");
    }

    @Override
    public void jalan() {
        System.out.println(getNama() + ": Melaju tanpa suara dengan tenaga baterai.");
    }
}
