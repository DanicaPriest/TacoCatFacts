package mybatis.model;

public class ApiKeyException extends Exception {
    public ApiKeyException() {
        super("Api-Key does not match user");
    }
}
