public class MobilBensin extends Vehicle implements EngineVehicle, FuelPowered {
    public MobilBensin(String nama) {
        super(nama);
    }

    @Override
    public void startEngine() {
        System.out.println(getNama() + ": Menyalakan mesin bensin...");
    }

    @Override
    public void isiBahanBakar() {
        System.out.println(getNama() + ": Mengisi bahan bakar kendaraan...");
    }

    @Override
    public void jalan() {
        System.out.println(getNama() + ": Melaju dengan mesin pembakaran.");
    }
}
