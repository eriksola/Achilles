package Boundary;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Controller.GetTextController;
import Controller.ReturnToBuilderMenuController;
import Controller.SaveController;
import Game.Board;
import Game.BullPen;
import Game.Stock;
import Game.Tile;

public class EditLightningLevelPanel extends KabaSuji {
	
	JTextField x_text;
	JTextField y_text;
	JButton exit;
	JButton save;
	JButton btnEnter;
	JFrame mainFrame;
	int levelNum;
	BullPen bp;
	Board board;
	Stock s = new Stock();
	
	/**
	 * Create the panel.
	 */
	public EditLightningLevelPanel(JFrame f, Deserialization d, int levelNumber) {
		Tile[][] brdTiles = d.getBoard().getTiles();
	
		this.board = d.getBoard();
		setBackground(new Color(173, 216, 230));
		this.mainFrame = f;
		
		bp = new BullPen(d.getPieces());
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(173, 216, 230));
		add(panel);
		
		JLabel lblLightningBuild = new JLabel("Lightning Build");
		lblLightningBuild.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		
		JButton exitbtn = new JButton("Exit");
		this.exit = exitbtn;
		
		JButton horizontal = new JButton("Horizontal");
		
		JButton vertical = new JButton("Vertical");
		
		JButton rightrotate = new JButton("90");
		
		JButton hint = new JButton("Add Hint");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton undo = new JButton("Undo");
		
		x_text = new JTextField();
		x_text.setColumns(10);
		
		BoardView boardView = new BoardView(mainFrame, board, this);
		
		JLabel label_1 = new JLabel("x");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		y_text = new JTextField();
		y_text.setColumns(10);
		
		JButton redo = new JButton("Redo");
		
		JButton save = new JButton("Save");
		this.save = save;
		JButton delete = new JButton("Delete Square");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JButton enter = new JButton("Enter n x m");
		this.btnEnter = enter;
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblLightningBuild, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(18)
								.addComponent(exitbtn))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(horizontal)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(vertical)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(rightrotate)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(hint)))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)
						.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(undo)
								.addComponent(x_text, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(y_text, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(enter))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(redo)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(save)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(delete))))
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblLightningBuild)
							.addComponent(exitbtn))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_1)
							.addComponent(x_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(y_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(enter)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(horizontal)
						.addComponent(vertical)
						.addComponent(rightrotate)
						.addComponent(hint)
						.addComponent(delete)
						.addComponent(save)
						.addComponent(redo)
						.addComponent(undo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
							.addGap(0, 10, Short.MAX_VALUE))
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)))
		);
		
		JPanel bullpen = new BullPenView(mainFrame, bp, this);
		scrollPane.setViewportView(bullpen);
		panel.setLayout(gl_panel);
		
		this.exit.addActionListener(new ReturnToBuilderMenuController((LevelBuilderFrame) mainFrame));
		this.save.addActionListener(new SaveController(bp.getPieces(), board, 2, levelNum));
		this.btnEnter.addActionListener(new GetTextController(x_text, y_text));
	}
}
