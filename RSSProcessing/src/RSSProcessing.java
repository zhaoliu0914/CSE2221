import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * This program inputs an XML RSS (version 2.0) feed from a given URL and
 * outputs various elements of the feed to the console.
 *
 * @author Zhao Liu
 *
 */
public final class RSSProcessing {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private RSSProcessing() {
    }

    /**
     * Finds the first occurrence of the given tag among the children of the
     * given {@code XMLTree} and return its index; returns -1 if not found.
     *
     * @param xml
     *            the {@code XMLTree} to search
     * @param tag
     *            the tag to look for
     * @return the index of the first child of the {@code XMLTree} matching the
     *         given tag or -1 if not found
     * @requires [the label of the root of xml is a tag]
     * @ensures <pre>
     * getChildElement =
     *  [the index of the first child of the {@code XMLTree} matching the
     *   given tag or -1 if not found]
     * </pre>
     */
    private static int getChildElement(XMLTree xml, String tag) {
        assert xml != null : "Violation of: xml is not null";
        assert tag != null : "Violation of: tag is not null";
        assert xml.isTag() : "Violation of: the label root of xml is a tag";

        int numberOfChildren = xml.numberOfChildren();
        XMLTree child;
        String label;
        for (int i = 0; i < numberOfChildren; i++) {
            child = xml.child(i);
            label = child.label();
            if (label.equalsIgnoreCase(tag)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Processes one news item and outputs the title, or the description if the
     * title is not present, and the link (if available) with appropriate
     * labels.
     *
     * @param item
     *            the news item
     * @param out
     *            the output stream
     * @requires [the label of the root of item is an <item> tag] and
     *           out.is_open
     * @ensures out.content = #out.content * [the title (or description) and
     *          link]
     */
    private static void processItem(XMLTree item, SimpleWriter out) {
        assert item != null : "Violation of: item is not null";
        assert out != null : "Violation of: out is not null";
        assert item.isTag() && item.label().equals("item") : ""
                + "Violation of: the label root of item is an <item> tag";
        assert out.isOpen() : "Violation of: out.is_open";

        int numberOfChildren = item.numberOfChildren();

        XMLTree child;
        String label;
        XMLTree grandchild;
        for (int i = 0; i < numberOfChildren; i++) {
            child = item.child(i);
            label = child.label();

            if ("title".equals(label) || "description".equals(label)
                    || "link".equals(label)) {
                out.print(label + ": ");
                grandchild = child.child(0);
                out.println(grandchild.label());
            }
        }

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        /*
         * Open I/O streams.
         */
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Input the source URL.
         */
        //out.print("Enter the URL of an RSS 2.0 news feed: ");
        //String url = in.nextLine();
        String url = "https://news.yahoo.com/rss/";
        /*
         * Read XML input and initialize XMLTree. If input is not legal XML,
         * this statement will fail.
         */
        XMLTree xml = new XMLTree1(url);
        /*
         * Extract <channel> element.
         */
        XMLTree channel = xml.child(0);
        int numberOfChildren = channel.numberOfChildren();

        int titleIndex = getChildElement(channel, "title");
        int descriptionIndex = getChildElement(channel, "description");
        int linkIndex = getChildElement(channel, "link");

        XMLTree titleNode = channel.child(titleIndex);
        XMLTree descriptionNode = channel.child(descriptionIndex);
        XMLTree linkNode = channel.child(linkIndex);

        out.println("Title: " + titleNode.child(0).label());
        out.println("Description: " + descriptionNode.child(0).label());
        out.println("Link: " + linkNode.child(0).label());

        out.println();

        XMLTree child;
        String childLabel;
        for (int i = 0; i < numberOfChildren; i++) {
            child = channel.child(i);
            childLabel = child.label();

            if ("item".equals(childLabel)) {
                out.println("<item>");
                processItem(child, out);
                out.println("</item>");
                out.println();
            }
        }

        int[] a = { 5, 6, 2, 1, 0, -5, 6, 10 };

        int smallest = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < smallest) {
                smallest = a[i];
            }
        }
        out.println("smallest = " + smallest);

        /*
         * Close I/O streams.
         */
        in.close();
        out.close();
    }

}
