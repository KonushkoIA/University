import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    //public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("1. Подсчёт среднего рейтинга студента");
        System.out.println("2. Подсчёт среднего рейтинга группы");
        System.out.println("3. Подсчёт среднего рейтинга университета");
        System.out.println("4. Сортировать студентов в группе по рейтингу");
        System.out.println("5. Вывод всей информации");

        List<Integer> list = Arrays.asList(6,7,8);

        List<Integer> list1 = Arrays.asList(7,8,9);

        List<Integer> list2 = Arrays.asList(5,6,7);

        Student student1 = new Student("Andrey", 1, list);
        Student student2 = new Student("Ilya", 2, list1);
        Student student3 = new Student("Anna", 3, list2);

        List<Student> allStudentList = Arrays.asList(student1,student2,student3);
        AllStudent allStudent = new AllStudent(allStudentList);
        try {
            StudentConverter.toJSON(allStudent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        Group group1 = Group.createGroup(1,"First", studentList);
        Group.sortByRating(group1);

        int rating = Group.groupRating(group1);
        System.out.println("Рейтинг группы " + rating);

        List<Group> groupList = Arrays.asList(group1);
        University university1 = University.createUniversity(1,"BSMU", groupList);

        int rating1 = University.universityRating(university1);
        System.out.println( "Рейтинг универа " + rating1);

        University universityInfo = UniversityConverter.toJavaObject();
        System.out.println("Вся информация: " + universityInfo.toString());
    }
}
