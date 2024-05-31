package UINFO.Forum;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CommentCell {
    private final String username;
    private final String comment;
    private final IntegerProperty likes;
    private String forum;

    public CommentCell(String username, String comment, int likes) {
        this.username = username;
        this.comment = comment;
        this.likes = new SimpleIntegerProperty(likes);
        // this.forum = forum;
    }

    public String getKampus() {
        return forum;
    }

    public String getUsername() {
        return username;
    }

    public String getComment() {
        return comment;
    }

    public int getLikes() {
        return likes.get();
    }

    public IntegerProperty likesProperty() {
        return likes;
    }

    public void incrementLikes() {
        this.likes.set(this.likes.get() + 1);
    }
}