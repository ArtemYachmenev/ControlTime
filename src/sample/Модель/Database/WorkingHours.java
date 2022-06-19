package sample.Модель.Database;

import java.sql.Date;

//класс для таблицы WorkingHours
public class WorkingHours {
    private Date date;
    private String dateString;
    private String working_hours;
    private String program;
    private String time;

    public WorkingHours(Date date,String working_hours, String program, String time) {
        this.date = date;
        this.working_hours=working_hours;
        this.program = program;
        this.time = time;
    }
    public WorkingHours(Date date, String program, String time) {
        this.date = date;

        this.program = program;
        this.time = time;
    }
    public WorkingHours(String dateString,String working_hours, String program, String time) {
        this.dateString = dateString;
        this.working_hours=working_hours;
        this.program = program;
        this.time = time;
    }

   // public WorkingHours(TableColumn<WorkingHours, String> date, TableColumn<WorkingHours, String> program, TableColumn<WorkingHours, String> time) {
   // }


    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public Date getDate() {
        return date;
    }

    public String getWorking_hours() {
        return working_hours;
    }

    public void setWorking_hours(String working_hours) {
        this.working_hours = working_hours;
    }

    public void setDateOfWork(Date dateOfWork) {
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
