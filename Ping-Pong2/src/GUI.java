/*
 * @author Roshy Moongathottathil & Sebastian Pilz 
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
/*
 * Design der Startseite
 */
public class GUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblPingpong;
	private JButton btnNewButton;
	private JTextPane txtpnSpieler;
	private JTextPane txtpnWS;
	private JTextPane txtpnSpieler_1;
	private JTextPane txtpnPfeilObenPfeil;
	private JMenuBar menuBar;
	private JMenu mnDatei;
	private JMenuItem mntmStartGame;

	public GUI() {
		los();
	}

	private void spiel() {
		Var.jf1 = new JFrame();
		Var.jf1.setSize(Var.screenwidth, Var.screenheight);
		Var.jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Var.jf1.getContentPane().setLayout(null);
		Var.jf1.setResizable(false);
		Var.jf1.setVisible(true);
		Var.jf1.setLocationRelativeTo(null);
		Var.jf1.addKeyListener(new Tasten());
		Var.jf1.requestFocus();

		GUI_Spiel lbldraw = new GUI_Spiel();
		lbldraw.setBounds(0, 0, Var.screenwidth, Var.screenheight);
		lbldraw.setVisible(true);
		Var.jf1.getContentPane().add(lbldraw);
		Main.start=System.currentTimeMillis();
	}

	private void los() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnDatei = new JMenu("Datei");
		mnDatei.setFont(new Font("Arial", Font.PLAIN, 15));
		menuBar.add(mnDatei);

		
		mntmStartGame = new JMenuItem("Start Game...");
		mntmStartGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnDatei.add(mntmStartGame);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		//überschrifft Ping-Pong
		lblPingpong = new JLabel("Ping-Pong");
		lblPingpong.setFont(new Font("Arial", Font.PLAIN, 30));
		lblPingpong.setForeground(Color.WHITE);
		lblPingpong.setBackground(Color.BLACK);
		lblPingpong.setBounds(303, 38, 400, 74);
		contentPane.add(lblPingpong);

		//Knopf Start Game 
		btnNewButton = new JButton("Start Game");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(615, 268, 155, 87);
		contentPane.add(btnNewButton);

		//Wenn Start taste gedrückt wurde soll das Spiel gestart werden
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton gedruckt = (JButton) e.getSource();
				if (gedruckt == btnNewButton) {
					setVisible(false);
					spiel();
				}
			}
		});

		txtpnSpieler = new JTextPane();
		txtpnSpieler.setText("Spieler1:");
		txtpnSpieler.setBounds(12, 204, 129, 32);
		contentPane.add(txtpnSpieler);

		txtpnWS = new JTextPane();
		txtpnWS.setText("W, S");
		txtpnWS.setBounds(12, 249, 129, 32);
		contentPane.add(txtpnWS);

		txtpnSpieler_1 = new JTextPane();
		txtpnSpieler_1.setText("Spieler2:");
		txtpnSpieler_1.setBounds(12, 307, 129, 32);
		contentPane.add(txtpnSpieler_1);

		txtpnPfeilObenPfeil = new JTextPane();
		txtpnPfeilObenPfeil.setText("Pfeil oben, Pfeil unten");
		txtpnPfeilObenPfeil.setBounds(12, 352, 129, 38);
		contentPane.add(txtpnPfeilObenPfeil);
	}
}
