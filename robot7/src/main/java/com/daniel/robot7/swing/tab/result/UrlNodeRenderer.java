/**
 * Package spider.gui.swing.tab.result
 *
 **/
package com.daniel.robot7.swing.tab.result;

import java.awt.Color;
import java.awt.Component;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import com.daniel.robot7.swing.common.ui.CommonColors;
import com.daniel.robot7.swing.metadata.tab.ResultMetadata;

/**
 * @author Daniel Žažo
 * @date 25. 2. 2015
 *
 */
public class UrlNodeRenderer extends DefaultTreeCellRenderer {

	private static final long	serialVersionUID	= 8636256137139589770L;
	/**
	 * icon used to display on the search tree
	 */
	public static Icon			icon				= null;

	public UrlNodeRenderer() {
		icon = new ImageIcon(getClass().getResource(ResultMetadata.ICON_WEB));
		setOpaque(true);
	}

	/**
	 * Sets the value of the current tree cell to value. If selected is true, the cell will be drawn as if selected. If expanded is true the node is currently
	 * expanded and if leaf is true the node represets a leaf and if hasFocus is true the node currently has focus. tree is the JTree the receiver is being
	 * configured for. Returns the Component that the renderer uses to draw the value.
	 *
	 * Modified the TreeCellRender to match a specific nodes attributes. If the node is a match, then blue is used for the text color. Icon is customized
	 *
	 * @param tree
	 *            the JTree being redrawn
	 * @param value
	 *            node in the tree
	 * @param selected
	 *            true if selected by the user
	 * @param expanded
	 *            true if path is expanded
	 * @param leaf
	 *            true if this node is a leaf
	 * @param row
	 *            row number (vertical position)
	 * @param hasFocus
	 *            true if it has the focus
	 * @return the Component that the renderer uses to draw the value
	 */
	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);

		setOpenIcon(icon);
		setClosedIcon(icon);
		setLeafIcon(icon);

		final UrlTreeNode node = (UrlTreeNode) (((DefaultMutableTreeNode) value).getUserObject());
		if (node.isContainsPhrase()) {
			setBackground(CommonColors.LIGHT_GREEN);
			setForeground(Color.BLACK);
		} else {
			setBackground(tree.getBackground());
		}

		// Selected color is important mark here!!!
		if (selected) {
			setBackground(CommonColors.LIGHT_BLUE);
			setForeground(Color.BLACK);
		}

		return this;
	}
}
