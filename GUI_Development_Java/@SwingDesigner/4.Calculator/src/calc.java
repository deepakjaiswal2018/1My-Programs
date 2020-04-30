import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class calc {
	
	private JFrame frame;
	private JTextField ans;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calc window = new calc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public calc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 757, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton b7 = new JButton("7");
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
			}
		});
		b7.setBounds(43, 123, 89, 23);
		frame.getContentPane().add(b7);
		
		JButton b8 = new JButton("8");
		b8.setBounds(184, 123, 89, 23);
		frame.getContentPane().add(b8);
		
		JButton b9 = new JButton("9");
		b9.setBounds(332, 123, 89, 23);
		frame.getContentPane().add(b9);
		
		JButton bplus = new JButton("+");
		bplus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		bplus.setBounds(591, 123, 89, 23);
		frame.getContentPane().add(bplus);
		
		ans = new JTextField();
		ans.setFont(new Font("Consolas", Font.BOLD, 32));
		ans.setBounds(43, 22, 378, 43);
		frame.getContentPane().add(ans);
		ans.setColumns(10);
		
		JButton bminus = new JButton("-");
		bminus.setBounds(591, 179, 89, 23);
		frame.getContentPane().add(bminus);
		
		JButton bmul = new JButton("x");
		bmul.setBounds(591, 234, 89, 23);
		frame.getContentPane().add(bmul);
		
		JButton bdiv = new JButton("/");
		bdiv.setBounds(591, 288, 89, 23);
		frame.getContentPane().add(bdiv);
		
		JButton b4 = new JButton("4");
		b4.setBounds(43, 179, 89, 23);
		frame.getContentPane().add(b4);
		
		JButton b5 = new JButton("5");
		b5.setBounds(184, 179, 89, 23);
		frame.getContentPane().add(b5);
		
		JButton b6 = new JButton("6");
		b6.setBounds(332, 179, 89, 23);
		frame.getContentPane().add(b6);
		
		JButton b1 = new JButton("1");
		b1.setBounds(43, 234, 89, 23);
		frame.getContentPane().add(b1);
		
		JButton b2 = new JButton("2");
		b2.setBounds(184, 234, 89, 23);
		frame.getContentPane().add(b2);
		
		JButton b3 = new JButton("3");
		b3.setBounds(332, 234, 89, 23);
		frame.getContentPane().add(b3);
		
		JButton bclr = new JButton("Clear");
		bclr.setBounds(424, 355, 89, 23);
		frame.getContentPane().add(bclr);
	}
}