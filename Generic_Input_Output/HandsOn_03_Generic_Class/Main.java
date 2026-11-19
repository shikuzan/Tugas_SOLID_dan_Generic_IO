public class Main {
    public static void main(String[] args) {
        Cell<Integer> intCell = new Cell<>();
        intCell.setValue(100);
        intCell.displayType();

        Cell<String> strCell = new Cell<>();
        strCell.setValue("Halo Generic");
        strCell.displayType();

        // Type safety: tidak perlu casting saat mengambil nilai
        int angka = intCell.getValue();          // langsung Integer -> int
        String teks = strCell.getValue();        // langsung String
        System.out.println("angka * 2 = " + (angka * 2));
        System.out.println("teks.length() = " + teks.length());

        // intCell.setValue("seratus");   // <- ERROR saat kompilasi: String bukan Integer
    }
}
