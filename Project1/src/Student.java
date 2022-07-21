import java.util.Comparator;

public class Student implements Comparator<Student> {

    public String name;

    public Student() {

    }

    public Student(String name) {
        this.name = name;
    }

    @Override
    public int compare(Student o1, Student o2) {
        if (o1 == null && o2 == null) {
            return 0;
        } else if (o1 == null && o2 != null) {
            return 1; // put o1 in the back of the array
        } else if (o1 != null && o2 == null) {
            return -1; // put o2 int the back of the arry
        } else {
            return o1.name.compareToIgnoreCase(o2.name);
        }
    }
}
