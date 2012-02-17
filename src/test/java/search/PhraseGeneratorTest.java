package search;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class PhraseGeneratorTest {

    @Test
    public void testAll() {
        List<String> words = new ArrayList<String>();
        words.add("The");
        words.add("Best");
        words.add("Film");
        Phrase phrase = new Phrase(words);
        Assert.assertEquals(PhraseGenerator.generatePhrases(phrase).size(), 3);

    }
}
