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
	static JFrame jf;
	static JFormattedTextField tf;
	static JComboBox<String[]> jc,jcom;
	static String[] options ={"Reines Drehteil","Teilweises Drehteil","Kein Drehteil"};
	static String[] coms= {"COM1","COM2","COM3","COM4","COM5","COM6","COM7"};
	static JLabel o,m,d;
	static JButton b,s,r;
	static int objectheight;
	static int mode;
	static int center;
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
		jcom=new JComboBox(coms);
		jc.setBounds(100, 160, 150, 20);
		jcom.setBounds(100, 30, 150, 20);
		b = new JButton("Set current values");
		b.setBounds(100, 200, 150, 30);
		s=new JButton("Send to Arduino");
		s.setBounds(75,250,200,30);
		r=new JButton("Refresh");
		r.setBounds(120,380,100,30);
		PopupFactory factory = PopupFactory.getSharedInstance();
		Popup popup=factory.getPopup(jf, new JTextField("Enter an Integer number!"), 400, 250);
		s.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					PortWriter.write();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		r.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				d.setText("Distance to Center: "+readData()+" mm");
				SwingUtilities.updateComponentTreeUI(jf);
				readConfigData();
				SwingUtilities.updateComponentTreeUI(jcom);
				SwingUtilities.updateComponentTreeUI(tf);
				SwingUtilities.updateComponentTreeUI(jc);
				jf.setVisible(true);
			}
		});
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					formatInt();
					try (PrintWriter out = new PrintWriter("config.txt")) {
					    out.println(jcom.getSelectedIndex());
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
		jf.add(jcom);
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
	void readConfigData() {
		try {
			Scanner sc=new Scanner(new File("config.txt"));
			if(sc.hasNextLine()) {
				jcom.setSelectedIndex(Integer.parseInt(sc.nextLine()));
			}
			if(sc.hasNextLine()) {
				tf.setText(sc.nextLine());
			}
			if(sc.hasNextLine()) {
				jc.setSelectedIndex(Integer.parseInt(sc.nextLine()));
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
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
