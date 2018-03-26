package mybatis.model.nyt;

public class NYTResponse {

    NYTDocs[] docs;
    NYTMeta meta;

    public NYTResponse() {

    }

    public NYTDocs[] getDocs() {
        return docs;
    }

    public void setDocs(NYTDocs[] docs) {
        this.docs = docs;
    }

    public NYTMeta getMeta() {
        return meta;
    }

    public void setMeta(NYTMeta meta) {
        this.meta = meta;
    }
}
