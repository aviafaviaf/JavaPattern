package Practice8.iterator;

import java.util.List;

public class Iterator implements IIterator<Integer> {
    private final List<Integer> list;
    private int i;

    public Iterator(List<Integer> list) {
        this.list = list;
        i = 0;
    }

    @Override
    public Integer next() {
        if (hasNext())
            return list.get(i++);
        else
            throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean hasNext() {
        return i < list.size();
    }
}
