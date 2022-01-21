import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class StudentConverter {

    private final static String baseFile = "AllStudent.json";

    public static void toJSON(AllStudent student) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), student);
        System.out.println("Список всех студентов создан");
    }

    public static Student toJavaObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(baseFile), Student.class);
    }
}
