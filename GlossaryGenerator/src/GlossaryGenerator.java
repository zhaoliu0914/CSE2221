import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;

import components.map.Map;
import components.map.Map.Pair;
import components.map.Map1L;
import components.queue.Queue;
import components.queue.Queue2;
import components.set.Set;
import components.set.Set2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Generating a glossary based on a input file. To be specialize, the program
 * will ask user to enter the name of input file, and the folder of output files
 * which are a group of HTML files.
 *
 * @author Zhao Liu
 *
 */
public final class GlossaryGenerator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private GlossaryGenerator() {
    }

    /**
     * Compare {@code String}s in lexicographic order.
     */
    private static class StringLT implements Comparator<String>, Serializable {
        private static final long serialVersionUID = 1L;

        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

    /**
     * Simply, read all the lines in the file and then re-store at a Queue.
     *
     * @param inputFile
     *            from user enter
     * @return the Queue with all the lines from file.
     */
    public static Queue<String> convertInputFileToQueue(
            SimpleReader inputFile) {
        assert inputFile != null : "Violation of: inputFile is not null";
        assert inputFile.isOpen() : "Violation of: inputFile is not open";

        Queue<String> contents = new Queue2<>();

        String line;
        while (!inputFile.atEOS()) {
            line = inputFile.nextLine();
            contents.enqueue(line);
        }

        return contents;
    }

    /**
     *
     * The first line is the term. The next line or more lines are definition.
     * different terms and definitions are terminated by an empty line.
     *
     * this method will analyze this logic and then re-store matched lines into
     * a map.
     *
     * @param contents
     *            a Queue contains all the lines from file
     * @return a map, key is term and value is definition
     */
    public static Map<String, String> assemblyContentToMap(
            Queue<String> contents) {
        assert contents != null : "Violation of: contents is not null";

        Map<String, String> contentMap = new Map1L<>();

        // copy contents into tempContents
        Queue<String> tempContents = contents.newInstance();
        for (String temp : contents) {
            tempContents.enqueue(temp);
        }

        // store term and definition into a map.
        // the key is term and the value is definition in the map.
        while (tempContents.length() > 0) {
            String term = tempContents.dequeue();

            String definition = "";
            while (tempContents.length() > 0
                    && !tempContents.front().isBlank()) {
                if (definition.isBlank()) {
                    definition = tempContents.dequeue();
                } else {
                    definition = definition + "\n" + tempContents.dequeue();
                }
            }

            if (tempContents.length() > 0) {
                tempContents.dequeue();
            }

            contentMap.add(term, definition);
        }

        return contentMap;
    }

    /**
     * There are two types of HTML files which need to be output.
     *
     * First one is index.html. This index.html contains all the terms which
     * display in alphabetical order and also has a link to individual term
     * page.
     *
     * The second type of HTML file is individual term pages. In addition to
     * this, the definition also has a link take user to the page for that term
     * which display in the index.html.
     *
     * @param terms
     *            all the terms from input file
     * @param contentMap
     *            key is term and value is definition
     * @param outputFolder
     *            a path from user enter
     */
    public static void writeTermsToHTML(Queue<String> terms,
            Map<String, String> contentMap, String outputFolder) {
        assert terms != null : "Violation of: terms is not null";
        assert contentMap != null : "Violation of: contentMap is not null";
        //assert outputWriter != null : "Violation of: outputWriter is not null";
        //assert outputWriter.isOpen() : "Violation of: outputWriter is not open";

        // output index.html
        SimpleWriter indexWriter = new SimpleWriter1L(
                outputFolder + "/index.html");

        indexWriter.println("<html>");
        indexWriter.println("<head>");
        indexWriter.println("<title>Glossary - Test</title>");
        indexWriter.println("</head>");
        indexWriter.println("<body>");
        indexWriter.println("<h2>Glossary - Test</h2>");
        indexWriter.println("<hr />");
        indexWriter.println("<h3>Index</h3>");
        indexWriter.println("<ul>");
        for (String term : terms) {
            indexWriter.println(
                    "<li><a href=\"" + term + ".html\">" + term + "</a></li>");
        }
        indexWriter.println("</ul");
        indexWriter.println("</body>");
        indexWriter.println("</html>");
        indexWriter.println("");
        indexWriter.println("");
        indexWriter.println("");
        indexWriter.println("");
        indexWriter.println("");
        indexWriter.println("");
        indexWriter.println("");

        // output individual term HTML file
        for (String term : terms) {
            SimpleWriter termWriter = new SimpleWriter1L(
                    outputFolder + "/" + term + ".html");

            String definition = contentMap.value(term);

            definition = replaceTermToLinkForDefinition(terms, definition);

            termWriter.println("<html>");
            termWriter.println("<head>");
            termWriter.println("<title>" + term + "</title>");
            termWriter.println("</head>");
            termWriter.println("<body>");
            termWriter.println("<h2><b><i><font color=\"red\">" + term
                    + "</font></i></b></h2>");
            termWriter.println("<blockquote>");
            termWriter.println(definition);
            termWriter.println("</blockquote>");
            termWriter.println("<hr />");
            termWriter.println(
                    "<p>Return to <a href=\"index.html\">index</a>.</p>");
            termWriter.println("</body>");
            termWriter.println("</html>");

            termWriter.close();
        }

        indexWriter.close();
    }

    /**
     * Replace every terms in the definition into a link style.
     *
     * For example, a link style means <a href="meaning.html">meaning</a>
     *
     * @param terms
     *            all the terms which are display on the index page
     * @param definition
     *            the original definition
     * @return all the terms in the definition should replace to the a link
     *         style.
     */
    public static String replaceTermToLinkForDefinition(Queue<String> terms,
            String definition) {
        assert terms != null : "Violation of: terms is not null";
        assert definition != null : "Violation of: definition is not null";

        final String separatorStr = "\n, \t";
        String tempDefinition = definition;

        // convert input terms into tempTerms which is Set.
        Set<String> tempTerms = new Set2<>();
        for (String term : terms) {
            tempTerms.add(term);
        }

        Queue<String> assemblyQueue = new Queue2<>();
        assemblyQueue.enqueue(tempDefinition);

        // split the definition based on the separator.
        // every element in the Queue is a single word.
        for (int i = 0; i < separatorStr.length(); i++) {
            char separatorChar = separatorStr.charAt(i);
            String separator = String.valueOf(separatorChar);

            Queue<String> tempQueue = new Queue2<>();

            for (String segment : assemblyQueue) {
                String[] tokens = segment.split(separator);

                // check for is separator and last char in segment are same.
                // if they are same, it should add this separator to the Queue.
                boolean isSeparLastSame = false;
                if (segment.length() >= 1) {
                    char lastCharSegment = segment.charAt(segment.length() - 1);
                    if (separatorChar == lastCharSegment) {
                        isSeparLastSame = true;
                    }
                }

                for (int tokenIndex = 0; tokenIndex < tokens.length; tokenIndex++) {
                    tempQueue.enqueue(tokens[tokenIndex]);

                    if (isSeparLastSame || tokenIndex < tokens.length - 1) {
                        tempQueue.enqueue(separator);
                    }
                }
            }

            assemblyQueue.transferFrom(tempQueue);
        }

        // replace all the terms in the assemblyQueue into a link style
        // and then concatenate assemblyQueue to a String.
        StringBuilder finalDefinition = new StringBuilder();
        for (String segment : assemblyQueue) {
            if (tempTerms.contains(segment)) {
                //<a href="meaning.html">meaning</a>
                String link = "<a href=\"" + segment + ".html\">" + segment
                        + "</a>";
                finalDefinition.append(link);
            } else {
                finalDefinition.append(segment);
            }
        }

        return finalDefinition.toString();
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        // get file name from user.
        out.print(
                "Please enter name of input file in either relative or absolute path: ");
        String fileName = in.nextLine();

        // get output folder from user.
        out.print("Please enter folder of output HTML in "
                + "either relative or absolute path: ");
        String outputFolder = in.nextLine();

        // initializing input file and output writer
        SimpleReader inputFile = new SimpleReader1L(fileName);
        //SimpleWriter outputWriter = new SimpleWriter1L(outputFolder);

        // read all the lines into contents queue.
        Queue<String> contents = convertInputFileToQueue(inputFile);

        // convert these lines into a map.
        // key is term, and value is definition
        Map<String, String> contentMap = assemblyContentToMap(contents);

        // store all the key (term in file) into Queue
        Queue<String> terms = new Queue2<>();
        Iterator<Pair<String, String>> iterator = contentMap.iterator();
        Pair<String, String> tempPair;
        String key;
        while (iterator.hasNext()) {
            tempPair = iterator.next();
            key = tempPair.key();
            terms.enqueue(key);
        }

        // default sort in alphabetical order
        Comparator<String> cs = new StringLT();
        terms.sort(cs);

        // write all the terms and definition into a group of HTML files.
        writeTermsToHTML(terms, contentMap, outputFolder);

        /*
         * Close input and output streams
         */
        inputFile.close();
        in.close();
        out.close();
    }

}
