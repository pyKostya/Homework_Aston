package com.pykost.lesson2;


public class Main {
    public static void main(String[] args) {
        MyArrayList<Student> list = new MyArrayList<>();
        Student student1 = new Student(1, "Константин", "Пышков");
        Student student2 = new Student(2, "Александр", "Моисеев");
        Student student3 = new Student(3, "Наталья", "Гущина");
        Student student4 = new Student(4, "Галина", "Пушкина");
        Student student5 = new Student(5, "Елена", "Пышкова");
        Student student6 = new Student(6, "Елена", "Косолапова");
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        list.add(student6);

        list.sort(new NameSurNameComparator());
        System.out.println(list);
        MyQuickSort.quickSort(list);
        System.out.println(list);

    }
}
