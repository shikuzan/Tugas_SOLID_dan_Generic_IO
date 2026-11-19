public class Main {
    public static void main(String[] args) {
        System.out.println("=== Semua tipe akun ===");
        for (AccountType t : AccountType.values()) {
            System.out.println(t.ordinal() + ". " + t.name() + " -> " + t);
        }

        System.out.println("\n=== Uji objek Account ===");
        Account akun = new Account(AccountType.DEPOSIT);
        System.out.println("Tipe akun: " + akun.getType());

    }
}
