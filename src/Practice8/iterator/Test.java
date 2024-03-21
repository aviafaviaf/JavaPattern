package Practice8.iterator;

public class Test {
    public static void main(String[] args) {
        Aggregate aggregate = new Aggregate();
        aggregate.add(6);
        aggregate.add(3);
        aggregate.add(5);
        aggregate.add(8);

        var iterator = aggregate.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
