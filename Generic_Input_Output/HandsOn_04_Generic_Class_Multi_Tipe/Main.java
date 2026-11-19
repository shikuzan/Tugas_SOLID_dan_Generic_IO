public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> p1 = new Pair<>(90, "Andi");
        System.out.println("p1 = " + p1);
        p1.showTypes();

        Pair<String, Integer> p1Swapped = p1.swap();
        System.out.println("p1.swap() = " + p1Swapped);
        p1Swapped.showTypes();

        System.out.println();

        Pair<Double, Boolean> p2 = new Pair<>(3.75, true);
        System.out.println("p2 = " + p2);
        p2.showTypes();

        Pair<Boolean, Double> p2Swapped = p2.swap();
        System.out.println("p2.swap() = " + p2Swapped);
        p2Swapped.showTypes();
    }
}
