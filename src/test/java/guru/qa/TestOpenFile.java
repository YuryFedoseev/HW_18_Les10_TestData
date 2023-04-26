package guru.qa;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.google.common.io.Files;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestOpenFile {

    private ClassLoader cl = this.getClass().getClassLoader();

    @Test
    public void csvOpenForZip() throws Exception {
        try (InputStream is = cl.getResourceAsStream("filesForLoading.zip");
             ZipInputStream zs = new ZipInputStream(is)){
                 ZipEntry entry;
                 while ((entry = zs.getNextEntry()) !=null){
                     Assertions.assertEquals("Table.csv", entry.getName());

                 }
             }
    }

    @Test
    public void xlsxOpenForZip() throws Exception{

    }

    @Test
    public void pdfOpenForZip() throws Exception{

    }


}
