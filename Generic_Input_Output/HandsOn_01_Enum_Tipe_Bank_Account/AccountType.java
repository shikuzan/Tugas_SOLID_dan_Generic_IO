/**
 * Enum tipe akun bank.
 * Latihan: menambahkan DEPOSIT dan override toString() agar deskriptif.
 */
public enum AccountType {
    SAVINGS,
    CREDIT,
    DEPOSIT;   // tipe baru

    @Override
    public String toString() {
        switch (this) {
            case SAVINGS:
                return "Savings Account (Tabungan)";
            case CREDIT:
                return "Credit Account (Kartu Kredit)";
            case DEPOSIT:
                return "Deposit Account (Deposito Berjangka)";
            default:
                return name();
        }
    }
}
