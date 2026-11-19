public class Main {
    public static void main(String[] args) {
        GradeCalculator calculator = new GradeCalculator();
        ReportPrinter printer = new ReportPrinter();

        System.out.println("=== Simpan ke database ===");
        GradingService service = new GradingService(calculator, printer, new DatabaseGradeRepository());
        service.prosesNilai("Andi", 80, 85, 90);

        // Cara penyimpanan diganti, kelas lain tidak perlu diubah
        System.out.println("\n=== Simpan ke file ===");
        GradingService serviceFile = new GradingService(calculator, printer, new FileGradeRepository());
        serviceFile.prosesNilai("Budi", 75, 80, 88);
    }
}
