public class CompareUtil {

    /** Generic method: <T> dideklarasikan pada method, bukan pada class. */
    public static <T extends Comparable<T>> boolean isEqual(T a, T b) {
        return a.compareTo(b) == 0;
    }

    public static void main(String[] args) {
        System.out.println("=== Integer ===");
        System.out.println("isEqual(5, 5)         = " + isEqual(5, 5));

        System.out.println("=== String ===");
        System.out.println("isEqual(Hello, World) = " + isEqual("Hello", "World"));

        System.out.println("=== Double ===");
        System.out.println("isEqual(3.14, 3.14)   = " + isEqual(3.14, 3.14));
        System.out.println("isEqual(2.5, 2.50)    = " + isEqual(2.5, 2.50));
        System.out.println("isEqual(1.1, 1.2)     = " + isEqual(1.1, 1.2));

        System.out.println("=== Character ===");
        System.out.println("isEqual('A', 'A')     = " + isEqual('A', 'A'));
        System.out.println("isEqual('a', 'A')     = " + isEqual('a', 'A'));
        System.out.println("isEqual('x', 'y')     = " + isEqual('x', 'y'));
    }
}
