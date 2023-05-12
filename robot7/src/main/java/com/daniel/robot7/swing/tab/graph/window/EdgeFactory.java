/**
 * Package crawler.gui.swing.tab.graph
 *
 **/
package robot.gui.swing.tab.graph.window;

import org.apache.commons.collections15.Factory;

/**
 * A factory for creating Edge objects.
 *
 * @author Daniel Žažo
 * @date 10. 3. 2015
 */
public class EdgeFactory implements Factory<Integer> {

	/** The counter. */
	private int	counter;

	/**
	 * Instantiates a new edge factory.
	 */
	public EdgeFactory() {
		counter = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.commons.collections15.Factory#create()
	 */
	@Override
	public Integer create() {
		return counter++;
	}

}
