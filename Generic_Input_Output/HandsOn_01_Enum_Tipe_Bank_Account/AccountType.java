public enum AccountType {
    SAVINGS,
    CREDIT,
    DEPOSIT;   

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
