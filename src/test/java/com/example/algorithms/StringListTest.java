package com.example.algorithms;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringListTest {

    private StringList stringList;

    @Before
    public void setUp() {
        // Создаем экземпляр класса, реализующего интерфейс StringList
        // с использованием массива в качестве хранилища.
        // Задаем размер массива в конструкторе.
        stringList = new CustomArrayList(10);
    }

    @Test
    public void testAdd() {
        // Добавляем элемент в список.
        String item = "Hello";
        String result = stringList.add(item);

        // Проверяем, что элемент был успешно добавлен.
        assertEquals(item, result);
    }

    @Test
    public void testAddAtIndex() {
        // Добавляем элемент на определенную позицию списка.
        String item = "Hello";
        int index = 0;
        String result = stringList.add(index, item);

        // Проверяем, что элемент был успешно добавлен на указанную позицию.
        assertEquals(item, result);
    }
    @Test
    public void addByIndex_IndexOutOfBoundsException() {

        setupInit();

        stringList.add(1, "п");

        assertThrows(IndexOutOfBoundsException.class, () -> stringList.add(13, "t"));

    }
    @Test
    public void testSet() {
        // Устанавливаем элемент на определенную позицию списка.
        setupInit();
        String item = "и";
        int index = 2;
        String result = stringList.set(index, item);

        // Проверяем, что элемент был успешно установлен на указанную позицию.
        assertEquals(item, result);
    }

    @Test
    public void testRemove() {
        // Удаляем элемент из списка.
        setupInit();
        String item = "П";
        String result = stringList.remove(item);

        // Проверяем, что элемент был успешно удален.

        assertEquals(result, item);
    //    assertEquals(stringList.toString(), Arrays.toString(new String[]{"П", "р", "и", "в", "е", "т", " ", "м", "и", "р", "!"}));
    }

    @Test
    public void testRemoveAtIndex() {
        // Удаляем элемент по индексу из списка.
        setupInit();
        int index = 1;
        String result = stringList.remove(index);

        // Проверяем, что элемент был успешно удален.
        assertEquals(result, "р");
    }

    @Test
    public void testContains() {
        // Проверяем, содержит ли список определенный элемент.
        setupInit();
        String item = "П";
        boolean result = stringList.contains(item);

        // Проверяем, что список содержит указанный элемент.
        assertTrue(result);
    }

    @Test
    public void testIndexOf() {
        // Ищем индекс элемента в списке.
        setupInit();
        String item = "м";
        int result = stringList.indexOf(item);

        // Проверяем, что индекс элемента найден.
        assertTrue(result >= 0);
        assertEquals(stringList.indexOf("g"), -1);
    }

    @Test
    public void testLastIndexOf() {
        // Ищем индекс элемента с конца списка.
        setupInit();
        String item = "!";
        int result = stringList.lastIndexOf(item);

        // Проверяем, что индекс элемента найден.
        assertTrue(result >= 0);
        assertEquals(stringList.indexOf("g"), -1);
    }

    @Test
    public void testGet() {
        // Получаем элемент по индексу из списка.
        setupInit();
        int index = 0;
        String item = "П";
        String result = stringList.get(index);

        // Проверяем, что элемент получен.
        assertNotNull(result);
        assertEquals(result, item);
    }

    @Test
    public void testEquals() {
        // Создаем другой список для сравнения.
        StringList otherList = new CustomArrayList(10);

        // Сравниваем текущий список с другим.
        boolean result = stringList.equals(otherList);

        // Проверяем, что списки равны.
        assertTrue(result);
    }

    @Test
    public void testSize() {
        // Получаем фактическое количество элементов в списке.
        int result = stringList.size();

        // Проверяем, что количество элементов равно ожидаемому.
        assertEquals(0, result);
    }

    @Test
    public void testIsEmpty() {
        // Проверяем, пуст ли список.
        boolean result = stringList.isEmpty();

        // Проверяем, что список пуст.
        assertTrue(result);
    }

    @Test
    public void testClear() {
        // Очищаем список.
        stringList.clear();

        // Проверяем, что список пуст.
        assertTrue(stringList.isEmpty());
    }

    @Test
    public void testToArray() {
        // Создаем новый массив из элементов списка.
        String[] result = stringList.toArray();

        // Проверяем, что массив создан.
        assertNotNull(result);
    }

    private void setupInit() {
        stringList.add("П");
        stringList.add("р");
        stringList.add("и");
        stringList.add("в");
        stringList.add("е");
        stringList.add("т");
        stringList.add(" ");
        stringList.add("м");
        stringList.add("и");
        stringList.add("р");
        stringList.add("!");
    }
}