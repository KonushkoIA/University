import java.util.ArrayList;
import java.util.List;

public class AllStudent {
    private List<Student> allStudent;

    public AllStudent() {
    }

    public AllStudent(List<Student> allStudent) {
        this.allStudent = allStudent;
    }

    public List<Student> getAllStudent() {
        return allStudent;
    }

    public void setAllStudent(List<Student> allStudent) {
        this.allStudent = allStudent;
    }

    @Override
    public String toString() {
        return "AllStudent{" +
                "allStudent=" + allStudent +
                '}';
    }
}
