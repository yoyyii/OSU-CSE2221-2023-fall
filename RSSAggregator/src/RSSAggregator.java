import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * This program inputs an XML RSS (version 2.0) feed from a given URL and
 * outputs various elements of the feed to the console.``
 *
 * @author Yoyi Liao
 *
 */
public final class RSSAggregator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private RSSAggregator() {
    }

    /**
     * Processes one XML RSS (version 2.0) feed from a given URL converting it
     * into the corresponding HTML output file.
     *
     * @param url
     *            the URL of the RSS feed
     * @param file
     *            the name of the HTML output file
     * @param out
     *            the output stream to report progress or errors
     * @updates out.content
     * @requires out.is_open
     * @ensures <pre>
     * [reads RSS feed from url, saves HTML document with table of news items
     *   to file, appends to out.content any needed messages]
     * </pre>
     */
    private static void processFeed(String url, String file,
            SimpleWriter fileOut) {

        /*
         * Read XML input and initialize XMLTree. If input is not legal XML,
         * this statement will fail.
         */
        boolean valid = true;
        XMLTree xml = new XMLTree1(url);
        if (!xml.label().equals("rss") && !xml.hasAttribute("version")
                && !xml.attributeValue("version").equals("2.0")) {

            valid = false;
        }

        if (valid) {
            /*
             * Extract <channel> element.
             */

            XMLTree channel = xml.child(0);

            /*
             * for each item, output title (or description, if title is not
             * available) and link (if available)
             */

            SimpleWriter pageOut = new SimpleWriter1L(file);

            /*
             * outprint HTML heading
             */
            headingHTML(channel, pageOut);

            for (int i = 0; i < channel.numberOfChildren(); i++) {
                if (channel.child(i).label().equals("item")) {
                    processItem(channel.child(i), pageOut);
                }
            }
            closeHTML(fileOut);
        }
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
        /*
         * TODO: #1 - fill in body
         */

        int index = -1;

        for (int i = 0; index == -1 && i < xml.numberOfChildren(); i++) {
            if (xml.child(i).label().equals(tag)) {
                index = i;
            }
        }

        return index;

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
     *          link and the publication date]
     */
    private static void processItem(XMLTree item, SimpleWriter out) {
        assert item != null : "Violation of: item is not null";
        assert out != null : "Violation of: out is not null";
        assert item.isTag() && item.label().equals("item") : ""
                + "Violation of: the label root of item is an <item> tag";
        assert out.isOpen() : "Violation of: out.is_open";

        /*
         * get publication date, if present, or "No date available"
         */

        String date = "No date available";
        int dateIndex = getChildElement(item, "pubDate");
        if (dateIndex != -1) {
            date = item.child(dateIndex).child(0).label();
        }

        /*
         * get title value
         */

        String title = "No title available";
        int titleIndex = getChildElement(item, "title");
        if (titleIndex != -1) {
            if (item.child(titleIndex).numberOfChildren() != 0) {
                title = item.child(titleIndex).child(0).label();
            }
        } else { // if title not present, test if description is present
            int descriptionIndex = getChildElement(item, "description");
            if (descriptionIndex != -1) {
                if (item.child(descriptionIndex).numberOfChildren() != 0) {
                    title = item.child(descriptionIndex).child(0).label();
                }
            }
        }

        /*
         * get link value for title
         */
        String link = "";
        int linkIndex = getChildElement(item, "link");
        if (linkIndex != -1) {
            link = item.child(linkIndex).child(0).label();
        }

        /*
         * get source value and linked to the source url
         */

        String source = "No source available";
        String sourceURL = "";
        int sourceIndex = getChildElement(item, "source");
        if (sourceIndex != -1) {

            if (item.child(sourceIndex).numberOfChildren() != 0) {
                source = item.child(sourceIndex).child(0).label();
            }

            sourceURL = item.child(sourceIndex).attributeValue("url");
        }

        out.println("<td>" + date + "</td>");
        if (source.equals("No source available")) {
            out.println("<td>" + source + "</td>");
        } else {
            out.println(
                    "<td><a href=\"" + sourceURL + "\">" + source + "</td>");
        }
        out.println("<td><a href=\"" + link + "\">" + title + "</td>");
        out.println("</tr>");
    }

    /**
     * outprint the closing of html file
     *
     * @param out
     *            the output stream
     *
     * @requires out.is_open
     *
     * @ensures out.content = #out.content * [the html closing tags]
     */

    public static void closeHTML(SimpleWriter out) {
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }

    /**
     * outprint the heading of html file
     *
     * @param channel
     *            the channel element in current XMLTree
     *
     * @param out
     *            the output stream
     *
     * @requires out.is_open
     *
     * @ensures out.content = #out.content * [the html heading tags]
     */

    public static void headingHTML(XMLTree channel, SimpleWriter out) {
        int titleIndex = getChildElement(channel, "title");
        String title = "Empty title";

        if (channel.child(titleIndex).numberOfChildren() != -1) {
            title = channel.child(titleIndex).child(0).label();
        }

        int descriptionIndex = getChildElement(channel, "description");
        String description = "No description";
        if (channel.child(descriptionIndex).numberOfChildren() != 0) {
            description = channel.child(descriptionIndex).child(0).label();

        }

        int linkIndex = getChildElement(channel, "link");
        String link = "";
        link = channel.child(linkIndex).child(0).label();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>" + title + "</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1><a href=\"" + link + "\">" + title + "</a></h1>");
        out.println("<p>" + description + "</p>");
        out.println("<table border=\"1\">");
        out.println("<tr>");
        out.println("<th>Date</th>");
        out.println("<th>Source</th>");
        out.println("<th>News</th>");
        out.println("</tr>");
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
         * http://web.cse.ohio-state.edu/software/2221/web-sw1/assignments/
         * projects/rss-aggregator/feeds.xml
         */
        out.print("Enter the URL of an RSS 2.0 news feed: ");
        String url = in.nextLine();

        /*
         * enter the output file name
         */
        out.println(
                "enter the output file name in the format of filename.html");
        SimpleWriter fileOut = new SimpleWriter1L(in.nextLine());
        XMLTree xml = new XMLTree1(url);

        if (xml.hasAttribute("title")) {
            fileOut.println("<html><head><title>" + xml.attributeValue("title")
                    + "</title></head>");
        }
        fileOut.println("<body><h2>" + xml.attributeValue("title") + "</h2>");
        fileOut.println("<ul>");

        for (int i = 0; i < xml.numberOfChildren(); i++) {
            String webURL = xml.child(i).attributeValue("url");
            String file = xml.child(i).attributeValue("file");
            processFeed(webURL, file, fileOut);
            fileOut.println("<li><a href=" + xml.child(i).attributeValue("file")
                    + ">" + xml.child(i).attributeValue("name") + "</a></li>");
        }

        /*
         * Close I/O streams.
         */
        fileOut.println("</ul></body></html>");
        in.close();
        out.close();
        fileOut.close();
    }

}