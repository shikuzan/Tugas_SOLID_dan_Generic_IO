public class Sepeda extends Vehicle {
    public Sepeda(String nama) {
        super(nama);
    }

    @Override
    public void jalan() {
        System.out.println(getNama() + ": Dikayuh dengan tenaga manusia.");
    }
}
