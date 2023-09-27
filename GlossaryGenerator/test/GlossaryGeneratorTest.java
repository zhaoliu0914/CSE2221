import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.map.Map;
import components.map.Map1L;
import components.queue.Queue;
import components.queue.Queue2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;

/**
 *
 * Test case for GlossaryGenerator.
 *
 * @author Zhao Liu
 *
 */
public class GlossaryGeneratorTest {

    @Test
    public void testConvertInputFileToQueue_1() {
        SimpleReader in = new SimpleReader1L("data/terms.txt");
        Queue<String> expectQueue = new Queue2<>();
        expectQueue.enqueue("meaning");
        expectQueue.enqueue(
                "something that one wishes to convey, especially by language");
        expectQueue.enqueue("");
        expectQueue.enqueue("term");
        expectQueue.enqueue("a word whose definition is in a glossary");
        expectQueue.enqueue("");
        expectQueue.enqueue("word");
        expectQueue.enqueue(
                "a string of characters in a language, which has at least one character");
        expectQueue.enqueue("");
        expectQueue.enqueue("definition");
        expectQueue.enqueue("a sequence of words that gives meaning to a term");
        expectQueue.enqueue("");
        expectQueue.enqueue("glossary");
        expectQueue.enqueue(
                "a list of difficult or specialized terms, with their definitions,");
        expectQueue.enqueue("usually near the end of a book");
        expectQueue.enqueue("");
        expectQueue.enqueue("language");
        expectQueue.enqueue(
                "a set of strings of characters, each of which has meaning");
        expectQueue.enqueue("");
        expectQueue.enqueue("book");
        expectQueue.enqueue("a printed or written literary work");

        Queue<String> resultQueue = GlossaryGenerator
                .convertInputFileToQueue(in);

        // close stream
        in.close();

        assertEquals(expectQueue, resultQueue);
    }

    @Test
    public void testAssemblyContentToMap_1() {
        Queue<String> contentQueue = new Queue2<>();
        contentQueue.enqueue("meaning");
        contentQueue.enqueue(
                "something that one wishes to convey, especially by language");
        contentQueue.enqueue("");
        contentQueue.enqueue("term");
        contentQueue.enqueue("a word whose definition is in a glossary");
        contentQueue.enqueue("");
        contentQueue.enqueue("word");
        contentQueue.enqueue(
                "a string of characters in a language, which has at least one character");
        contentQueue.enqueue("");
        contentQueue.enqueue("definition");
        contentQueue
                .enqueue("a sequence of words that gives meaning to a term");
        contentQueue.enqueue("");
        contentQueue.enqueue("glossary");
        contentQueue.enqueue(
                "a list of difficult or specialized terms, with their definitions,");
        contentQueue.enqueue("usually near the end of a book");
        contentQueue.enqueue("");
        contentQueue.enqueue("language");
        contentQueue.enqueue(
                "a set of strings of characters, each of which has meaning");
        contentQueue.enqueue("");
        contentQueue.enqueue("book");
        contentQueue.enqueue("a printed or written literary work");
        contentQueue.enqueue("");

        Map<String, String> expectMap = new Map1L<>();
        expectMap.add("meaning",
                "something that one wishes to convey, especially by language");
        expectMap.add("term", "a word whose definition is in a glossary");
        expectMap.add("word",
                "a string of characters in a language, which has at least one character");
        expectMap.add("definition",
                "a sequence of words that gives meaning to a term");
        String valueOfGlossary = "a list of difficult or specialized terms, "
                + "with their definitions," + "\n"
                + "usually near the end of a book";
        expectMap.add("glossary", valueOfGlossary);
        expectMap.add("language",
                "a set of strings of characters, each of which has meaning");
        expectMap.add("book", "a printed or written literary work");

        Map<String, String> resultMap = GlossaryGenerator
                .assemblyContentToMap(contentQueue);

        assertEquals(expectMap, resultMap);

    }

    @Test
    public void testReplaceTermToLinkForDefinition_1() {
        Queue<String> terms = new Queue2<>();
        terms.enqueue("meaning");
        terms.enqueue("term");
        terms.enqueue("word");
        terms.enqueue("definition");
        terms.enqueue("glossary");
        terms.enqueue("language");
        terms.enqueue("book");

        String definition = "something that one wishes to convey, especially by language";
        String expectDefinition = "something that one wishes to convey, "
                + "especially by <a href=\"language.html\">language</a>";

        String resultDefinition = GlossaryGenerator
                .replaceTermToLinkForDefinition(terms, definition);

        assertEquals(expectDefinition, resultDefinition);
    }

    @Test
    public void testReplaceTermToLinkForDefinition_2() {
        Queue<String> terms = new Queue2<>();
        terms.enqueue("meaning");
        terms.enqueue("term");
        terms.enqueue("word");
        terms.enqueue("definition");
        terms.enqueue("glossary");
        terms.enqueue("language");
        terms.enqueue("book");

        String definition = "a word whose definition is in a glossary";
        String expectDefinition = "a <a href=\"word.html\">word</a> "
                + "whose <a href=\"definition.html\">definition</a> is in a "
                + "<a href=\"glossary.html\">glossary</a>";

        String resultDefinition = GlossaryGenerator
                .replaceTermToLinkForDefinition(terms, definition);

        assertEquals(expectDefinition, resultDefinition);
    }

    @Test
    public void testReplaceTermToLinkForDefinition_3() {
        Queue<String> terms = new Queue2<>();
        terms.enqueue("meaning");
        terms.enqueue("term");
        terms.enqueue("word");
        terms.enqueue("definition");
        terms.enqueue("glossary");
        terms.enqueue("language");
        terms.enqueue("book");

        String definition = "a string of characters in a language, "
                + "which has at least one character";
        String expectDefinition = "a string of characters in a "
                + "<a href=\"language.html\">language</a>, "
                + "which has at least one character";

        String resultDefinition = GlossaryGenerator
                .replaceTermToLinkForDefinition(terms, definition);

        assertEquals(expectDefinition, resultDefinition);
    }

    @Test
    public void testReplaceTermToLinkForDefinition_4() {
        Queue<String> terms = new Queue2<>();
        terms.enqueue("meaning");
        terms.enqueue("term");
        terms.enqueue("word");
        terms.enqueue("definition");
        terms.enqueue("glossary");
        terms.enqueue("language");
        terms.enqueue("book");

        String definition = "a sequence of words that gives meaning to a term";
        String expectDefinition = "a sequence of words that gives "
                + "<a href=\"meaning.html\">meaning</a> to a "
                + "<a href=\"term.html\">term</a>";

        String resultDefinition = GlossaryGenerator
                .replaceTermToLinkForDefinition(terms, definition);

        assertEquals(expectDefinition, resultDefinition);
    }

    @Test
    public void testReplaceTermToLinkForDefinition_5() {
        Queue<String> terms = new Queue2<>();
        terms.enqueue("meaning");
        terms.enqueue("term");
        terms.enqueue("word");
        terms.enqueue("definition");
        terms.enqueue("glossary");
        terms.enqueue("language");
        terms.enqueue("book");

        String definition = "a list of difficult or specialized terms, "
                + "with their definitions," + "\n"
                + "usually near the end of a book";
        String expectDefinition = "a list of difficult or specialized terms, "
                + "with their definitions," + "\n"
                + "usually near the end of a <a href=\"book.html\">book</a>";

        String resultDefinition = GlossaryGenerator
                .replaceTermToLinkForDefinition(terms, definition);

        assertEquals(expectDefinition, resultDefinition);
    }

    @Test
    public void testReplaceTermToLinkForDefinition_6() {
        Queue<String> terms = new Queue2<>();
        terms.enqueue("meaning");
        terms.enqueue("term");
        terms.enqueue("word");
        terms.enqueue("definition");
        terms.enqueue("glossary");
        terms.enqueue("language");
        terms.enqueue("book");

        String definition = "a set of strings of characters, each of which has meaning";
        String expectDefinition = "a set of strings of characters, "
                + "each of which has <a href=\"meaning.html\">meaning</a>";

        String resultDefinition = GlossaryGenerator
                .replaceTermToLinkForDefinition(terms, definition);

        assertEquals(expectDefinition, resultDefinition);
    }

    @Test
    public void testReplaceTermToLinkForDefinition_7() {
        Queue<String> terms = new Queue2<>();
        terms.enqueue("meaning");
        terms.enqueue("term");
        terms.enqueue("word");
        terms.enqueue("definition");
        terms.enqueue("glossary");
        terms.enqueue("language");
        terms.enqueue("book");

        String definition = "a printed or written literary work";
        String expectDefinition = "a printed or written literary work";

        String resultDefinition = GlossaryGenerator
                .replaceTermToLinkForDefinition(terms, definition);

        assertEquals(expectDefinition, resultDefinition);
    }

}
