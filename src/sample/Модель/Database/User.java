package sample.Модель.Database;

public class User {

    private String login;
    private String password;
    private String name;
    private String second_name;
    private String question;
    private String answer;


    public User( String login, String password, String name, String second_name, String question, String answer) {

        this.login = login;
        this.password = password;
        this.name = name;
        this.second_name = second_name;
        this.question = question;
        this.answer = answer;
    }

    public User() {

    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

}
