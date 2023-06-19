package guru.qa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestOpenFileJackson {

    ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

    @JsonIgnoreProperties(ignoreUnknown = true)

    ClassLoader cl = TestOpenFileJackson.class.getClassLoader();
    @Test
    public void jsonOpen() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream is = cl.getResourceAsStream("filesForLoading/lessonsList.json");
             InputStreamReader isr = new InputStreamReader(is)) {
            JsonText text = objectMapper.readValue(isr, JsonText.class);

            Assertions.assertEquals(2, text.getStudentId());
        }

    }
}




