package com.pykost.lesson2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * MyArrayList — коллекция, реализует интерфейс CustomList.
 * Может менять свой размер во время исполнения программы,
 * при этом не обязательно указывать размерность при создании объекта.
 * Элементы MyArrayList могут быть абсолютно любых (ссылочных) типов, в том числе и null.
 */
public class MyArrayList<T> implements CustomList<T> {

    /**
     * Начальное значение по умолчанию.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Массив в который добавляются элементы MyArrayList
     * при создании списка расширяется до DEFAULT_CAPACITY
     */
    private T[] elementData;

    /**
     * Размер ArrayList (количество элементов, которые он содержит).
     */
    private int size;

    /**
     * Создаёт пустой список, с начальной ёмкостью DEFAULT_CAPACITY
     */
    public MyArrayList() {
        this.elementData = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Создаёт пустой список, с указанной начальной ёмкостью.
     *
     * @param initialCapacity начальная ёмкость списка
     * @throws IllegalArgumentException если указанная начальная ёмкость отрицательна или равна нулю
     */
    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = (T[]) new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Недопустимое значение Capacity" + initialCapacity);
        }
    }

    /**
     * Добавляет указанный элемент в конец этого списка.
     *
     * @param element элемент, который нужно добавить в этот список
     * @return значение true, если элемент добавлен в список
     */
    @Override
    public boolean add(T element) {
        checkingSizeArray();
        final int index = this.size;
        elementData[index] = element;
        this.size++;
        return true;
    }

    /**
     * Проверяет длину массива.
     */
    private void checkingSizeArray() {
        int s = this.size;
        int capacity = this.elementData.length;
        if (s == capacity) {
            elementData = increase();
        }
    }

    /**
     * Увеличивает объём массива на 50%
     *
     * @return увеличенный массив элементов
     */
    private T[] increase() {
        T[] temp = elementData;
        int newCapacity = elementData.length + (elementData.length >> 1);
        elementData = (T[]) new Object[newCapacity];
        System.arraycopy(temp, 0, elementData, 0, temp.length);
        return elementData;
    }

    /**
     * Вставляет указанный элемент в указанную позицию в этом списке. Сдвигает элемент,
     * находящийся в этой позиции (если он есть), и все последующие элементы вправо
     *
     * @param index   индекс, по которому должен быть вставлен указанный элемент
     * @param element элемент, который нужно вставить
     * @throws IndexOutOfBoundsException если индекс находится вне диапазона списка
     */
    @Override
    public void add(int index, T element) {
        Objects.checkIndex(index, size);
        Object[] elementData = this.elementData;
        final int s = size;
        checkingSizeArray();
        System.arraycopy(elementData, index, elementData, index + 1, s - index);
        elementData[index] = element;
        this.size++;
    }

    /**
     * Возвращает элемент в указанной позиции в этом списке.
     *
     * @param index индекс возвращаемого элемента
     * @return элемент, находящийся в указанной позиции в этом списке
     * @throws IndexOutOfBoundsException если индекс находится вне диапазона списка
     */
    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return elementData[index];
    }

    /**
     * Удаляет элемент в указанной позиции в этом списке.
     * Сдвигает все последующие элементы влево
     *
     * @param index индекс элемента, подлежащего удалению из списка
     * @return элемент, который был удален из списка
     * @throws IndexOutOfBoundsException если индекс находится вне диапазона списка
     */
    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        final T[] temp = elementData;
        T deletedItem = temp[index];
        fastRemove(index, temp);
        return deletedItem;
    }

    /**
     * Закрытый метод удаления.
     */
    private void fastRemove(int index, T[] temp) {
        final int newSize = size - 1;
        if (newSize > index) {
            System.arraycopy(temp, index + 1, temp, index, newSize - index);
        }
        temp[size = newSize] = null;
    }

    /**
     * Удаляет все элементы из этого списка.
     * После завершения этого вызова список будет пустым.
     */
    @Override
    public void clear() {
        T[] list = elementData;
        for (int i = 0; i < size; i++) {
            list[i] = null;
        }
        size = 0;
    }

    /**
     * Сортирует этот список в соответствии с порядком, заданным указанным компаратором.
     * Реализует алгоритм сортировки quickSort (Быстрая сортировка)
     *
     * @param comparator компаратор используемый для сравнения элементов списка
     */
    @Override
    public void sort(Comparator<? super T> comparator) {
        T[] array = elementData;
        quickSort(comparator, array, 0, size - 1);
    }

    /**
     * Возвращает количество элементов в этом списке.
     *
     * @return количество элементов в этом списке.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Заменяет элемент в указанной позиции в этом списке на указанный элемент.
     *
     * @param index   индекс заменяемого элемента
     * @param element элемент, который должен быть сохранен в указанном положении
     * @return элемент, ранее находившийся в указанном положении
     * @throws IndexOutOfBoundsException если индекс находится вне диапазона списка
     */
    @Override
    public T set(int index, T element) {
        Objects.checkIndex(index, size);
        T obj = elementData[index];
        elementData[index] = element;
        return obj;
    }

    /**
     * Возвращает строковое представление списка
     */
    @Override
    public String toString() {
        return "MyArrayList{" +
                "elementData=" + Arrays.toString(elementData) +
                '}';
    }

    /**
     * Один из самых быстрых известных универсальных алгоритмов сортировки массивов: в среднем O(n log n)
     * обменов при упорядочении n элементов.
     *
     * @param leftIndex  левая граница подмасива
     * @param rightIndex правая граница подмасива
     * @param array      массив элементов
     * @param comparator компаратор используемый для сравнения элементов массива
     */
    private <T> void quickSort(Comparator<T> comparator, T[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int pivot = partition(comparator, array, leftIndex, rightIndex);
            quickSort(comparator, array, leftIndex, pivot);
            quickSort(comparator, array, pivot + 1, rightIndex);
        }
    }

    /**
     * Определяет положение опорного элемента
     */
    private <T> int partition(Comparator<T> comparator, T[] array, int leftIndex, int rightIndex) {
        T pivot = array[(leftIndex + rightIndex) / 2];
        while (leftIndex <= rightIndex) {
            while (comparator.compare(array[leftIndex], pivot) < 0) {
                leftIndex++;
            }
            while (comparator.compare(array[rightIndex], pivot) > 0) {
                rightIndex--;
            }
            if (leftIndex >= rightIndex) {
                break;
            }
            swap(array, leftIndex, rightIndex);
            leftIndex++;
            rightIndex--;

        }
        return rightIndex;
    }

    /**
     * Вспомогательный метод, меняет местами элементы в массиве.
     */
    private <T> void swap(T[] array, int leftIndex, int rightIndex) {
        T temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }
}
