package sample.controller.Database;
//класс для таблицы WorkingHours
public class WorkingHours {
    private String dateOfWork;
    private String program;
    private String time;

    public WorkingHours(String dateOfWork, String program, String time) {
        this.dateOfWork = dateOfWork;
        this.program = program;
        this.time = time;
    }

    public String getDateOfWork() {
        return dateOfWork;
    }

    public void setDateOfWork(String dateOfWork) {
        this.dateOfWork = dateOfWork;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
