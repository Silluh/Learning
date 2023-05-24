/**
 * Package crawler.gui.swing.tab.graph
 *
**/
package com.daniel.robot7.swing.tab.graph.window;

import java.util.Enumeration;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.apache.commons.collections15.Transformer;

import com.daniel.robot7.swing.tab.result.UrlTreeNode;

/**
 * The Class CrawlerNodeLabeller.
 *
 * @author Daniel Žažo
 * @param <V> the value type
 * @date 17. 3. 2015
 */
public class CrawlerNodeLabeller <V> implements Transformer<V, String> {
	
	/** The j tree urls. */
	private final JTree jTreeUrls;
	
	/**
	 * Instantiates a new crawler node labeller.
	 *
	 * @param jTreeUrls the j tree urls
	 */
	public CrawlerNodeLabeller(JTree jTreeUrls) {
		this.jTreeUrls = jTreeUrls;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.collections15.Transformer#transform(java.lang.Object)
	 */
	@Override
	public String transform(V v) {
		return getCountOfFoundedPhrases(v.toString());
	}
	
	/**
	 * Gets the count of founded phrases.
	 *
	 * @param urlInTree the url in tree
	 * @return the count of founded phrases
	 */
	private String getCountOfFoundedPhrases(String urlInTree) {
		final DefaultTreeModel treeModel = (DefaultTreeModel) jTreeUrls.getModel();
		final DefaultMutableTreeNode root = (DefaultMutableTreeNode) treeModel.getRoot();
		final Enumeration<DefaultMutableTreeNode> etree = root.breadthFirstEnumeration();
		while (etree.hasMoreElements()) {
			final UrlTreeNode node = (UrlTreeNode) (etree.nextElement().getUserObject());
			if (node instanceof UrlTreeNode && node.equals(urlInTree)) {
				return Long.toString(node.getCountOfAllPhrases());
			}
		}
		return null;
	}

}
