import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * 
 * 
 * Main frame of the game - contains all elements of the game view: score board,
 * actual game (gamePanel)
 *
 */
public class GameFrame extends JFrame {

	private JPanel contentPane;

	public GameFrame(int width, int height) {
		/**
		 * basic setting for the frame
		 */
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, width, height);

		// JPanel containing the two elements: score board + actual game panel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel menuPanel = new JPanel();
		contentPane.add(menuPanel, BorderLayout.NORTH);

		// Score/message panel
		JLabel lblLuciaIsThe = new JLabel("Score: ");
		lblLuciaIsThe.setHorizontalAlignment(SwingConstants.LEFT);
		menuPanel.add(lblLuciaIsThe);
		JLabel scoreLabel = new JLabel("1:3 (dummy text - replace me)");
		menuPanel.add(scoreLabel);

		// My custom JPanel (GamePanel) that contains all graphics and behaviour
		// for the game
		// JPanel gamePanel = new JPanel();
		GamePanel gamePanel = new GamePanel();
		gamePanel.setForeground(Color.BLACK);
		contentPane.add(gamePanel, BorderLayout.CENTER);
		this.setVisible(true);

	}
}
