/**
 * Koordinator alur penilaian. Kelas ini tidak menghitung, mencetak,
 * atau menyimpan sendiri; ia hanya mendelegasikan ke kelas yang bertanggung jawab.
 */
public class GradingService {
    private final GradeCalculator calculator;
    private final ReportPrinter printer;
    private final GradeRepository repository;

    public GradingService(GradeCalculator calculator, ReportPrinter printer, GradeRepository repository) {
        this.calculator = calculator;
        this.printer = printer;
        this.repository = repository;
    }

    public void prosesNilai(String nama, double tugas, double uts, double uas) {
        double nilai = calculator.hitungNilaiAkhir(tugas, uts, uas);
        printer.cetakLaporan(nama, nilai);
        repository.simpan(nama, nilai);
    }
}
