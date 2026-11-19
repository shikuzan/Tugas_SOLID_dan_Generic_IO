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

    public String info() {
        return String.format("%-8s | Kode: %s | Suku bunga: %.2f%%", name(), code, interestRate);
    }
}
