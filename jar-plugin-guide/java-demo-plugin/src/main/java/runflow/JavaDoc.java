package runflow;

import top.myrest.myflow.db.AutoIncrementDoc;

public class JavaDoc extends AutoIncrementDoc {

    private String value;

    private String content;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
