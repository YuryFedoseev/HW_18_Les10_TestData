package guru.qa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestOpenFileJackson {

    ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

    @JsonIgnoreProperties(ignoreUnknown = true)

    @Test
    public void jsonOpen() throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("filesForLoading/lessonsList.json");
        File file = new File("src/test/resources/filesForLoading/lessonsList.json");
        InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream);
        JsonText jsonText = objectMapper.readValue(file, JsonText.class);
        System.out.println(jsonText);

    }

}
