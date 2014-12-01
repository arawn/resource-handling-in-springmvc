package demo.model;

/**
 * @author Arawn Park
 */
public class Session {

    private String title;
    private String content;
    private String speaker;

    public Session(String title, String content, String speaker) {
        this.title = title;
        this.content = content;
        this.speaker = speaker;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getSpeaker() {
        return speaker;
    }

}
