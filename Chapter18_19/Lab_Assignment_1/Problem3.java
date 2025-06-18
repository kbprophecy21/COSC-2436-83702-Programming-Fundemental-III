import java.util.*;




public class Problem3 {



    public static <T extends Comparable<T>> T findMax(List<ComparableContainer<T>> containers)
    {

        T max = containers.get(0).getGreater();

        for (ComparableContainer<T> container : containers) {
            T current = container.getGreater();
            if (current.compareTo(max) > 0) {
                max = current;
            }
        }

        return max;
    }




public class ComparableContainer<T extends Comparable<T>> {
    private T first;
    private T second;

    public ComparableContainer(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getGreater() {
        return (first.compareTo(second) >= 0) ? first : second;
    }
}



    public static void main(String[] args) {

        
        // Integer example
        List<ComparableContainer<Integer>> intContainers = new ArrayList<>();
        intContainers.add(new ComparableContainer<>(3, 8));
        intContainers.add(new ComparableContainer<>(5, 2));
        intContainers.add(new ComparableContainer<>(10, 7));

        Integer maxInt = findMax(intContainers);
        System.out.println("Max Integer: " + maxInt);

        // String example
        List<ComparableContainer<String>> stringContainers = new ArrayList<>();
        stringContainers.add(new ComparableContainer<>("apple", "banana"));
        stringContainers.add(new ComparableContainer<>("dog", "cat"));
        stringContainers.add(new ComparableContainer<>("zebra", "lion"));

        String maxStr = findMax(stringContainers);
        System.out.println("Max String: " + maxStr);
    }
}
