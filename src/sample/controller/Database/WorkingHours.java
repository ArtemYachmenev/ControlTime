package sample.controller.Database;

import javafx.scene.control.TableColumn;

//класс для таблицы WorkingHours
public class WorkingHours {
    private String date;
    private String program;
    private String time;

    public WorkingHours(String date, String program, String time) {
        this.date = date;
        this.program = program;
        this.time = time;
    }

   // public WorkingHours(TableColumn<WorkingHours, String> date, TableColumn<WorkingHours, String> program, TableColumn<WorkingHours, String> time) {
   // }



    public String getDate() {
        return date;
    }

    public void setDateOfWork(String dateOfWork) {
        this.date = dateOfWork;
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
