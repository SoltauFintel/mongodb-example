package de.mwvb;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Inhalt einer Webseite laden
 * 
 * @author Marcus Warm
 */
public class WebPageLoader {
	private static final Pattern PATTERN = Pattern.compile("text/html;\\s+charset=([^\\s]+)\\s*");

	/**
	 * @param url z.B. "http://www.google.de"
	 * @return null wenn ein Fehler aufgetreten ist
	 */
	public String loadContent(String url) {
		try {
			URLConnection conn = new URL(url).openConnection();
			Matcher m = PATTERN.matcher(conn.getContentType());
			String charset = m.matches() ? m.group(1) : "ISO-8859-1";
			Reader r = new InputStreamReader(conn.getInputStream(), charset);
			StringBuilder buf = new StringBuilder();
			while (true) {
				int ch = r.read();
				if (ch < 0) {
					break;
				}
				buf.append((char) ch);
			}
			return buf.toString();
		} catch (IOException e) {
			return null;
		}
	}
}
