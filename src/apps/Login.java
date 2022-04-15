package apps;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login {

	public static void main(String[] args) {
		new Log();
	}
}

class Log extends JFrame implements ActionListener {
	JLabel Label_Name, Label_Pass, correct;
	JTextField T1;
	JPasswordField Pass;
	JButton ok, cancel;
	
	private int tries = 3;
	
	public Log() {
		
		super("Sign-In");
		Label_Name = new JLabel("User Name: ");
		T1 = new JTextField(15);
		add(Label_Name);
		add(T1);
		
		Label_Pass = new JLabel("Password:  ");
		Pass = new JPasswordField(15);
		add(Label_Pass);
		add(Pass);
		
		ok = new JButton("sign-In");
		add(ok);
		cancel = new JButton("Cancel");
		add(cancel);
		
		correct = new JLabel("");
		add(correct);
		
		setLayout(new FlowLayout());
		setVisible(true);
		
		setSize(290, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ok.addActionListener(this);
		cancel.addActionListener(this);
		
	}
	
	@SuppressWarnings("deprecation")
	public void actionPerformed (ActionEvent a) {
		String name = T1.getText();
		String pass = Pass.getText();

		if(a.getSource().equals(ok)) {
			tries--;
			if(name.equals("admin") && pass.equals("123")) {
				correct.setText("Welcome to your profile");
				System.out.println("Success");
			}else if(!name.equals(null) && !pass.equals(null)) {
					correct.setText("Invalid Username or Password " + tries + " more tries");
					System.out.println(tries);
					if(tries == 0) {
						T1.setEnabled(false);
						T1.setText("");
						System.out.println("True");
						Pass.setEnabled(false);
						Pass.setText("");
						System.out.println("True");
						ok.setEnabled(false);
						System.out.println("True");	
						cancel.setEnabled(false);
						System.out.println("True");
						correct.setText("Invalid Username or Password " + tries + " more tries");
						JOptionPane.showMessageDialog(null, "Account is locked.", "Alert!", JOptionPane.ERROR_MESSAGE);
						correct.setText("Please contact the administrator.");
					}
				}
		}
		if(a.getSource().equals(cancel)) {
			T1.setText("");
			Pass.setText("");
			correct.setText("");
		}
	}
}