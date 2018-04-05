package mybatis.Exceptions;

public class ApiKeyException extends Exception {
    public String toString(){
        return "Api-Key does not match user";
    }


}
