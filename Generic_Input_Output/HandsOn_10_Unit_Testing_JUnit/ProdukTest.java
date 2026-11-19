import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProdukTest {
    private Path tempFile;

    @Before
    public void setUp() throws IOException {
        tempFile = Files.createTempFile("produk_test", ".txt");
    }

    @After
    public void tearDown() throws IOException {
        Files.deleteIfExists(tempFile);
    }

    @Test
    public void toCsvMenyertakanStok() {
        Produk<String, Double> p = new Produk<>("Laptop", 15000000.0, 12);
        assertEquals("Laptop,1.5E7,12", p.toCsv());
        assertEquals(Integer.valueOf(12), p.getStok());
    }

    @Test
    public void fromCsvMembacaSemuaAtribut() {
        Produk<String, Double> p = Produk.fromCsv("Mouse,150000.0,80");
        assertEquals("Mouse", p.getNama());
        assertEquals(150000.0, p.getHarga(), 0.001);
        assertEquals(Integer.valueOf(80), p.getStok());
    }

    @Test
    public void simpanLaluBacaKembaliProduk() throws IOException {
        FileStorage<Produk<String, Double>> storage = new FileStorage<>(tempFile);
        storage.save(List.of(
                new Produk<>("Laptop", 15000000.0, 12),
                new Produk<>("Mouse", 150000.0, 80)));

        List<String> lines = storage.readLines();
        assertEquals(2, lines.size());

        List<Produk<String, Double>> hasil = storage.load(Produk::fromCsv);
        assertEquals("Laptop", hasil.get(0).getNama());
        assertEquals(Integer.valueOf(80), hasil.get(1).getStok());
    }

    @Test
    public void storageBisaDipakaiUntukPelanggan() throws IOException {
        FileStorage<Pelanggan> storage = new FileStorage<>(tempFile);
        storage.save(List.of(new Pelanggan("P001", "Andi", "andi@mail.com")));

        List<Pelanggan> hasil = storage.load(Pelanggan::fromCsv);
        assertEquals(1, hasil.size());
        assertEquals("andi@mail.com", hasil.get(0).getEmail());
    }

    @Test
    public void storageBisaDipakaiUntukTransaksi() throws IOException {
        FileStorage<Transaksi> storage = new FileStorage<>(tempFile);
        storage.save(List.of(new Transaksi("T001", "P001", "Laptop", 1, 15000000.0)));

        Transaksi t = storage.load(Transaksi::fromCsv).get(0);
        assertEquals("T001", t.getKode());
        assertTrue(t.getTotal() > 0);
    }
}
