package com.daniel.robot7.swing.tab.graph.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.tree.TreeModel;

import org.apache.commons.collections15.functors.ConstantTransformer;

import com.daniel.robot7.controller.graphTab.ChangeCheckboxShowHyperbolController;
import com.daniel.robot7.controller.graphTab.ChangeLayoutController;
import com.daniel.robot7.controller.graphTab.ClickToVertexController;
import com.daniel.robot7.controller.graphTab.CloseGraphWindowController;
import com.daniel.robot7.controller.graphTab.ExportGraph;
import com.daniel.robot7.controller.graphTab.ZoomMinusController;
import com.daniel.robot7.controller.graphTab.ZoomPlusController;
import com.daniel.robot7.swing.common.ui.CommonColors;
import com.daniel.robot7.swing.metadata.tab.GraphMetadata;
import com.daniel.robot7.util.CommonConstants;
import edu.uci.ics.jung.algorithms.layout.BalloonLayout;
import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.graph.DelegateForest;
import edu.uci.ics.jung.graph.Forest;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;
import edu.uci.ics.jung.visualization.Layer;
import edu.uci.ics.jung.visualization.VisualizationServer.Paintable;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.CrossoverScalingControl;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalLensGraphMouse;
import edu.uci.ics.jung.visualization.control.ScalingControl;
import edu.uci.ics.jung.visualization.decorators.EdgeShape.Line;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.transform.LensSupport;
import edu.uci.ics.jung.visualization.transform.shape.HyperbolicShapeTransformer;
import edu.uci.ics.jung.visualization.transform.shape.ViewLensSupport;

/**
 * The Class WindowGraph.
 *
 * @author Daniel Žažo
 * @date 25. 3. 2015
 */
public class WindowGraph extends JApplet {

	/** serialVersionUID. */
	private static final long											serialVersionUID	= -6599364433373620299L;

	/** The graph. */
	private final Forest<String, String>								graph;

	/** The edge factory. */
	private final EdgeFactory											edgeFactory;

	/** The visual component and renderer for the graph. */
	private VisualizationViewer<String, String>							visualizationViewer;

	/** The rings. */
	private Paintable													rings;

	/** The tree layout. */
	private TreeLayout<String, String>									treeLayout;

	/** The balloon layout. */
	private BalloonLayout<String, String>								balloonLayout;

	/** The hyperbolic view support. */
	private LensSupport													hyperbolicViewSupport;

	/** The j tree urls. */
	private final JTree													jTreeUrls;

	/** The window graph frame. */
	private WindowGraphFrame											windowGraphFrame;

	/** The container. */
	private final Container												container;

	/** The j panel controls. */
	private JPanel														jPanelControls;

	/** The lbl balloon layout. */
	private JLabel														lblBalloonLayout;

	/** The lbl tree layout. */
	private JLabel														lblTreeLayout;

	/** The button toggle button switch layout. */
	private JToggleButton												buttonToggleButtonSwitchLayout;

	/** The dimension of button. */
	private Dimension													dimensionOfButton;

	/** The dimension of label. */
	private Dimension													dimensionOfLabel;

	/** The dimension of buttons zoom. */
	private Dimension													dimensionOfButtonsZoom;

	/** The font size17. */
	private Font														fontSize17;

	/** The font size25. */
	private Font														fontSize25;

	/** The button minus. */
	private JButton														buttonMinus;

	/** The button plus. */
	private JButton														buttonPlus;

	/** The button export to file. */
	private JButton														buttonExportToFile;

	/** The j button close. */
	private JButton														jButtonClose;

	/** The scaling control. */
	private ScalingControl												scalingControl;

	/** The graph mouse. */
	private DefaultModalGraphMouse<Float, Float>						graphMouse;

	/** The operating system ui. */
	private final com.daniel.robot7.swing.common.ui.AbstractOperatingSystemUI	operatingSystemUI;

	/**
	 * Gets the scaling control.
	 *
	 * @return the scaling control
	 */
	public ScalingControl getScalingControl() {
		return scalingControl;
	}

	/**
	 * Sets the scaling control.
	 *
	 * @param scalingControl
	 *            the new scaling control
	 */
	public void setScalingControl(ScalingControl scalingControl) {
		this.scalingControl = scalingControl;
	}

	/**
	 * Gets the visualization viewer.
	 *
	 * @return the visualization viewer
	 */
	public VisualizationViewer<String, String> getVisualizationViewer() {
		return visualizationViewer;
	}

	/**
	 * Sets the visualization viewer.
	 *
	 * @param visualizationViewer
	 *            the visualization viewer
	 */
	public void setVisualizationViewer(VisualizationViewer<String, String> visualizationViewer) {
		this.visualizationViewer = visualizationViewer;
	}

	/**
	 * Gets the tree layout.
	 *
	 * @return the tree layout
	 */
	public TreeLayout<String, String> getTreeLayout() {
		return treeLayout;
	}

	/**
	 * Sets the tree layout.
	 *
	 * @param treeLayout
	 *            the tree layout
	 */
	public void setTreeLayout(TreeLayout<String, String> treeLayout) {
		this.treeLayout = treeLayout;
	}

	/**
	 * Gets the balloon layout.
	 *
	 * @return the balloon layout
	 */
	public BalloonLayout<String, String> getBalloonLayout() {
		return balloonLayout;
	}

	/**
	 * Sets the balloon layout.
	 *
	 * @param balloonLayout
	 *            the balloon layout
	 */
	public void setBalloonLayout(BalloonLayout<String, String> balloonLayout) {
		this.balloonLayout = balloonLayout;
	}

	/**
	 * Gets the rings.
	 *
	 * @return the rings
	 */
	public Paintable getRings() {
		return rings;
	}

	/**
	 * Gets the j tree urls.
	 *
	 * @return the j tree urls
	 */
	public JTree getjTreeUrls() {
		return jTreeUrls;
	}

	/**
	 * Sets the rings.
	 *
	 * @param rings
	 *            the new rings
	 */
	public void setRings(Paintable rings) {
		this.rings = rings;
	}

	/**
	 * Gets the window graph frame.
	 *
	 * @return the window graph frame
	 */
	public WindowGraphFrame getWindowGraphFrame() {
		return windowGraphFrame;
	}

	/**
	 * Sets the window graph frame.
	 *
	 * @param windowGraphFrame
	 *            the new window graph frame
	 */
	public void setWindowGraphFrame(WindowGraphFrame windowGraphFrame) {
		this.windowGraphFrame = windowGraphFrame;
	}

	/**
	 * Instantiates a new window graph.
	 *
	 * @param windowGraphFrame
	 *            the window graph frame
	 * @param jTreeUrls
	 *            the j tree urls
	 */
	public WindowGraph(WindowGraphFrame windowGraphFrame, JTree jTreeUrls) {
		this.windowGraphFrame = windowGraphFrame;
		this.jTreeUrls = jTreeUrls;
		this.container = getContentPane();
		this.operatingSystemUI = windowGraphFrame.getMainWindow().getOperatingSystemUI();

		graph = new DelegateForest<String, String>();
		// graph = new DelegateForest<String, Integer>();
		edgeFactory = new EdgeFactory();

		addAllNodes(jTreeUrls);

		createLayouts();
		createScalingControl();
		createGraphMouse();
		createControlPanel();
	}

	/**
	 * Creates the layouts.
	 */
	private void createLayouts() {
		treeLayout = new TreeLayout<String, String>(graph);

		balloonLayout = new BalloonLayout<String, String>(graph);
		balloonLayout.setSize(windowGraphFrame.getPercentDimension(80));

		// Setting of initial layout
		// visualizationViewer = new VisualizationViewer<String, Integer>(treeLayout, this.windowGraphFrame.getPercentDimension(80));
		visualizationViewer = new VisualizationViewer<String, String>(balloonLayout, this.windowGraphFrame.getPercentDimension(80));
		visualizationViewer.setBackground(Color.white);
		visualizationViewer.getRenderContext().setEdgeShapeTransformer(new Line());
		visualizationViewer.getRenderContext().setEdgeDrawPaintTransformer(new CrawlerEdgeDrawing(graph, this.jTreeUrls));
		visualizationViewer.getRenderContext().setArrowFillPaintTransformer(new CrawlerEdgeDrawing(graph, this.jTreeUrls));
		visualizationViewer.getRenderContext().setArrowDrawPaintTransformer(new CrawlerEdgeDrawing(graph, this.jTreeUrls));
		visualizationViewer.getRenderContext().setVertexLabelTransformer(new CrawlerNodeLabeller<String>(this.jTreeUrls));
		// visualizationViewer.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<String>());
		visualizationViewer.getRenderContext().setVertexFillPaintTransformer(new CrawlerVertexFillPaintFunction(this.jTreeUrls));

		visualizationViewer.addGraphMouseListener(new ClickToVertexController());

		// add a listener for ToolTips
		visualizationViewer.setVertexToolTipTransformer(new ToStringLabeller());
		visualizationViewer.getRenderContext().setArrowFillPaintTransformer(new ConstantTransformer(Color.lightGray));
		rings = new RingsGraphic(visualizationViewer, balloonLayout);

		final GraphZoomScrollPane panel = new GraphZoomScrollPane(visualizationViewer);
		this.container.add(panel);
	}

	/**
	 * Creates the scaling control.
	 */
	private void createScalingControl() {
		scalingControl = new CrossoverScalingControl();
		visualizationViewer.scaleToLayout(scalingControl);
	}

	/**
	 * Creates the graph mouse.
	 */
	private void createGraphMouse() {
		graphMouse = new DefaultModalGraphMouse<Float, Float>();
		visualizationViewer.setGraphMouse(graphMouse);
		visualizationViewer.addKeyListener(graphMouse.getModeKeyListener());
	}

	/**
	 * Creates the control panel.
	 */
	private void createControlPanel() {
		// Create needed components and it's properties.
		dimensionOfButton = new Dimension(130, 60);
		dimensionOfLabel = new Dimension(100, 40);
		dimensionOfButtonsZoom = new Dimension(50, 40);
		fontSize17 = new Font(CommonConstants.FONT_BOOK_ANTIQUA, Font.ROMAN_BASELINE, 17);
		fontSize25 = new Font(CommonConstants.FONT_BOOK_ANTIQUA, Font.ROMAN_BASELINE, 18);
		// Following layouts must be created before creating btnSwitchLayout (There is used these labels)
		lblBalloonLayout = getLabelBalloonLayout();
		lblTreeLayout = getLabelTreeLayout();
		// setActiveTreeLayout(); // Settings only labels
		setActiveBalloonLayout();

		jPanelControls = new JPanel();
		jPanelControls.add(getButtonSwichLayout());
		buttonToggleButtonSwitchLayout.doClick();
		jPanelControls.add(getPanelScaleGridLayouts());
		jPanelControls.add(getPanelScaleGridZooming());
		jPanelControls.add(getPanelScaleGridMouseModes());
		jPanelControls.add(getPanelScaleGridHyperbol());
		jPanelControls.add(getButtonExportToFile());
		jPanelControls.add(getButtonExit());

		this.container.add(jPanelControls, BorderLayout.SOUTH);
	}

	/**
	 * Gets the button export to file.
	 *
	 * @return the button export to file
	 */
	private Component getButtonExportToFile() {
		jButtonClose = new JButton(GraphMetadata.LABEL_BUTTON_EXPORT_TO_FILE);
		jButtonClose.setPreferredSize(dimensionOfButton);
		jButtonClose.setFont(fontSize25);
		jButtonClose.addActionListener(new ExportGraph(this));
		return jButtonClose;
	}

	/**
	 * Gets the button exit.
	 *
	 * @return the button exit
	 */
	private JButton getButtonExit() {
		jButtonClose = new JButton(GraphMetadata.LABEL_BUTTON_CLOSE);
		jButtonClose.setPreferredSize(dimensionOfButton);
		jButtonClose.setFont(fontSize25);
		jButtonClose.addActionListener(new CloseGraphWindowController(this.windowGraphFrame));
		return jButtonClose;
	}

	/**
	 * Gets the panel scale grid hyperbol.
	 *
	 * @return the panel scale grid hyperbol
	 */
	private JPanel getPanelScaleGridHyperbol() {
		final JPanel panelScaleGrid = new JPanel();
		panelScaleGrid.setPreferredSize(dimensionOfButton);
		panelScaleGrid.setLayout(new BoxLayout(panelScaleGrid, BoxLayout.X_AXIS));

		final TitledBorder title = BorderFactory.createTitledBorder(GraphMetadata.LABEL_HYPERBOLIC_VIEW);
		title.setTitleJustification(TitledBorder.CENTER);
		panelScaleGrid.setBorder(title);

		hyperbolicViewSupport = new ViewLensSupport<String, String>(visualizationViewer, new HyperbolicShapeTransformer(visualizationViewer,
				visualizationViewer.getRenderContext().getMultiLayerTransformer().getTransformer(Layer.VIEW)), new ModalLensGraphMouse());
		graphMouse.addItemListener(hyperbolicViewSupport.getGraphMouse().getModeListener());

		final JCheckBox checkboxHyperbol = new JCheckBox(GraphMetadata.LABEL_SHOW);
		checkboxHyperbol.addItemListener(new ChangeCheckboxShowHyperbolController(hyperbolicViewSupport));

		panelScaleGrid.add(Box.createHorizontalGlue());
		panelScaleGrid.add(checkboxHyperbol);
		panelScaleGrid.add(Box.createHorizontalGlue());
		return panelScaleGrid;
	}

	/**
	 * Gets the panel scale grid mouse modes.
	 *
	 * @return the panel scale grid mouse modes
	 */
	private JPanel getPanelScaleGridMouseModes() {
		final JPanel panelScaleGrid = new JPanel(new GridLayout(1, 0));
		panelScaleGrid.setPreferredSize(operatingSystemUI.getDimensionPanelMouseModes());

		final TitledBorder title = BorderFactory.createTitledBorder(GraphMetadata.LABEL_MOUSE_MODE);
		title.setTitleJustification(TitledBorder.CENTER);
		panelScaleGrid.setBorder(title);

		@SuppressWarnings("rawtypes")
		final JComboBox mouseModes = graphMouse.getModeComboBox();
		mouseModes.addItemListener(graphMouse.getModeListener());
		graphMouse.setMode(ModalGraphMouse.Mode.TRANSFORMING);

		panelScaleGrid.add(mouseModes);
		return panelScaleGrid;
	}

	/**
	 * Gets the panel scale grid zooming.
	 *
	 * @return the panel scale grid zooming
	 */
	private JPanel getPanelScaleGridZooming() {
		final JPanel panelScaleGrid = new JPanel(new GridLayout(1, 0));

		final TitledBorder title = BorderFactory.createTitledBorder(GraphMetadata.LABEL_TITLE_ZOOM);
		title.setTitleJustification(TitledBorder.CENTER);
		panelScaleGrid.setBorder(title);

		panelScaleGrid.add(getBtnMinus());
		panelScaleGrid.add(getBtnPlus());
		return panelScaleGrid;
	}

	/**
	 * Gets the btn plus.
	 *
	 * @return the btn plus
	 */
	private JButton getBtnPlus() {
		buttonPlus = new JButton(GraphMetadata.LABEL_BUTTON_PLUS);
		buttonPlus.addActionListener(new ZoomPlusController(visualizationViewer, scalingControl));
		buttonPlus.setPreferredSize(dimensionOfButtonsZoom);
		buttonPlus.setFont(fontSize25);
		return buttonPlus;
	}

	/**
	 * Gets the btn minus.
	 *
	 * @return the btn minus
	 */
	private JButton getBtnMinus() {
		buttonMinus = new JButton(GraphMetadata.LABEL_BUTTON_MINUS);
		buttonMinus.addActionListener(new ZoomMinusController(visualizationViewer, scalingControl));
		buttonMinus.setPreferredSize(dimensionOfButtonsZoom);
		buttonMinus.setFont(fontSize25);
		return buttonMinus;
	}

	/**
	 * Gets the panel scale grid layouts.
	 *
	 * @return the panel scale grid layouts
	 */
	private JPanel getPanelScaleGridLayouts() {
		final JPanel panelScaleGrid = new JPanel(new GridLayout(1, 0));

		final TitledBorder title = BorderFactory.createTitledBorder(GraphMetadata.LABEL_TITLE_LAYOUTS);
		title.setTitleJustification(TitledBorder.CENTER);
		panelScaleGrid.setBorder(title);

		panelScaleGrid.add(lblTreeLayout);
		panelScaleGrid.add(lblBalloonLayout);
		return panelScaleGrid;
	}

	/**
	 * Sets the active balloon layout.
	 */
	public void setActiveBalloonLayout() {
		lblBalloonLayout.setBackground(Color.GREEN);
		lblBalloonLayout.setOpaque(true);
		lblTreeLayout.setBackground(CommonColors.DEFAULT_COLOR_OF_PANEL);
		lblTreeLayout.setOpaque(true);
	}

	/**
	 * Sets the active tree layout.
	 */
	public void setActiveTreeLayout() {
		lblBalloonLayout.setBackground(CommonColors.DEFAULT_COLOR_OF_PANEL);
		lblBalloonLayout.setOpaque(true);
		lblTreeLayout.setBackground(Color.GREEN);
		lblTreeLayout.setOpaque(true);
	}

	/**
	 * Gets the label tree layout.
	 *
	 * @return the label tree layout
	 */
	private JLabel getLabelTreeLayout() {
		lblTreeLayout = new JLabel(GraphMetadata.LABEL_TREE_LAYOUT, SwingConstants.CENTER);
		lblTreeLayout.setPreferredSize(dimensionOfLabel);
		lblTreeLayout.setFont(fontSize17);
		return lblTreeLayout;
	}

	/**
	 * Gets the label balloon layout.
	 *
	 * @return the label balloon layout
	 */
	private JLabel getLabelBalloonLayout() {
		lblBalloonLayout = new JLabel(GraphMetadata.LABEL_BAALLOON_LAYOUT, SwingConstants.CENTER);
		lblBalloonLayout.setPreferredSize(dimensionOfLabel);
		lblBalloonLayout.setFont(fontSize17);
		return lblBalloonLayout;
	}

	/**
	 * Gets the button swich layout.
	 *
	 * @return the button swich layout
	 */
	private JToggleButton getButtonSwichLayout() {
		buttonToggleButtonSwitchLayout = new JToggleButton(GraphMetadata.LABEL_BUTTON_SWITCH_LAYOUT);
		buttonToggleButtonSwitchLayout.setPreferredSize(operatingSystemUI.getDimensionButtonSwitchLayout());
		buttonToggleButtonSwitchLayout.setFont(fontSize17);
		buttonToggleButtonSwitchLayout.addItemListener(new ChangeLayoutController(this));
		return buttonToggleButtonSwitchLayout;
	}

	/**
	 * Adds the all nodes.
	 *
	 * @param jTreeUrls
	 *            the j tree urls
	 */
	private void addAllNodes(JTree jTreeUrls) {
		final TreeModel treeModel = jTreeUrls.getModel();
		addNodeToGraph(treeModel, treeModel.getRoot(), CommonConstants.EMPTY_STRING);
	}

	/**
	 * Adds the node to graph.
	 *
	 * @param treeModel
	 *            the tree model
	 * @param object
	 *            the object
	 * @param indent
	 *            the indent
	 */
	private void addNodeToGraph(TreeModel treeModel, Object object, String indent) {
		for (int i = 0; i < treeModel.getChildCount(object); i++) {
			graph.addEdge(Integer.toString(edgeFactory.create()), object.toString(), treeModel.getChild(object, i).toString());
			addNodeToGraph(treeModel, treeModel.getChild(object, i), indent + "  ");
		}
	}

}
