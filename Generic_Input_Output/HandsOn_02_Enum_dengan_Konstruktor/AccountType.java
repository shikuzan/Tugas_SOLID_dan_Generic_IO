/**
 * Enum dengan konstruktor: setiap tipe akun punya kode internal
 * dan suku bunga (interestRate, dalam persen per tahun).
 */
public enum AccountType {
    SAVINGS("SA", 2.5),
    CREDIT("CR", 18.0),
    DEPOSIT("DP", 4.75);

    private final String code;
    private final double interestRate;

    private AccountType(String code, double interestRate) {
        this.code = code;
        this.interestRate = interestRate;
    }

    public String getCode() {
        return code;
    }

    public double getInterestRate() {
        return interestRate;
    }

    /** Menampilkan nama, kode, dan suku bunga. */
    public String info() {
        return String.format("%-8s | Kode: %s | Suku bunga: %.2f%%", name(), code, interestRate);
    }
}
