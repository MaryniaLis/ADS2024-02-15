package by.it.group351003.lisunova.lesson09;

import java.util.*;

public class ListA<E> implements List<E> {

    //Создайте аналог списка БЕЗ использования других классов СТАНДАРТНОЙ БИБЛИОТЕКИ

    int size = 0;
    E[] arr;

    ListA() {
        this.arr = (E[]) new Object[size];
    }

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    //////               Обязательные к реализации методы             ///////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    @Override
    public String toString() {
        if (size == 0) {
            return "";
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
    //////               Опциональные к реализации методы             ///////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////

    @Override
    public void add(int index, E element) {

    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }


    @Override
    public boolean isEmpty() {
        return false;
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
        return 0;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

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
