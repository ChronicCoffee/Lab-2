package exercise1;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        // First, compare by age
        if (s1.getAge() < s2.getAge()) {
            return -1; // s1 is younger than s2
        } else if (s1.getAge() > s2.getAge()) {
            return 1; // s1 is older than s2
        } else {
            // If ages are equal, compare by name
            return s1.getName().compareTo(s2.getName());
        }
    }
}