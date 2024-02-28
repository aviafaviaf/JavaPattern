package Practice3;

import java.util.*;

class SynchronizedSet<E> implements Set<E>{
    private Set<E> set = new HashSet<E>();
    @Override
    synchronized public boolean add(E e) {
        return set.add(e);
    }

    @Override
    synchronized public boolean addAll(Collection<? extends E> c) {
        return set.addAll(c);
    }

    @Override
    synchronized public void clear() {
        set.clear();
    }

    @Override
    synchronized public boolean contains(Object o) {
        return set.contains(o);
    }

    @Override
    synchronized public boolean containsAll(Collection<?> c) {
        return set.containsAll(c);
    }

    @Override
    synchronized public boolean equals(Object obj) {
        return set.equals(obj);
    }

    @Override
    synchronized public int hashCode() {
        return set.hashCode();
    }

    @Override
    synchronized public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    synchronized public Iterator<E> iterator() {
        return set.iterator();
    }

    @Override
    synchronized public boolean remove(Object o) {
        return set.remove(o);
    }

    @Override
    synchronized public boolean removeAll(Collection<?> c) {
        return set.removeAll(c);
    }

    @Override
    synchronized public boolean retainAll(Collection<?> c) {
        return set.retainAll(c);
    }

    @Override
    synchronized public int size() {
        return set.size();
    }

    @Override
    synchronized public Object[] toArray() {
        return set.toArray();
    }

    @Override
    synchronized public <T> T[] toArray(T[] a) {
        T[] temp;
        temp = set.toArray(a);
        return temp;
    }

    @Override
    synchronized public String toString() {
        return Arrays.toString(set.toArray());
    }

    public static void main(String[] args) {
        SynchronizedSet<Integer> synchronizedSet = new SynchronizedSet<>();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                synchronizedSet.add(i * 2);
            }
            System.out.println(synchronizedSet);
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                synchronizedSet.add(i * 2);
            }
            System.out.println(synchronizedSet);
        });

        thread1.start();
        thread2.start();
    }
}