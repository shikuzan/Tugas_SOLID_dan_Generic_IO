/**
 * Produk generic: T = tipe nama, U = tipe harga.
 * Latihan: menambahkan atribut stok bertipe Integer.
 */
public class Produk<T, U> implements CsvRecord {
    private T nama;
    private U harga;
    private Integer stok;

    public Produk(T nama, U harga, Integer stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public T getNama() { return nama; }
    public U getHarga() { return harga; }
    public Integer getStok() { return stok; }

    /** Mengubah satu baris CSV "nama,harga,stok" menjadi Produk<String, Double>. */
    public static Produk<String, Double> fromCsv(String line) {
        String[] p = line.split(",");
        return new Produk<>(p[0].trim(), Double.parseDouble(p[1].trim()), Integer.parseInt(p[2].trim()));
    }

    @Override
    public String toCsv() {
        return nama + "," + harga + "," + stok;
    }

    @Override
    public String toString() {
        return toCsv();
    }
}
