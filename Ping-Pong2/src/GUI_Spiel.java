
/*
 * @author Roshy Moongathottathil & Sebastian Pilz 
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/*
 * Design des Spiels
 */
public class GUI_Spiel extends JLabel {
	private JPanel contentPane;
	private JLabel lblSpielerHat;

	public GUI_Spiel() {

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// setzt die Farbe des Fensters
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Var.screenwidth, Var.screenheight);

		// setzt die Farbe des Textes
		g.setColor(Color.WHITE);
		for (int i = 0; i <= 8; i++) {
			g.fillRect(Var.screenwidth / 2 - 20, i * 70, 14, 50);
		}
		// setzt die Farbe der Spielfiguren & zeigt sie auf dem Fenster
		g.fillRect(Var.xsp1, 0, 20, 1000); // x = 20,y = 250
		g.fillRect(Var.xsp2, Var.ysp2, 25, 150);// x = 957,y = 250

		// zeigt die Punkte auf dem Fenster
		g.drawString("" + Var.player1points, Var.screenwidth / 2 - 95, 75);
		g.drawString("" + Var.player2points, Var.screenwidth / 2 + 50, 75);
		// g.setFont(new Font( "Arial",Font.PLAIN,30));

		// Zeichnet den Ball
		g.fillRect(Var.ballx, Var.bally, 20, 20);

		// gibt an das spieler 1 gewonnen hat
		if (Var.player1points == 7 && Var.abc == false) {
			Var.jf1 = new JFrame();
			Var.jf1.setSize(Var.screenwidth, Var.screenheight);
			Var.jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Var.jf1.getContentPane().setLayout(new BorderLayout());
			Var.jf1.setResizable(true);
			Var.jf1.setVisible(true);
			Var.jf1.setLocationRelativeTo(null);
			Var.jf1.addKeyListener(new Tasten());
			Var.jf1.requestFocus();
			contentPane = new JPanel();
			contentPane.setBackground(Color.BLACK);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			lblSpielerHat = new JLabel("Spieler  1 hat Gewonnen");
			lblSpielerHat.setFont(new Font("Arial", Font.PLAIN, 30));
			lblSpielerHat.setBounds(220, 98, 335, 331);
			lblSpielerHat.setForeground(Color.WHITE);
			contentPane.add(lblSpielerHat);
			Var.jf1.add(contentPane, BorderLayout.CENTER);
			Var.abc = true;
		}

		// gibt an das spieler 2 gewonnen hat
		if (Var.player2points == 7 && Var.abc == false) {
			Var.jf1 = new JFrame();
			Var.jf1.setSize(Var.screenwidth, Var.screenheight);
			Var.jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Var.jf1.getContentPane().setLayout(new BorderLayout());
			Var.jf1.setResizable(true);
			Var.jf1.setVisible(true);
			Var.jf1.setLocationRelativeTo(null);
			Var.jf1.addKeyListener(new Tasten());
			Var.jf1.requestFocus();
			contentPane = new JPanel();
			contentPane.setBackground(Color.BLACK);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			lblSpielerHat = new JLabel("Spieler  2 hat Gewonnen");
			lblSpielerHat.setFont(new Font("Arial", Font.PLAIN, 30));
			lblSpielerHat.setBounds(220, 98, 335, 331);
			lblSpielerHat.setForeground(Color.WHITE);
			contentPane.add(lblSpielerHat);
			Var.jf1.add(contentPane, BorderLayout.CENTER);
			Var.abc = true;
		}
		// wenn sich die Figuren bewegen wird das erste Bild gelöscht und das
		// zweite erstellt
		repaint();

	}
}
