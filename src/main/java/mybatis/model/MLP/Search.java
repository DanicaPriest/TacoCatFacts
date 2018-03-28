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
    Tag_ids[] tag_ids;
    double aspect_ratio;
    String original_format;
    String mime_type;
    String sha512_hash;
    String orig_sha512_hash;
    String source_url;
    Representations representations;
    boolean is_rendered;
    boolean is_optimized;
}
