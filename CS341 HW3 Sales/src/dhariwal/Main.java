package dhariwal;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Main {

	private JFrame frame;
	private JTextField Kya;
	private JTextField KitneKaHai;
	private JTextField Kitne;
	private JTextField Hisaab;
	private JButton btnAdd;
	private JTextArea Parchi;
	private double loopaddcount = 0; //counter for total bill of items
	private double loopaddcost = 0; //counter to take the cost the considered item
	private double loopaddquant = 0; //counter to take quantity of the considered item
	Total Bill = new Total();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
		createEvents();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sales List");
		lblNewLabel.setBounds(193, 6, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Item:");
		lblNewLabel_1.setBounds(83, 38, 37, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		Kya = new JTextField(); //Kya = 'what' in Hindi (what item)
		Kya.setBounds(152, 34, 229, 26);
		frame.getContentPane().add(Kya);
		Kya.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cost:");
		lblNewLabel_2.setBounds(83, 66, 37, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		KitneKaHai = new JTextField(); //KitneKaHai = 'what's it's cost' in Hindi
		KitneKaHai.setBounds(152, 61, 177, 26);
		frame.getContentPane().add(KitneKaHai);
		KitneKaHai.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Quantity:");
		lblNewLabel_3.setBounds(83, 94, 61, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		Kitne = new JTextField(); //Kitne = 'How many' in Hindi
		Kitne.setBounds(152, 89, 130, 26);
		frame.getContentPane().add(Kitne);
		Kitne.setColumns(10);
		
		btnAdd = new JButton("The Magic Button that Adds");
		btnAdd.setBounds(125, 123, 205, 29);
		frame.getContentPane().add(btnAdd);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(97, 157, 284, 115);
		frame.getContentPane().add(scrollPane);
		
		Parchi = new JTextArea(); //Parchi = reciept in Hindi
		scrollPane.setViewportView(Parchi);
		
		JLabel lblNewLabel_4 = new JLabel("Total Sale:");
		lblNewLabel_4.setBounds(11, 159, 65, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		Hisaab = new JTextField(); //Hisaab = kind of like 'total purchase/cost' in Hindi
		Hisaab.setBounds(6, 176, 79, 26);
		frame.getContentPane().add(Hisaab);
		Hisaab.setColumns(10);
	}
	
	private void createEvents() //property of Trish Cornez
	{ //method when Add Button is clicked
		btnAdd.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				Khareedari(); //actual method for adding items
			}
		});
	}
	
	public void Khareedari() { //Khareedari means purchase in Hindi :)
		loopaddcost = Double.parseDouble(KitneKaHai.getText()); //this count is set to a new value every time a new item is added
		loopaddquant = Double.parseDouble(Kitne.getText()); //this count is set to a new value every time a new item is added
		loopaddcount += loopaddcost*loopaddquant; //keeping track of the total bill
		String result = ""; //resultant CVS bill string ;P
		String total = ""; //resultant total cost
		
		Items cheez = new Items(); //cheez = 'thing' in Hindi
		
		String itm = Kya.getText(); //String to contain name of the item
		String cost = KitneKaHai.getText(); //String to contain cost of the item
		String quant = Kitne.getText(); //String to contain quantity of the item
		Bill.raseed(cheez.reciept(itm, cost, quant)); //adding the info to the Bill List
		
		for (int i = 0; i < Bill.size(); i++)
		{
			result += Bill.get(i); //adding the bill info to the resultant String
		}
		
		Parchi.setText(result);
		total = Double.toString(loopaddcount);
		Hisaab.setText("$" + total);
	}
}
