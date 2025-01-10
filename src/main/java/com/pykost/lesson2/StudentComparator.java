package com.pykost.lesson2;

import java.util.Comparator;

public class StudentComparator {
    public static class byName implements Comparator<Student> {
        @Override
        public int compare(Student obj1, Student obj2) {
            return obj1.getName().compareTo(obj2.getName());
        }
    }

    public static class byNameAndSurname implements Comparator<Student> {
        @Override
        public int compare(Student obj1, Student obj2) {
            int result = obj1.getName().compareTo(obj2.getName());
            if (result == 0) {
                result = obj1.getSurname().compareTo(obj2.getSurname());
            }
            return result;
        }
    }
}
