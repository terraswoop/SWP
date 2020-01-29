import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class GUI implements ActionListener{
	JFrame jf;
	JFormattedTextField tf;
	JComboBox<String[]> jc;
	String[] options ={"Reines Drehteil","Teilweises Drehteil","Kein Drehteil"};
	JLabel o,m,d;
	JButton b,s,r;
	int objectheight;
	int mode;
	int center;
		void Label() {
		jf = new JFrame();
		jf.setTitle("3D-Scanner");
		jf.setSize(400, 500);
		o = new JLabel();
		m=new JLabel();
		d=new JLabel();
		o.setBounds(80, 70, 250, 20);
		m.setBounds(90, 130, 250, 20);
		d.setBounds(60, 350, 250, 20);
		o.setText("Enter Object-Height (mm)");
		m.setText("Choose Scan-Mode");
		d.setText("Distance to Center: "+readData()+" mm");
		o.setFont(new Font("Calibri", Font.PLAIN, 20));
		m.setFont(new Font("Calibri", Font.PLAIN, 20));
		d.setFont(new Font("Calibri", Font.PLAIN, 20));
		tf = new JFormattedTextField();;
		tf.setBounds(100, 100, 150, 20);
		jc = new JComboBox(options);
		jc.setBounds(100, 160, 150, 20);
		b = new JButton("Set");
		b.setBounds(120, 200, 95, 30);
		s=new JButton("Send to Arduino");
		s.setBounds(70,250,200,30);
		r=new JButton("Refresh");
		r.setBounds(120,380,100,30);
		PopupFactory factory = PopupFactory.getSharedInstance();
		Popup popup=factory.getPopup(jf, new JTextField("Enter an Integer number!"), 400, 250);
		r.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				d.setText("Distance to Center: "+readData()+" mm");
				SwingUtilities.updateComponentTreeUI(jf);
				jf.setVisible(true);
			}
		});
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					formatInt();
					try (PrintWriter out = new PrintWriter("config.txt")) {
					    out.println(objectheight);
						out.println(mode);
						System.out.println(objectheight+" "+mode);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					popup.hide();
				}
				catch(Exception e) {
					e.printStackTrace();
					popup.show();
				}	
			}
		});
		jf.add(b);
		jf.add(s);
		jf.add(r);
		jf.add(tf);
		jf.add(o);
		jf.add(m);
		jf.add(d);
		jf.add(jc);
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	String readData(){
		try {
		Scanner sc=new Scanner(new File("arduinodata.txt"));
		while(sc.hasNextLine()) {
		  String s= sc.nextLine();
		  center=Integer.parseInt(s);
		  sc.close();
		  return s;
		}
		sc.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return "0";
	}
	public void formatInt() {
		objectheight=Integer.parseInt(tf.getText());
		mode=jc.getSelectedIndex();
	}
	public static void main(String[] args) {
		new GUI().Label();
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
