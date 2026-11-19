/**
 * Kontrak untuk data apa pun yang bisa disimpan ke file teks
 * sebagai satu baris CSV (produk, pelanggan, transaksi, dll).
 */
public interface CsvRecord {
    String toCsv();
}
