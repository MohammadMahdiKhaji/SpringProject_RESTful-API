package ir.webapp.springprojectapi.controller.app.exceptionwrapper;

import java.sql.SQLDataException;
import java.sql.SQLException;

public class ExceptionWrapper {

    public String getMessage(Exception e){
        if(e instanceof SQLException){
            return "error in sql\n" + e.getMessage();
        }else if (e instanceof ArithmeticException){
            return "error in calculation\n" + e.getMessage();
        }else if(e instanceof SQLDataException){
            return "error in sql(data)\n" + e.getMessage();
        }else if(e instanceof ClassNotFoundException){
            return "error in class\n" + e.getMessage();
        }
        else{
            return "Unknown Error - call admin\n" + e.getMessage();
        }
    }
}
