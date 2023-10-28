package com.example.algorithms;

public class CustomArrayList implements StringList {
    // Приведенная реализация использует массив elements для хранения строк и переменную size для отслеживания текущего количества элементов в списке.
    // Конструкторы позволяют создавать списки с заданным начальным размером или использовать размер по умолчанию.
    private static final int DEFAULT_CAPACITY = 10;
    private String[] elements;
    private int size;
    public CustomArrayList() {
        this.elements = new String[DEFAULT_CAPACITY];
        this.size = 0;
    }
    public CustomArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Initial capacity cannot be negative"); // не может быть отрицательной
        }
        this.elements = new String[initialCapacity];
        this.size = 0;
    }
    // Методы add, add(int index, String item), set, remove, и remove(int index) выполняют соответствующие операции, сдвигая элементы при необходимости.
    @Override
    public String add(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null"); // Элемент не может быть нулевым
        }
        ensureCapacity(size + 1);
        elements[size] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds"); // Индекс находится за пределами допустимых значений
        }
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null"); // Элемент не может быть нулевым
        }
        ensureCapacity(size + 1);
        shiftRight(index);
        elements[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds"); // Индекс находится за пределами допустимых значений
        }
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null"); // Элемент не может быть нулевым
        }
        String replacedItem = elements[index];
        elements[index] = item;
        return replacedItem;
    }

    @Override
    public String remove(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null"); // Элемент не может быть нулевым
        }
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                String removedItem = elements[i];
                shiftLeft(i);
                size--;
                return removedItem;
            }
        }
        throw new IllegalArgumentException("Item not found in the list"); // Элемент не найден в списке
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds"); // Индекс находится за пределами допустимых значений
        }
        String removedItem = elements[index];
        shiftLeft(index);
        size--;
        return removedItem;
    }

    // Методы contains, indexOf, lastIndexOf, get, size, isEmpty, и toArray выполняют операции поиска, получения информации и возврата массива с элементами списка.
    @Override
    public boolean contains(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null"); // Элемент не может быть нулевым
        }
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null"); // Элемент не может быть нулевым
        }
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null"); // Элемент не может быть нулевым
        }
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds"); // Индекс находится за пределами допустимых значений
        }
        return elements[index];
    }

    // Метод equals сравнивает данный список с другим списком.
    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException("Other list cannot be null"); // Элемент не может быть нулевым
        }
        if (this == otherList) {
            return true;
        }
        if (size != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!elements[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] array = new String[size];
        System.arraycopy(elements, 0, array, 0, size);
        return array;
    }

    // Метод ensureCapacity увеличивает емкость массива, если необходимо.
    private void ensureCapacity(int capacity) {
        if (capacity > elements.length) {
            int newCapacity = Math.max(elements.length * 2, capacity);
            String[] newElements = new String[newCapacity];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    // Методы shiftRight и shiftLeft сдвигают элементы вправо или влево при добавлении или удалении элементов.
    private void shiftRight(int index) {
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
    }

    private void shiftLeft(int index) {
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
    }

}

