public class Main {
    public static void main(String[] args) {
        System.out.println("=== Daftar tipe akun, kode, dan suku bunga ===");
        for (AccountType t : AccountType.values()) {
            System.out.println(t.info());
        }

        System.out.println("\n=== Loop tipe beserta kodenya ===");
        for (AccountType t : AccountType.values()) {
            System.out.println(t + " -> " + t.getCode());
        }

        double saldo = 10_000_000;
        AccountType tipe = AccountType.SAVINGS;
        double bunga = saldo * tipe.getInterestRate() / 100;
        System.out.printf("%nBunga 1 tahun %s untuk saldo Rp%,.0f = Rp%,.0f%n", tipe, saldo, bunga);
    }
}
