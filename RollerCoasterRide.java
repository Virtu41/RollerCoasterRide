import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RollerCoasterRide extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldHeight;
	private JTextField textFieldBack;
	private JTextField textFieldHeart;
	private JTextField textFieldOutput;
	private JLabel lblHeight;
	private JLabel lblBack;
	private JLabel lblHeart;
	private JButton btnCalculate;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RollerCoasterRide frame = new RollerCoasterRide();
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
	public RollerCoasterRide() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 438, 265);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblRollerCoaster = new JLabel("RollerCoaster Ride ");
		lblRollerCoaster.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRollerCoaster.setBounds(147, 31, 131, 14);
		panel.add(lblRollerCoaster);

		textFieldHeight = new JTextField();
		textFieldHeight.setBounds(243, 77, 106, 20);
		panel.add(textFieldHeight);
		textFieldHeight.setColumns(10);

		textFieldBack = new JTextField();
		textFieldBack.setBounds(243, 112, 106, 20);
		panel.add(textFieldBack);
		textFieldBack.setColumns(10);

		textFieldHeart = new JTextField();
		textFieldHeart.setBounds(243, 146, 106, 20);
		panel.add(textFieldHeart);
		textFieldHeart.setColumns(10);

		textFieldOutput = new JTextField();
		textFieldOutput.setBounds(60, 187, 289, 20);
		panel.add(textFieldOutput);
		textFieldOutput.setColumns(10);

		lblHeight = new JLabel("Height in cm?");
		lblHeight.setBounds(60, 80, 108, 14);
		panel.add(lblHeight);

		lblBack = new JLabel("Back Trouble (Y/N)");
		lblBack.setBounds(60, 115, 119, 14);
		panel.add(lblBack);

		lblHeart = new JLabel("Heart Trouble (Y/N)");
		lblHeart.setBounds(60, 149, 119, 14);
		panel.add(lblHeart);

		btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					//initialize variables
					String heightS, backS, heartS;
					int a;
					double height;
					heightS = textFieldHeight.getText();
					backS = textFieldBack.getText().toLowerCase();
					heartS = textFieldHeart.getText().toLowerCase();
					height = Double.parseDouble(heightS);
					char backTrouble = backS.charAt(0);
					char heartTrouble = heartS.charAt(0);
					
					//checks for negative height
					if(height<0) {
						a = 1/0;
					}
					
					//checks for heart, back problems and height that is outside the range.
					else if((int)backTrouble == 121 || (int)heartTrouble == 121 || height<=122 || height>=188) {
						
						//output
						textFieldOutput.setText("Sorry, it is not safe for you to ride this roller coaster.");
					}
					
					//checks for heart, back problems and height within range
					else if(height>122 && height<188 && (int)backTrouble== 110 && (int)heartTrouble== 110) {
						
						//output
						textFieldOutput.setText("It is OK for you to ride this roller coaster. Have fun!");
					}
					else {
						a = 1/0;
					}
				}
				catch(Exception err) {
					
					//error output
					textFieldOutput.setText("Please use proper input.");
				}
			}


		});
		btnCalculate.setBounds(88, 218, 91, 23);
		panel.add(btnCalculate);

		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(219, 218, 91, 23);
		panel.add(btnExit);
	}
}
