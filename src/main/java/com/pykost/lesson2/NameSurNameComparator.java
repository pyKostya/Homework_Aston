package com.pykost.lesson2;

import java.util.Comparator;

public class NameSurNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student obj1, Student obj2) {
        int result = obj1.getName().compareTo(obj2.getName());
        if (result == 0) {
            result = obj1.getSurName().compareTo(obj2.getSurName());
        }
        return result;
    }
}
