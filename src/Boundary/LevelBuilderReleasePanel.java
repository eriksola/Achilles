package Boundary;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Controller.ReturnToBuilderMenuController;

public class LevelBuilderReleasePanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	JFrame mainFrame;
	JButton exit;
	/**
	 * Create the panel.
	 */
	public LevelBuilderReleasePanel(JFrame f) {
		setBackground(new Color(173, 216, 230));
		this.mainFrame = f;
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(173, 216, 230));
		add(panel);
		
		JLabel lblLightningLevelbuilder = new JLabel("Release Build");
		lblLightningLevelbuilder.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		
		JButton button = new JButton("Exit");
		this.exit = button;
		JButton button_1 = new JButton("Horizontal");
		
		JButton button_2 = new JButton("Vertical");
		
		JButton button_3 = new JButton("90");
		
		JButton button_4 = new JButton("Add Hint");
		
		JScrollPane scrollPane = new JScrollPane();
		
		BoardView boardView = new BoardView();
		
		JButton button_5 = new JButton("Undo");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("x");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton button_6 = new JButton("Redo");
		
		JButton button_7 = new JButton("Save");
		
		JButton button_8 = new JButton("Delete Square");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
								.addComponent(lblLightningLevelbuilder, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(button_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(button_2)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(button_3)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(button_4)))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)
						.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(button_5)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(button_6)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(button_7)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(button_8))))
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblLightningLevelbuilder)
							.addComponent(button))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_1)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_2)
						.addComponent(button_3)
						.addComponent(button_4)
						.addComponent(button_8)
						.addComponent(button_7)
						.addComponent(button_6)
						.addComponent(button_5))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
							.addGap(0, 10, Short.MAX_VALUE))
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)))
		);
		panel.setLayout(gl_panel);

		this.exit.addActionListener(new ReturnToBuilderMenuController((LevelBuilderFrame) mainFrame));
		}

}
