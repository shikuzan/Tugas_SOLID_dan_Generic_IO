/** Stasiun pengisian hanya menerima kendaraan yang memakai baterai. */
public class StasiunPengisianListrik {
    public void layani(BatteryPowered kendaraan) {
        kendaraan.isiBaterai();
    }
}
