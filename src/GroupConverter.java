import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class GroupConverter {

    private final static String baseFile = "group.json";

    public static void toJSON(Group group) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), group);
        System.out.println("Группа записана");
    }

    public static Group toJavaObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(baseFile), Group.class);
    }
}