import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class UniversityConverter {

    private final static String baseFile = "university.json";

    public static void toJSON(University university) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), university);
        System.out.println("Университет записан");
    }

    public static University toJavaObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(baseFile), University.class);
    }
}