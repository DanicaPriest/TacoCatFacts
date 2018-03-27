package mybatis.model.nyt.internal;

public class NYTOverview {
    String headline;
    String imageUrl;
    String summary;
    String date;

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getImageurl() {
        return imageUrl;
    }

    public void setImageurl(String imageurl) {
        this.imageUrl = imageurl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
