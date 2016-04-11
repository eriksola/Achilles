package Boundary;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class BullPenView extends JPanel {

	/**
	 * Create the panel.
	 */
	public BullPenView() {
		setBackground(new Color(255, 255, 255));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 133, Short.MAX_VALUE)
		);
		setLayout(groupLayout);

	}

}
