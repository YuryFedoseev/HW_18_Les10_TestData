package guru.qa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestOpenFileJackson {
    //    Class cl;
//    @BeforeAll
//    static void beforeAll() {
    ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
//    cl = getClass().getClassLoader();}

    @JsonIgnoreProperties(ignoreUnknown = true)

    @Test
    public void jsonOpen() throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("filesForLoading/lessonsList.json");
        File file = new File("src/test/resources/filesForLoading/lessonsList.json");
        InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream);
        JsonText jsonText = objectMapper.readValue(file, JsonText.class);
        //(file, jsonText.getSendID());
        System.out.println(jsonText);


//        System.out.println(objectMapper);
//         (InputStream is = cl.getResourceAsStream("lessonsList.json");
//             InputStreamReader jsonRead = new InputStreamReader(is))
//         {
//             JsonText jsonText = objectMapper.readValue(jsonRead, JsonText.class);
//            Assertions.assertEquals("12", jsonText.getStudentId()));
//        }
        //       File file = new File("filesForLoading/lessonsList.json");
        //      ParserLibrary parserLibrary = mapper.readValue(isr, ParserLibrary.class);
        //      String json = objectMapper.writeValueAsString(file);
        //       System.out.println(json);

        //       String nameJson = objectMapper.writeValueAsString(file.getName());
        //       System.out.println(nameJson);
    }

}
