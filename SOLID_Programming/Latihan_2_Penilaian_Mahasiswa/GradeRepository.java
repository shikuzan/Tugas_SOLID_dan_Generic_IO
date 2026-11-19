/**
 * Abstraksi penyimpanan nilai.
 * Dengan interface ini, cara penyimpanan (database, file, cloud)
 * bisa diganti tanpa mengubah kelas lain (DIP + OCP).
 */
public interface GradeRepository {
    void simpan(String nama, double nilai);
}
