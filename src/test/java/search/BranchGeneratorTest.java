package search;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class BranchGeneratorTest {
    @Test
    public void testReceiveLeaves() throws Exception {
        List<String> words = new ArrayList<String>();
        words.add("The");
        words.add("Best");
        words.add("Film");
        Phrase phrase = new Phrase();
        phrase.copyTail(words);
        BranchElement root = new BranchElement(null);
        root.setValue(phrase);
        List<BranchElement> leaves = BranchGenerator.receiveLeaves(root);
        Assert.assertEquals(leaves.size(), 0);
        BranchElement firstChild = new BranchElement(root);
        root.getChildren().add(firstChild);
        Assert.assertEquals(BranchGenerator.receiveLeaves(root).size(), 1);
        BranchElement secondChild = new BranchElement(root);
        root.getChildren().add(secondChild);
        Assert.assertEquals(BranchGenerator.receiveLeaves(root).size(), 2);
        BranchElement subChild = new BranchElement(firstChild);
        firstChild.getChildren().add(subChild);
        Assert.assertEquals(BranchGenerator.receiveLeaves(root).size(), 2);

    }
}
