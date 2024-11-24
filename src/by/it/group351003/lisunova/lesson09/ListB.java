package by.it.group351003.lisunova.lesson09;

import java.util.*;

public class ListB<E> implements List<E> {

    static int _initialSize = 10;
    int size = 0;
    E[] arr;

    ListB() {
        this.arr = (E[]) new Object[size];
    }
    //Создайте аналог списка БЕЗ использования других классов СТАНДАРТНОЙ БИБЛИОТЕКИ

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    //////               Обязательные к реализации методы             ///////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            StringBuilder timeString = new StringBuilder(); //тип String, который можно менять
            timeString.append('[');

            for (E element : this.arr) {
                if (element != null)
                    timeString.append(element).append(", ");
            }
            if (!timeString.equals("[")) {
                timeString.deleteCharAt(timeString.length() - 1); // удалили пробел
                timeString.deleteCharAt(timeString.length() - 1); // удалили запятую
            }
            timeString.append(']');

            return timeString.toString();
        }
    }

    @Override
    public boolean add(E e) {
        E[] Temp = (E[]) new Object[this.size + 1];
        System.arraycopy(this.arr, 0, Temp, 0, this.size);
        Temp[this.size] = e;
        this.arr = Temp;
        this.size++;
        return true;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            E removed_item = arr[index];

            for (int i = index; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[--size] = null;
            //this.size--;
            return removed_item;
        }
    }

    @Override
    public int size() {
        return this.size;
    }


    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    @Override
    public void add(int index, E element) {
        if (size == arr.length) {
            arr = Arrays.copyOf(arr, arr.length + (arr.length >> 1));
        }
        System.arraycopy(arr, index, arr, index + 1, size++ - index);
        arr[index] = element;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public E set(int index, E element) {
        E temp = (E) arr[index];
        arr[index] = element;
        return temp;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public void clear()
    {
        //this.arr = (E[]) new Object[_initialSize];
        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }
        this.size = 0;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) {
                return i;
            }
        }
        return - 1;
    }

    @Override
    public E get(int index) {
        return (E) arr[index];
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i].equals(o)) {
                return i;
            }
        }
        return - 1;
    }


    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    //////               Опциональные к реализации методы             ///////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////


    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }


    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    ////////        Эти методы имплементировать необязательно    ////////////
    ////////        но они будут нужны для корректной отладки    ////////////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    @Override
    public Iterator<E> iterator() {
        return null;
    }

}
