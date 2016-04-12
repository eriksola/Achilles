package Boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class LevelBuilderView extends JFrame {

	private JPanel contentPane;
	private JTextField row;
	private JTextField col;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelBuilderView frame = new LevelBuilderView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LevelBuilderView() {
		setTitle("LevelBuilder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 485);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblLevelbuilder = new JLabel("LevelBuilder");
		lblLevelbuilder.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		
		JButton btnHorizontal = new JButton("Horizontal");
		
		JButton btnVertical = new JButton("Vertical");
		
		JButton button = new JButton("90");
		
		JButton btnAddHint = new JButton("Add Hint");
		
		JButton btnExit = new JButton("Exit");
		
		JScrollPane bullPenStock = new JScrollPane();
		
		JPanel board = new BoardView();
		
		JButton btnDeleteSquare = new JButton("Delete Square");
		
		JButton btnSave = new JButton("Save");
		
		JButton btnRedo = new JButton("Redo");
		
		JButton btnUndo = new JButton("Undo");
		
		JLabel lblX = new JLabel("x");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		row = new JTextField();
		row.setColumns(10);
		
		col = new JTextField();
		col.setColumns(10);
		
		JScrollPane scroll_stock = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblLevelbuilder, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnExit))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnHorizontal)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnVertical)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(button)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnAddHint)))
						.addComponent(bullPenStock, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)
						.addComponent(board, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnUndo)
								.addComponent(row, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblX)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(col, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnRedo)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnSave)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnDeleteSquare))))
						.addComponent(scroll_stock, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblLevelbuilder)
							.addComponent(btnExit))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblX)
							.addComponent(row, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(col, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnHorizontal)
						.addComponent(btnVertical)
						.addComponent(button)
						.addComponent(btnAddHint)
						.addComponent(btnDeleteSquare)
						.addComponent(btnSave)
						.addComponent(btnRedo)
						.addComponent(btnUndo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(bullPenStock, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(board, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
							.addGap(0, 0, Short.MAX_VALUE))
						.addComponent(scroll_stock, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)))
		);
		
		JPanel stock = new StockView();
		scroll_stock.setViewportView(stock);
		
		JPanel bullpen = new BullPenView();
		bullPenStock.setViewportView(bullpen);
		contentPane.setLayout(gl_contentPane);
	}
}
