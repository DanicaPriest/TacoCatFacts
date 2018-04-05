package mybatis.Exceptions;

public class UserNullException extends Exception {
    public String toString(){
        return "user does not exist in the database";
    }
}
