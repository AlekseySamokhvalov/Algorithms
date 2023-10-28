package com.example.algorithms;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void testSet() {
        // Устанавливаем элемент на определенную позицию списка.
        String item = "H";
        int index = 1;
        String result = stringList.set(index, item);

        // Проверяем, что элемент был успешно установлен на указанную позицию.
        assertEquals(item, result);
    }

    @Test
    public void testRemove() {
        // Удаляем элемент из списка.
        String item = "Hello";
        String result = stringList.remove(item);

        // Проверяем, что элемент был успешно удален.
        assertEquals(item, result);
    }

    @Test
    public void testRemoveAtIndex() {
        // Удаляем элемент по индексу из списка.
        int index = 0;
        String result = stringList.remove(index);

        // Проверяем, что элемент был успешно удален.
        assertEquals("ello", result);//assertNotNull(result);
    }

    @Test
    public void testContains() {
        // Проверяем, содержит ли список определенный элемент.
        String item = "Hello";
        boolean result = stringList.contains(item);

        // Проверяем, что список содержит указанный элемент.
        assertTrue(result);
    }

    @Test
    public void testIndexOf() {
        // Ищем индекс элемента в списке.
        String item = "Hello";
        int result = stringList.indexOf(item);

        // Проверяем, что индекс элемента найден.
        assertTrue(result >= 0);
    }

    @Test
    public void testLastIndexOf() {
        // Ищем индекс элемента с конца списка.
        String item = "Hello";
        int result = stringList.lastIndexOf(item);

        // Проверяем, что индекс элемента найден.
        assertTrue(result >= 0);
    }

    @Test
    public void testGet() {
        // Получаем элемент по индексу из списка.
        int index = 0;
        String result = stringList.get(index);

        // Проверяем, что элемент получен.
        assertNotNull(result);
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
}