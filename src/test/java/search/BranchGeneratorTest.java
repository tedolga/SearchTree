package search;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class BranchGeneratorTest {
    private List<String> words = new ArrayList<String>();
    private BranchElement root;

    @Before
    public void setUp() {
        root = new BranchElement(null);
        Phrase phrase = new Phrase();
        words.add("The");
        words.add("Best");
        words.add("Film");
        phrase.setTail(BranchGenerator.copyList(words));
        root.setValue(phrase);

    }

    @Test
    public void testReceiveLeaves() throws Exception {
        List<BranchElement> leaves = BranchGenerator.receiveLeaves(root);
        Assert.assertEquals(leaves.size(), 1);
        BranchElement firstChild = new BranchElement(root);
        Assert.assertEquals(BranchGenerator.receiveLeaves(root).size(), 1);
        BranchElement secondChild = new BranchElement(root);
        Assert.assertEquals(BranchGenerator.receiveLeaves(root).size(), 2);
        BranchElement subChild = new BranchElement(firstChild);
        Assert.assertEquals(BranchGenerator.receiveLeaves(root).size(), 2);
        BranchElement secondSubChild = new BranchElement(secondChild);
        Assert.assertEquals(BranchGenerator.receiveLeaves(root).size(), 2);
        BranchElement lastSubChild = new BranchElement(secondSubChild);
        Assert.assertEquals(BranchGenerator.receiveLeaves(root).size(), 2);
        BranchElement theLatestSubChild = new BranchElement(secondSubChild);
        Assert.assertEquals(BranchGenerator.receiveLeaves(root).size(), 3);
    }

    @Test
    public void testCheckLLeaves() {
        List<BranchElement> leaves = BranchGenerator.receiveLeaves(root);
        Assert.assertFalse(BranchGenerator.checkLeaves(leaves));
        Phrase secondPhrase = new Phrase();
        words.add("The");
        words.add("Best");
        words.add("Film");
        secondPhrase.setBody(BranchGenerator.copyList(words));
        BranchElement child = new BranchElement(root);
        child.setValue(secondPhrase);
        leaves = BranchGenerator.receiveLeaves(root);
        Assert.assertTrue(BranchGenerator.checkLeaves(leaves));
    }

    @Test
    public void testGenerateBranches() {
        BranchGenerator.generateBranches(root);
        Assert.assertEquals(3, root.getChildren().size());
        Assert.assertEquals(4, BranchGenerator.receiveLeaves(root).size());
    }


}
