package mybatis.model.nyt;

public class NYTDocs {
    String web_url;
    String snippet;
    //Blog blog;
    String source;
    Multimedia[] multimedia;
    Headline headline;
    Keywords[] keywords;
    String pub_date;
    String document_type;
    String new_desk;
    String section_name;
    Byline byline;
    String type_of_material;
    String _id;
    int word_count;
    double score;
    String uri;

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Multimedia[] getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(Multimedia[] multimedia) {
        this.multimedia = multimedia;
    }

    public Headline getHeadline() {
        return headline;
    }

    public void setHeadline(Headline headline) {
        this.headline = headline;
    }

    public Keywords[] getKeywords() {
        return keywords;
    }

    public void setKeywords(Keywords[] keywords) {
        this.keywords = keywords;
    }

    public String getPub_date() {
        return pub_date;
    }

    public void setPub_date(String pub_date) {
        this.pub_date = pub_date;
    }

    public String getDocument_type() {
        return document_type;
    }

    public void setDocument_type(String document_type) {
        this.document_type = document_type;
    }

    public String getNew_desk() {
        return new_desk;
    }

    public void setNew_desk(String new_desk) {
        this.new_desk = new_desk;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public Byline getByline() {
        return byline;
    }

    public void setByline(Byline byline) {
        this.byline = byline;
    }

    public String getType_of_material() {
        return type_of_material;
    }

    public void setType_of_material(String type_of_material) {
        this.type_of_material = type_of_material;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getWord_count() {
        return word_count;
    }

    public void setWord_count(int word_count) {
        this.word_count = word_count;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
