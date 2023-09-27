import java.util.Iterator;

import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Put a short phrase describing the program here.
 *
 * @author Zhao Liu
 *
 */
public final class XMLTreeExploration {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeExploration() {
    }

    /**
     * Output information about the middle child of the given {@code XMLTree}.
     *
     * @param xt
     *            the {@code XMLTree} whose middle child is to be printed
     * @param out
     *            the output stream
     * @updates out.content
     * @requires <pre>
     * [the label of the root of xt is a tag]  and
     * [xt has at least one child]  and  out.is_open
     * </pre>
     * @ensures <pre>
     * out.content = #out.content * [the label of the middle child
     *  of xt, whether the root of the middle child is a tag or text,
     *  and if it is a tag, the number of children of the middle child]
     * </pre>
     */
    private static void printMiddleNode(XMLTree xt, SimpleWriter out) {
        //the middle child's label,
        //whether the middle child's label is a tag or text, and
        //if the middle child's label is a tag, its number of children

        if (xt.isTag()) {
            int numberOfChilden = xt.numberOfChildren();
            int middleChildIndex = numberOfChilden / 2;

            XMLTree middleChild = xt.child(middleChildIndex);

            out.println("the middle child's label = " + middleChild.label());

            if (middleChild.isTag()) {
                out.println("the middle child's label is a tag");
                out.println("its number of children = "
                        + middleChild.numberOfChildren());
            } else {
                out.println("the middle child's label is not a tag");
            }
        }

    }

    /**
     * print all information about tree.
     *
     * @param tree
     * @param tab
     * @param out
     */
    public static void printWholeTree(XMLTree tree, int tab, SimpleWriter out) {

        if (tree == null) {
            return;
        }

        for (int i = 0; i < tab; i++) {
            out.print("\t");
        }

        if (tree.isTag()) {
            out.print("<" + tree.label() + " ");

            Iterable<String> attributeNames = tree.attributeNames();
            Iterator<String> attributeIterator = attributeNames.iterator();
            while (attributeIterator.hasNext()) {
                String attributeName = attributeIterator.next();

                String attributeValue = tree.attributeValue(attributeName);

                out.print(attributeName + "='" + attributeValue + "' ");
            }

            out.println(">");

            int numberOfChildren = tree.numberOfChildren();
            int nextTab = tab + 1;
            for (int i = 0; i < numberOfChildren; i++) {

                XMLTree child = tree.child(i);

                printWholeTree(child, nextTab, out);
            }
        } else {
            out.println(tree.label());
            return;
        }
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

        XMLTree xml = new XMLTree1(
                "http://web.cse.ohio-state.edu/software/2221/web-sw1/"
                        + "extras/instructions/xmltree-model/columbus-weather.xml");

        //out.println(xml.toString());
        xml.display();

        // outputs whether the root of the XMLTree xml is a tag or text
        // and the label of the root of the XMLTree xml
        if (xml.isTag()) {
            out.println("root of the XMLTree xml is a tag");
        } else {
            out.println("root of the XMLTree xml is a text");
        }

        out.println(
                "the label of the root of the XMLTree xml = " + xml.label());

        XMLTree results = xml.child(0);

        XMLTree channel = results.child(0);

        XMLTree title = channel.child(1);

        XMLTree titleText = title.child(0);

        out.println("titleText = " + titleText);

        final int astronomyIndex = 10;
        XMLTree astronomy = channel.child(astronomyIndex);
        if (astronomy.hasAttribute("sunset")) {
            out.println("astronomy has attribute sunset");

            out.println("astronomy attribute sunset = "
                    + astronomy.attributeValue("sunset"));
        } else {
            out.println("astronomy does not have attribute sunset");
        }

        if (astronomy.hasAttribute("midday")) {
            out.println("astronomy has attribute midday");

            out.println("astronomy attribute midday = "
                    + astronomy.attributeValue("midday"));
        } else {
            out.println("astronomy does not have attribute midday");
        }

        printMiddleNode(channel, out);

        out.println();

        printWholeTree(xml, 0, out);

        // Close input and output streams
        in.close();
        out.close();
    }

}
