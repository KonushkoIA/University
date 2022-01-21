import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Group {
    private int id;
    private String groupName;
    private List<Student> studentList = new ArrayList<>();

    public Group() {
    }

    public Group(int id, String groupName, List<Student> studentList) {
        this.id = id;
        this.groupName = groupName;
        this.studentList = studentList;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", studentList=" + studentList +
                '}';
    }

    public static Group createGroup(int id, String name, List<Student> list) {
        Group group = new Group(id, name, list);
        try {
            GroupConverter.toJSON(group);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return group;
    }

    public static int groupRating(Group group) {
        int groupRating = 0;
        List<Student> list = group.getStudentList();
        List<Integer> studentsRating = new ArrayList<>();
        for (Student student : list) {
            int rating = Student.calculateRating(student);
            studentsRating.add(rating);
        }
        for (int a : studentsRating) {
            groupRating = groupRating + a;
        }
        groupRating = groupRating / studentsRating.size();
        return groupRating;
    }

    public static void sortByRating(Group group) {
        List<Student> studentsList = group.getStudentList();
        List<Student> studentsList1 = new ArrayList<>();
        for (Student student : studentsList) {
            Student.calculateRating(student);
            studentsList1.add(student);
        }
        List<Student> sortedStudentsList = studentsList1.stream()
                .sorted(Comparator.comparing(Student::getStudentRating))
                .collect(Collectors.toList());
        group.setStudentList(sortedStudentsList);
        try {
            SortedGroupConverter.toJSON(group);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
