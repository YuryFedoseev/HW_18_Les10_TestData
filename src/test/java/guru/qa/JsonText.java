package guru.qa;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class JsonText {
    private String teacher;
    private String sendID;
    private String lessonName;
    private Boolean lectureShown;
    private Boolean homeworkSubmittedState;
    private int numberLesson;
    private int studentId;
    private Object lessonField;
    private List<String> lessonList;

    public String getSendID() {
        return sendID;
    }

    public void setSendID(String sendID){
        this.sendID = sendID;
    }

    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId){
        this.studentId = studentId;
    }


}
