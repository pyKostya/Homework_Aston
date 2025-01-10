package com.pykost.lesson2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQuickSortTest {
    MyArrayList<Student> list = new MyArrayList<>();
    Student student1 = new Student(1, "Константин", "Пышков");
    Student student2 = new Student(2, "Александр", "Моисеев");
    Student student3 = new Student(3, "Наталья", "Гущина");
    Student student4 = new Student(4, "Галина", "Пушкина");
    Student student5 = new Student(5, "Елена", "Пышкова");
    Student student6 = new Student(6, "Елена", "Косолапова");
    @Test
    @DisplayName("Тестовая сортировка списка в естественном порядке (по id)")
    void quickSortNaturalOrder() {
        list.add(student1);
        list.add(student6);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        list.add(student2);
        MyQuickSort.quickSort(list);
        assertEquals(list.get(0), student1);
        assertEquals(list.get(1), student2);
        assertEquals(list.get(2), student3);
        assertEquals(list.get(3), student4);
        assertEquals(list.get(4), student5);
        assertEquals(list.get(5), student6);
    }

    @Test
    @DisplayName("Тестовая сортировка списка по имени и фамилии")
    void quickSortByNameAndSurname() {
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        list.add(student6);
        MyQuickSort.quickSort(list, new StudentComparator.byNameAndSurname());
        assertEquals(list.get(0), student2);
        assertEquals(list.get(1), student4);
        assertEquals(list.get(2), student6);
        assertEquals(list.get(3), student5);
        assertEquals(list.get(4), student1);
        assertEquals(list.get(5), student3);
    }
}