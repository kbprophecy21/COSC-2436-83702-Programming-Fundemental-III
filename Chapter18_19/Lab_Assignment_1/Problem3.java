import java.util.*;




public class Problem3 {

    public static <T extends Comparable<T>> T findMax(List<ComparableContainer<T>> containers)
    {

        T max = containers.get(0).getGreaterThan();

        for (ComparableContainer<T> container : containers) {
            T current = container.getGreaterThan();
            if (current.compareTo(max) > 0) {
                max = current;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        List<ComparableContainer<Integer>> intContainers = new ArrayList<>();

        intContainers.add(new ComparableContainer<>(3, 8));
        intContainers.add(new ComparableContainer<>(5, 2));
        intContainers.add(new ComparableContainer<>(10, 7));

        Integer maxNumber = findMax(intContainers);
        System.out.println("The Max Integer Value: " + maxNumber);

        
        List<ComparableContainer<String>> stringContainers = new ArrayList<>();
        stringContainers.add(new ComparableContainer<>("Pineapples", "Avaccados"));
        stringContainers.add(new ComparableContainer<>("Lizard", "Snake"));
        stringContainers.add(new ComparableContainer<>("Blueberry", "Orange"));

        String maxWord = findMax(stringContainers);
        System.out.println("The max value string is: " + maxWord);
    }


    public static class ComparableContainer <T extends Comparable<T>> {
        public T value_1;
        public T value_2;

        public ComparableContainer(T value_1, T value_2) {
            this.value_1 = value_1;
            this.value_2 = value_2;
        }

        public T getGreaterThan() {
            if (value_1.compareTo(value_2) >= 0) {
                return value_1;
            } else {
                return value_2;
            }
        }
    }
}



  

