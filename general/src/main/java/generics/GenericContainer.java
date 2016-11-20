package generics;

import java.util.List;

/**
 * Created by zoomout on 11/2/16.
 * <p>
 * Generics example
 */

public class GenericContainer<E extends MyClass & MyInterface> {
    private E[] elements;
    private int index;

    GenericContainer(int size) {
        elements = (E[]) new MyClass[size];
        index = 0;
    }

    void add(E element) {
        elements[index++] = element;
    }

    E get(int index) {
        return elements[index];
    }

    int size() {
        return index;
    }

    public <T> List<T> copy(List<T> src, List<T> dest) {
        for (int i = 0; i < src.size(); i++) {
            dest.add(src.get(i));
        }
        return dest;
    }
}
