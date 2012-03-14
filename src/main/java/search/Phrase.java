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

    public LinkedList copyBody() {
        LinkedList<String> newBody = new LinkedList<String>();
        for (String next : body) {
            newBody.add(next);
        }
        return newBody;
    }

    public LinkedList copyTail() {
        LinkedList<String> newTail = new LinkedList<String>();
        for (String next : tail) {
            newTail.add(next);
        }
        return newTail;
    }

    public LinkedList<String> getTail() {
        return tail;
    }

    public void setTail(LinkedList<String> tail) {
        this.tail = tail;
    }
}
