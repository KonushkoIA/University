import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private int id;
    private List<Integer> numbersList = new ArrayList<>();
    private int studentRating;

    public Student() {
    }

    public Student(String name, int id, List<Integer> list) {
        this.name = name;
        this.id = id;
        this.numbersList = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getListNumber() {
        return numbersList;
    }

    public void setListNumber(List<Integer> listNumber) {
        this.numbersList = listNumber;
    }

    public int getStudentRating() {
        return studentRating;
    }

    public void setStudentRating(int studentRating) {
        this.studentRating = studentRating;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", numbersList=" + numbersList +
                ", studentRating=" + studentRating +
                '}';
    }

    public static int calculateRating(Student student) {
        int value = 0;
        for (int a : student.getListNumber()) {
            value = value + a;
        }
        value = value / student.getListNumber().size();
        student.setStudentRating(value);
        return student.getStudentRating();
    }
}
