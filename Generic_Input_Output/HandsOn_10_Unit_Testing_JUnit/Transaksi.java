/** Jenis data lain yang bisa disimpan dengan FileStorage: Transaksi. */
public class Transaksi implements CsvRecord {
    private final String kode;
    private final String idPelanggan;
    private final String namaProduk;
    private final int jumlah;
    private final double total;

    public Transaksi(String kode, String idPelanggan, String namaProduk, int jumlah, double total) {
        this.kode = kode;
        this.idPelanggan = idPelanggan;
        this.namaProduk = namaProduk;
        this.jumlah = jumlah;
        this.total = total;
    }

    public String getKode() { return kode; }
    public double getTotal() { return total; }

    public static Transaksi fromCsv(String line) {
        String[] p = line.split(",");
        return new Transaksi(p[0], p[1], p[2], Integer.parseInt(p[3]), Double.parseDouble(p[4]));
    }

    @Override
    public String toCsv() {
        return kode + "," + idPelanggan + "," + namaProduk + "," + jumlah + "," + total;
    }

    @Override
    public String toString() {
        return "Transaksi{" + kode + ", pelanggan=" + idPelanggan + ", produk=" + namaProduk
                + ", jumlah=" + jumlah + ", total=" + total + "}";
    }
}
