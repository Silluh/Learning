/**
 * Package crawler.gui.swing.tab.graph
 *
 **/
package com.daniel.robot7.swing.tab.graph.window;

import java.awt.Color;
import java.awt.Paint;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.apache.commons.collections15.Transformer;

import com.daniel.robot7.swing.tab.result.UrlTreeNode;

/**
 * The Class CrawlerVertexFillPaintFunction.
 *
 * @author Daniel Žažo
 * @param <V> the value type
 * @date 12. 3. 2015
 */

/**
 * Class for coloring rings in graph.
 * 
 * @author Daniel Žažo
 * @date 12. 3. 2015
 *
 * @param <V>
 */
public class CrawlerVertexFillPaintFunction<V> implements Transformer<V, Paint> {

	/** The j tree urls. */
	private final JTree	jTreeUrls;

	/**
	 * Instantiates a new crawler vertex fill paint function.
	 *
	 * @param jTreeUrls the j tree urls
	 */
	public CrawlerVertexFillPaintFunction(JTree jTreeUrls) {
		this.jTreeUrls = jTreeUrls;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.collections15.Transformer#transform(java.lang.Object)
	 */
	@Override
	public Paint transform(V v) {
		if (checkNodeIfContainsPhrase(v.toString())) {
			return Color.RED;
		}
		return Color.CYAN;
	}

	/**
	 * Return true if founded UrlTreeNode contains some searched phrase.
	 *
	 * @param teststring the teststring
	 * @return true, if successful
	 */
	public boolean checkNodeIfContainsPhrase(String teststring) {
		final DefaultTreeModel treeModel = (DefaultTreeModel) jTreeUrls.getModel();
		final DefaultMutableTreeNode root = (DefaultMutableTreeNode) treeModel.getRoot();
		final Enumeration<DefaultMutableTreeNode> etree = root.breadthFirstEnumeration();
		while (etree.hasMoreElements()) {
			final UrlTreeNode node = (UrlTreeNode) (etree.nextElement().getUserObject());
			if (node instanceof UrlTreeNode && node.equals(teststring) && node.isContainsPhrase()) {
				return true;
			}
		}
		return false;
	}
}