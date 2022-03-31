package sample.controller.Database;

import sample.controller.ClassesWorkingWithFXML.WindowPasswordRecovery2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;



public class DatabaseHandler extends Configs{
    Connection dbConnection;

    // подключение к бд
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString ="jdbc:oracle:thin:@localhost:1521:XE";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        dbConnection=DriverManager.getConnection(connectionString, dbUser,dbPass);
        return  dbConnection;

    }
    // метод вставляет текст в запрос вставки бд
    public void signUpUser( User user) {
        String insert = "insert into"+" "+Const.USER_TABLE+"("+Const.USER_LOGIN+","+Const.USER_PASS+","+Const.USER_NAME+","+Const.USER_SECONDNAME+","+Const.USER_QUESTION+","+Const.USER_ANSWER+")"+
                "values(?,?,?,?,?,?)";
        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(insert);
            prSt.setString(1,user.getLogin());
            prSt.setString(2,user.getPassword());
            prSt.setString(3,user.getName());
            prSt.setString(4,user.getSecond_name());
            prSt.setString(5,user.getQuestion());
            prSt.setString(6,user.getAnswer());
            prSt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    // медот для получения юзера
    public ResultSet getUser(User user){
        ResultSet resultSet=null;
        String select = "select * from "+Const.USER_TABLE+" where "+Const.USER_LOGIN+"=? and "+Const.USER_PASS+"=?";

        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(select);
            prSt.setString(1,user.getLogin());
            prSt.setString(2,user.getPassword());
            resultSet=prSt.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;

    }


    // медод для проверки на сущ юзера
    public ResultSet CheckUser(User user){
        ResultSet resultSet=null;
        String select = "select * from "+Const.USER_TABLE+" where "+Const.USER_LOGIN+"=?";

        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(select);
            prSt.setString(1,user.getLogin());
            resultSet=prSt.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;

    }

    // медод для получения вопроса пользователя
    public String  getSecretLogin(WindowPasswordRecovery2 login){
        ResultSet resultSet1=null;
        ResultSet resultSet2=null;
        String secret = null;
        String answer = null;
        String selectSecret = "select "+Const.USER_QUESTION+" from "+Const.USER_TABLE+" where "+Const.USER_LOGIN+"=?";
        String selectAnswer = "select "+Const.USER_ANSWER+" from "+Const.USER_TABLE+" where "+Const.USER_LOGIN+"=?";

        try {
            PreparedStatement prSt1=getDbConnection().prepareStatement(selectSecret);
            prSt1.setString(1,login.getLogin());
            resultSet1=prSt1.executeQuery();
            secret=resultSet1.toString();

            PreparedStatement prSt2=getDbConnection().prepareStatement(selectAnswer);
            prSt2.setString(1,login.getLogin());
            resultSet2=prSt2.executeQuery();
            answer=resultSet2.toString();
            System.out.println(secret);
            System.out.println(answer);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return secret;


    }


}
