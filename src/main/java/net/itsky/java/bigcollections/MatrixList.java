package net.itsky.java.bigcollections;

import java.util.List;
import java.util.AbstractList;
import java.util.ArrayList;

public class MatrixList<T> extends AbstractList<T> implements List<T> {

    private static long MAX_CAPACITY = (long) Integer.MAX_VALUE * (long) Integer.MAX_VALUE - 1;

    private List<List<T>> matrix;

    private long size;
   
    private int ssize;

    private long capacity;

    public MatrixList(long capacity) {
        super();
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity=" + capacity + " <=0");
        } else if (capacity > MAX_CAPACITY) {
            throw new IllegalArgumentException("capacity=" + capacity + " > MAX_CAPACITY=" + MAX_CAPACITY);
        }         
        ssize = (int) Math.sqrt((double) capacity) + 1;
        size = 0;
        matrix = new ArrayList<List<T>>(ssize);
    }

    public long lsize() {
        return size;
    }

    public int size() {
        if (size > Integer.MAX_VALUE) {
            throw new IllegalStateException("size=" + size + " does not fit in int");
        }
        return (int) size;
    }

    public T get(int i) {
        return lget(i);
    }

    public T set(int i, T t) {
        return lset(i, t);
    }

    public T lget(long i) {
        if (i >= size) {
            return null;
        } else {
            int ai = (int) (i / ssize);
            int bi = (int) (i % ssize);
            List<T> l = matrix.get(ai);
            return l.get(bi);
        }
    }

    public T lset(long i, T t) {
        if (i >= size) {
            throw new IllegalStateException("lset cannot grow i=" + i + " size=" + size);
        }
        int ai = (int) (i / ssize);
        int bi = (int) (i % ssize);
        List<T> l = matrix.get(ai);
        return l.set(bi, t);
    }

    public void ensureCapacity(long cap) {
        if (cap > capacity) {
            throw new IllegalArgumentException("growing of capacity not yet supported");
        } else if (cap <= 0) {
            throw new IllegalArgumentException("capacity=" + capacity + " <=0 (not supported)");
        }

    }

    public void ensureSize(long size) {
        ensureCapacity(size);
        if (size <= this.size) {
            return;
        } else if (size < 0) {
            throw new IllegalArgumentException("size=" + size + " <0 (not supported)");
        }

        int asize = (int) ((size + ssize - 1) / ssize);
        while (matrix.size() < asize) {
            matrix.add(new ArrayList<T>(ssize));
        }
    }

    public boolean add(T t) {
        ensureSize(size + 1);
        int ai = (int) (size / ssize);
        return matrix.get(ai).add(t);
    }
}
