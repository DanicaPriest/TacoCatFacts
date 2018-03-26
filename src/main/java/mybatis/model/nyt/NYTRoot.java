package mybatis.model.nyt;

public class NYTRoot {
    String status;
    String copyright;
    NYTResponse response;

    public NYTRoot() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public NYTResponse getResponse() {
        return response;
    }

    public void setResponse(NYTResponse response) {
        this.response = response;
    }
}
