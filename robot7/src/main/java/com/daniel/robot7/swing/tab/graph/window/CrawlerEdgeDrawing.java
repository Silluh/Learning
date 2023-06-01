package com.daniel.robot7.swing.tab.graph.window;

import java.awt.Color;
import java.awt.Paint;
import java.util.Enumeration;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import org.apache.commons.collections15.Transformer;

import com.daniel.robot7.swing.tab.result.UrlTreeNode;
import edu.uci.ics.jung.graph.Forest;

/**
 * The Class CrawlerEdgeDrawing.
 */
public class CrawlerEdgeDrawing implements Transformer<String, Paint> {

	/** The graph. */
	private final Forest<String, String>	graph;

	/** The j tree urls. */
	private final JTree						jTreeUrls;

	/**
	 * Instantiates a new crawler edge drawing.
	 *
	 * @param graph
	 *            the graph
	 * @param jTreeUrls
	 *            the j tree urls
	 */
	public CrawlerEdgeDrawing(Forest<String, String> graph, JTree jTreeUrls) {
		this.graph = graph;
		this.jTreeUrls = jTreeUrls;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.commons.collections15.Transformer#transform(java.lang.Object)
	 */
	@Override
	public Paint transform(String urlInNode) {
		if (containsSomeFoundPhrases(graph.getDest(urlInNode))) {
			return Color.RED;
		}
		return Color.BLACK;
	}

	/**
	 * Contains some found phrases.
	 *
	 * @param urlInTree
	 *            the url in tree
	 * @return true, if successful
	 */
	private boolean containsSomeFoundPhrases(String urlInTree) {
		final DefaultTreeModel treeModel = (DefaultTreeModel) jTreeUrls.getModel();
		final DefaultMutableTreeNode root = (DefaultMutableTreeNode) treeModel.getRoot();
		final Enumeration<TreeNode> etree = root.breadthFirstEnumeration();
		while (etree.hasMoreElements()) {
			final DefaultMutableTreeNode dep = (DefaultMutableTreeNode) etree.nextElement();
 			final UrlTreeNode node = (UrlTreeNode) (dep.getUserObject());
			if (node instanceof UrlTreeNode && node.equals(urlInTree)) {
				return (node.getCountOfAllPhrases() > 0);
			}
		}
		return false;
	}
}
