package Practice8.iterator;

import java.util.ArrayList;
import java.util.List;

public class Aggregate implements IAggregate<Integer> {
    private final List<Integer> list = new ArrayList<>();
    @Override
    public IIterator<Integer> createIterator() {
        return new Iterator(list);
    }

    public void add(Integer integer) {
        list.add(integer);
    }
}
