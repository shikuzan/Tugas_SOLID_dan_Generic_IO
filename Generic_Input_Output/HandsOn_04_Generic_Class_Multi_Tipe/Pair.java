/**
 * Generic class dengan dua parameter tipe.
 */
public class Pair<T1, T2> {
    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    public void showTypes() {
        System.out.println(first.getClass().getName() + " & " + second.getClass().getName());
    }

    /**
     * Menukar nilai first dan second.
     * Karena T1 dan T2 bisa berbeda tipe, hasilnya adalah Pair BARU
     * dengan urutan tipe yang juga ditukar: Pair<T2, T1>.
     */
    public Pair<T2, T1> swap() {
        return new Pair<>(second, first);
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
