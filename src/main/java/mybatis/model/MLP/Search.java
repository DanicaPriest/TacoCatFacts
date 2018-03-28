package mybatis.model.MLP;

public class Search {
    int id;
    String created_at;
    String updated_at;
    String first_seen_at;
    int score;
    int comment_count;
    int width;
    int height;
    String file_name;
    String description;
    String uploader;
    int uploader_id;
    String image;
    int upvotes;
    int downvotes;
    int faves;
    String tags;
    double aspect_ratio;
    String original_format;
    String mime_type;
    String sha512_hash;
    String orig_sha512_hash;
    String source_url;
    Representations representations;
    boolean is_rendered;
    boolean is_optimized;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getFirst_seen_at() {
        return first_seen_at;
    }

    public void setFirst_seen_at(String first_seen_at) {
        this.first_seen_at = first_seen_at;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public int getUploader_id() {
        return uploader_id;
    }

    public void setUploader_id(int uploader_id) {
        this.uploader_id = uploader_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public int getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(int downvotes) {
        this.downvotes = downvotes;
    }

    public int getFaves() {
        return faves;
    }

    public void setFaves(int faves) {
        this.faves = faves;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public double getAspect_ratio() {
        return aspect_ratio;
    }

    public void setAspect_ratio(double aspect_ratio) {
        this.aspect_ratio = aspect_ratio;
    }

    public String getOriginal_format() {
        return original_format;
    }

    public void setOriginal_format(String original_format) {
        this.original_format = original_format;
    }

    public String getMime_type() {
        return mime_type;
    }

    public void setMime_type(String mime_type) {
        this.mime_type = mime_type;
    }

    public String getSha512_hash() {
        return sha512_hash;
    }

    public void setSha512_hash(String sha512_hash) {
        this.sha512_hash = sha512_hash;
    }

    public String getOrig_sha512_hash() {
        return orig_sha512_hash;
    }

    public void setOrig_sha512_hash(String orig_sha512_hash) {
        this.orig_sha512_hash = orig_sha512_hash;
    }

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }

    public Representations getRepresentations() {
        return representations;
    }

    public void setRepresentations(Representations representations) {
        this.representations = representations;
    }

    public boolean isIs_rendered() {
        return is_rendered;
    }

    public void setIs_rendered(boolean is_rendered) {
        this.is_rendered = is_rendered;
    }

    public boolean isIs_optimized() {
        return is_optimized;
    }

    public void setIs_optimized(boolean is_optimized) {
        this.is_optimized = is_optimized;
    }
}
