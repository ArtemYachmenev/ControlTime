package sample.controller.Database;

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
    public ResultSet  getSecretLogin(User login){
        getAnswer(login);
        ResultSet resultSet=null;
        String selectSecret = "select "+Const.USER_QUESTION+" from "+Const.USER_TABLE+" where "+Const.USER_LOGIN+"=?";
        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(selectSecret);
            prSt.setString(1,login.getLogin());
            resultSet=prSt.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resultSet;

    }

//получение ответа на вопрос
    public ResultSet  getAnswer(User login){
        ResultSet resultSet=null;
        String selectAnswer = "select "+Const.USER_ANSWER+" from "+Const.USER_TABLE+" where "+Const.USER_LOGIN+"=?";

        try {

            PreparedStatement prSt=getDbConnection().prepareStatement(selectAnswer);
            prSt.setString(1,login.getLogin());
            resultSet=prSt.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;

    }

    // медот для получения юзера
    public void newPass(User user){

        String select = "update "+Const.USER_TABLE+" set "+Const.USER_PASS+"= ?"+" where "+Const.USER_LOGIN+" =?";
        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(select);
            prSt.setString(1,user.getPassword());
            prSt.setString(2,user.getLogin());
            prSt.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    //берем новый цвет шапки
    public ResultSet getColorUp(int number){
        ResultSet resultSetUp=null;

        String selectColorUp = "select "+Const.BACKGROUNDCOLOR_CODEUP+" from "+Const.BACKGROUNDCOLOR_TABLE+" where "+Const.BACKGROUNDCOLOR_ID+" ="+number;
        try {
            PreparedStatement prStUp=getDbConnection().prepareStatement(selectColorUp);

            prStUp.executeQuery();

            resultSetUp=prStUp.executeQuery();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resultSetUp;
    }

    //берем новый цвет центра
    public ResultSet getColorDown(int number){
        ResultSet resultSetDown=null;

        String selectColorDown = "select "+Const.BACKGROUNDCOLOR_CODEDOWN+" from "+Const.BACKGROUNDCOLOR_TABLE+" where "+Const.BACKGROUNDCOLOR_ID+" ="+number;
        try {
            PreparedStatement prStDown=getDbConnection().prepareStatement(selectColorDown);


            prStDown.executeQuery();
            resultSetDown=prStDown.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resultSetDown;
    }


//    public ResultSet getNewColor(){
//
//
//    }


}
