/**
 * SRP: satu-satunya alasan kelas ini berubah adalah jika
 * FORMAT laporan nilai berubah.
 */
public class ReportPrinter {
    public void cetakLaporan(String nama, double nilai) {
        System.out.println("Laporan Nilai Mahasiswa: " + nama + " = " + nilai);
    }
}
