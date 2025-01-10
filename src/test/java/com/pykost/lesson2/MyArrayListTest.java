package com.pykost.lesson2;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    MyArrayList<Student> list = new MyArrayList<>();
    Student student1 = new Student(1, "Константин", "Пышков");
    Student student2 = new Student(2, "Александр", "Моисеев");
    Student student3 = new Student(3, "Наталья", "Гущина");
    Student student4 = new Student(4, "Галина", "Пушкина");
    Student student5 = new Student(5, "Елена", "Пышкова");
    Student student6 = new Student(6, "Елена", "Косолапова");


    @Test
    void add() {
        list.add(student1);
        list.add(student6);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        list.add(student2);
        assertEquals(list.size(), 6);
        assertEquals(list.get(0), student1);
        assertEquals(list.get(3), student4);
        assertEquals(list.get(5), student2);
    }

    @Test
    void testAdd() {
        for (int i = 0; i < 100; i++) {
            list.add(student1);
        }
        list.add(50, student5);
        assertEquals(list.get(50), student5);
        assertEquals(list.get(75), student1);
    }

    @Test
    void get() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                list.add(student1);
            }
            list.add(student2);
        }
        assertEquals(list.get(45), student1);
        assertEquals(list.get(88), student2);

    }

    @Test
    void remove() {
        for (int i = 0; i < 1_000; i++) {
            list.add(student4);
        }
        list.remove(100);
        list.add(student1);
        list.remove(200);
        list.add(student2);
        list.remove(179);
        list.add(student3);
        list.remove(999);
        assertEquals(list.size(), 999);

    }

    @Test
    void clear() {
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        list.add(student6);
        list.clear();
        assertEquals(list.size(), 0);
    }

    @Test
    void sort() {
        list.add(student6);
        list.add(student3);
        list.add(student1);
        list.add(student5);
        list.add(student4);
        list.add(student2);
        list.sort(new StudentComparator.byNameAndSurname());
        assertEquals(list.get(0), student2);
        assertEquals(list.get(1), student4);
        assertEquals(list.get(2), student6);
        assertEquals(list.get(3), student5);
        assertEquals(list.get(4), student1);
        assertEquals(list.get(5), student3);
    }

    @Test
    void size() {
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.remove(2);
        assertEquals(list.size(), 2);
        list.add(student3);
        assertEquals(list.size(), 3);

    }

    @Test
    void set() {
        list.add(student1);
        list.add(student2);
        list.set(0, student5);
        list.add(student3);
        list.add(student4);
        list.add(2, list.get(3));
        assertEquals(list.get(0), student5);
        assertEquals(list.get(1), student2);
        assertEquals(list.get(2), student4);
        assertEquals(list.size(), 5);

    }
}