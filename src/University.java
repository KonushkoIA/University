import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class University {
    private int id;
    private String universityName;
    private List<Group> groupList = new ArrayList<>();

    public University() {
    }

    public University(int id, String universityName, List<Group> groupList) {
        this.id = id;
        this.universityName = universityName;
        this.groupList = groupList;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", universityName='" + universityName + '\'' +
                ", groupList=" + groupList +
                '}';
    }

    public static University createUniversity(int id, String name, List<Group> list) {
        University university = new University(id, name, list);
        try {
            UniversityConverter.toJSON(university);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return university;
    }

    public static int universityRating(University university) {

        int universityRating = 0;
        List<Group> listGroup = university.getGroupList();
        for (Group group : listGroup){
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
            universityRating = universityRating + groupRating;
        }
        universityRating = universityRating / listGroup.size();
        return universityRating;
    }
}
