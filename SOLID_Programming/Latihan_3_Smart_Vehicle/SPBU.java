/** SPBU hanya menerima kendaraan yang memang memakai bahan bakar (bergantung pada abstraksi). */
public class SPBU {
    public void layani(FuelPowered kendaraan) {
        kendaraan.isiBahanBakar();
    }
}
