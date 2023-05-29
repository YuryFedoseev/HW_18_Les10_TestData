package guru.qa;

import com.codeborne.pdftest.PDF;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOpenFile {

    private final ClassLoader cl = this.getClass().getClassLoader();

    @Test
    public void pdfOpenForZip() throws Exception {
        try (InputStream is = cl.getResourceAsStream("filesForLoading/filesForLoading.zip");
             ZipInputStream zs = new ZipInputStream(is, Charset.forName("CP866"))) {
            ZipEntry entry;
            while ((entry = zs.getNextEntry()) != null) {
                if (entry.getName().contains(".pdf")) {
                    PDF pdf = new PDF(zs);
                    String pdfText = "Sara, Luca Bianchi, Mauro";

                    Assertions.assertTrue(pdf.text.contains(pdfText));
                    System.out.println("pdf содержит текст: " + pdfText + "\n");
                    System.out.print("Длина: " + pdf.text.length() + "\n");
                }
            }
        }
    }

    @Test
    public void xlsxOpenForZip() throws Exception {
        try (InputStream is = cl.getResourceAsStream("filesForLoading/filesForLoading.zip");
             ZipInputStream zs = new ZipInputStream(is, Charset.forName("CP866"))) {
            ZipEntry entry;
            while ((entry = zs.getNextEntry()) != null) {
                if (entry.getName().contains(".xlsx")) {

                    String xlsxName = "ExelFile.xlsx";
                    assertEquals(xlsxName, entry.getName());
                }
            }
        }
    }

    @Test
    public void csvOpenForZip() throws Exception {
        try (InputStream is = cl.getResourceAsStream("filesForLoading/filesForLoading.zip");
             ZipInputStream zs = new ZipInputStream(is, Charset.forName("CP866"))) {
            ZipEntry entry;
            while ((entry = zs.getNextEntry()) != null) {
                if (entry.getName().contains(".csv")) {
                    String csvName = "Table.csv";

                    CSVReader csv = new CSVReader(new InputStreamReader(is));
                    List<String[]> csvRow = csv.readAll();
                    assertEquals(csvName, entry.getName());
                    Assertions.assertTrue(entry.getName().contains("Table.csv"));
                }
            }
        }
    }
}
