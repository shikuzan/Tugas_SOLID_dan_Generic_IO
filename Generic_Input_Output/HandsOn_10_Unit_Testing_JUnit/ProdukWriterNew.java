import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProdukWriterNew {
    public static void main(String[] args) {
        try {
            // ===== 1. Produk (dengan atribut stok) =====
            List<Produk<String, Double>> produkList = new ArrayList<>();
            produkList.add(new Produk<>("Laptop", 15000000.0, 12));
            produkList.add(new Produk<>("Mouse", 150000.0, 80));
            produkList.add(new Produk<>("Keyboard", 350000.0, 45));

            FileStorage<Produk<String, Double>> produkStorage =
                    new FileStorage<>(Paths.get("produk_output.txt"));
            produkStorage.save(produkList);
            System.out.println("Data produk berhasil disimpan menggunakan NIO.2");

            // ===== 2. Membaca kembali dengan Files.readAllLines() =====
            System.out.println("\nIsi produk_output.txt (Files.readAllLines):");
            for (String line : produkStorage.readLines()) {
                System.out.println("  " + line);
            }

            System.out.println("\nDitampilkan sebagai tabel:");
            System.out.printf("  %-10s %15s %6s%n", "Nama", "Harga", "Stok");
            for (Produk<String, Double> p : produkStorage.load(Produk::fromCsv)) {
                System.out.printf("  %-10s %,15.0f %6d%n", p.getNama(), p.getHarga(), p.getStok());
            }

            // ===== 3. Class yang sama dipakai untuk data lain =====
            FileStorage<Pelanggan> pelangganStorage = new FileStorage<>(Paths.get("pelanggan.txt"));
            pelangganStorage.save(List.of(
                    new Pelanggan("P001", "Andi", "andi@mail.com"),
                    new Pelanggan("P002", "Sari", "sari@mail.com")));

            FileStorage<Transaksi> transaksiStorage = new FileStorage<>(Paths.get("transaksi.txt"));
            transaksiStorage.save(List.of(
                    new Transaksi("T001", "P001", "Laptop", 1, 15000000.0),
                    new Transaksi("T002", "P002", "Mouse", 2, 300000.0)));

            System.out.println("\nIsi pelanggan.txt:");
            pelangganStorage.load(Pelanggan::fromCsv).forEach(p -> System.out.println("  " + p));

            System.out.println("\nIsi transaksi.txt:");
            transaksiStorage.load(Transaksi::fromCsv).forEach(t -> System.out.println("  " + t));

        } catch (IOException e) {
            System.out.println("Gagal memproses file: " + e.getMessage());
        }
    }
}
