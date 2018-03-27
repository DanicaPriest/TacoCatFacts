package mybatis.model.CatFacts;


public class All {
    String _id;
    String text;
    User user;
    Upvotes[] upvotes;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Upvotes[] getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Upvotes[] upvotes) {
        this.upvotes = upvotes;
    }
}
