public class GradeCalculator {
    private static final double BOBOT_TUGAS = 0.3;
    private static final double BOBOT_UTS = 0.3;
    private static final double BOBOT_UAS = 0.4;

    public double hitungNilaiAkhir(double tugas, double uts, double uas) {
        return (tugas * BOBOT_TUGAS) + (uts * BOBOT_UTS) + (uas * BOBOT_UAS);
    }
}
