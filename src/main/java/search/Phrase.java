package search;

import java.util.LinkedList;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class Phrase {

    private LinkedList<String> body = new LinkedList<String>();
    private LinkedList<String> tail = new LinkedList<String>();

    public LinkedList<String> getBody() {
        return body;
    }

    public void setBody(LinkedList<String> body) {
        this.body = body;
    }

    public LinkedList<String> getTail() {
        return tail;
    }

    public void setTail(LinkedList<String> tail) {
        this.tail = tail;
    }
}
