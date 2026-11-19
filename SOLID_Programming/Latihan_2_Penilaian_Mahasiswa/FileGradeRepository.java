public class FileGradeRepository implements GradeRepository {
    @Override
    public void simpan(String nama, double nilai) {
        System.out.println("Menyimpan ke file nilai.csv: " + nama + "," + nilai);
    }
}
