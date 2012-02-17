package search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class PhraseGenerator {

    public static List<Phrase> generatePhrases(Phrase phrase) {
        List<Phrase> phrases = new ArrayList<Phrase>();
        LinkedList<String> body = phrase.getBody();
        Object[] words = body.toArray();
        for (Object word : words) {
            phrases.add(new Phrase(body));
            body.removeLast();
        }
        return phrases;
    }

    public static void main(String[] args) {


    }
}
