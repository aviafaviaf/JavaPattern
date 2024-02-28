package Practice3;

import java.util.*;
import java.util.concurrent.Semaphore;

public class SemaphoreMap<K, V> implements Map<K, V> {
    private final Semaphore semaphore = new Semaphore(1, true);

    private volatile Map<Object, Object> map = new HashMap<Object, Object>();

    @Override
    public int size() {
        try{
            semaphore.acquire();
            return map.size();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public boolean isEmpty() {
        try{
            semaphore.acquire();
            return map.isEmpty();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public boolean containsKey(Object o) {
        try{
            semaphore.acquire();
            return map.containsKey(o);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public boolean containsValue(Object value) {
        try{
            semaphore.acquire();
            return map.containsValue(value);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public V get(Object key) {
        try{
            semaphore.acquire();
            return (V) map.get(key);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public V remove(Object o) {
        try{
            semaphore.acquire();
            return (V) map.remove(o);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public V put(K key, V value) {
        try{
            semaphore.acquire();
            return (V) map.put(key, value);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        try{
            semaphore.acquire();
            map.putAll(m);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }


    @Override
    public void clear() {
        try{
            semaphore.acquire();
            map.clear();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public Set<K> keySet() {
        try{
            semaphore.acquire();
            return (Set<K>) map.keySet();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public Collection<V> values() {
        try{
            semaphore.acquire();
            return (Collection<V>) map.values();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public String toString() {
        try{
            semaphore.acquire();
            return map.toString();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        SemaphoreMap<Integer, Integer> map = new SemaphoreMap<>();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                map.put(i, i * 2);
            }
            for (int i = 0; i < 10; i++) {
                map.remove(i);
            }
            System.out.println(map);
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                map.put(i, i * 2);
            }
            for (int i = 0; i < 10; i++) {
                map.remove(i);
            }
            System.out.println(map);
        });

        thread1.start();
        thread2.start();
    }
}
