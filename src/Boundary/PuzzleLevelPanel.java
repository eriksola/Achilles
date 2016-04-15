package Boundary;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import Controller.ReturnToDefMenuController;

public class PuzzleLevelPanel extends JPanel {

	KabasujiFrame mainframe;
	JButton lvlMenuBtn;
	JButton helpBtn;
	/**
	 * Create the panel.
	 */
	public PuzzleLevelPanel(KabasujiFrame f) {
		setBackground(new Color(173, 216, 230));
		
		this.mainframe = f;
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(173, 216, 230));
		add(panel);
		
		JButton button = new JButton("Back");
		this.lvlMenuBtn = button;
		
		JLabel label = new JLabel("Level");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		
		JButton button_1 = new JButton("Help");
		this.helpBtn = button_1;
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton button_2 = new JButton("Horizontal");
		
		JButton button_3 = new JButton("Vertical");
		
		BoardView boardView = new BoardView();
		
		JButton button_4 = new JButton("90");
		
		JButton button_5 = new JButton("Reset");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 751, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(button_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_4))
						.addComponent(button)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(67)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label)
									.addGap(298)
									.addComponent(button_1))
								.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(button_5)
							.addGap(112))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 438, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(label))
						.addComponent(button_1))
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_5))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
							.addGap(16)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(button_2)
								.addComponent(button_3)
								.addComponent(button_4))))
					.addGap(32))
		);
		panel.setLayout(gl_panel);
		ReturnToDefMenuController n; 
		
		//activate controllers for buttons
		lvlMenuBtn.addActionListener(new ReturnToDefMenuController(mainframe));
		helpBtn.addActionListener(new PlayPuzzletoPuzzleRulesController(mainframe));
	}
	
	public JButton getLevelMenuButton(){
		return lvlMenuBtn;
	}
}
