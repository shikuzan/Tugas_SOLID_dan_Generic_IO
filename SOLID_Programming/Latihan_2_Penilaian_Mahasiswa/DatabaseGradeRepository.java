public class DatabaseGradeRepository implements GradeRepository {
    @Override
    public void simpan(String nama, double nilai) {
        System.out.println("Menyimpan ke database: " + nama + " = " + nilai);
    }
}
