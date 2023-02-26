package windows.utilities.convertidores;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConversorMultiBase {

	private JPanel contentPanel;
	private JTextField decimalValue;
	private JTextField nBaseValue;
	private JTextField baseValue;

	public ConversorMultiBase() {
		contentPanel = new JPanel();
		contentPanel.setLayout(null);
		
		JPanel decPanel = new JPanel();
		decPanel.setLayout(null);
		decPanel.setBounds(26, 194, 852, 153);
		contentPanel.add(decPanel);
		
		decimalValue = new JTextField();
		decimalValue.setFont(new Font("Dialog", Font.PLAIN, 22));
		decimalValue.setColumns(10);
		decimalValue.setBounds(10, 10, 275, 46);
		decPanel.add(decimalValue);
		
		nBaseValue = new JTextField();
		nBaseValue.setFont(new Font("Dialog", Font.PLAIN, 22));
		nBaseValue.setColumns(10);
		nBaseValue.setBounds(10, 97, 275, 46);
		decPanel.add(nBaseValue);
		
		JButton decToNbaseBut = new JButton("A Base: ");
		decToNbaseBut.setFont(new Font("Dialog", Font.PLAIN, 22));
		decToNbaseBut.setBounds(351, 10, 199, 45);
		decToNbaseBut.addActionListener(new ToNbaseNumber());
		decPanel.add(decToNbaseBut);

		JButton binToDecimalBut = new JButton("A Decimal");
		binToDecimalBut.setFont(new Font("Dialog", Font.PLAIN, 22));
		binToDecimalBut.setBounds(351, 96, 199, 47);
		binToDecimalBut.addActionListener(new ToDecimal());
		decPanel.add(binToDecimalBut);

		JLabel lblNewLabel = new JLabel("Base: ");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabel.setBounds(587, 63, 63, 25);
		decPanel.add(lblNewLabel);

		baseValue = new JTextField();
		baseValue.setFont(new Font("Dialog", Font.PLAIN, 22));
		baseValue.setColumns(10);
		baseValue.setBounds(660, 53, 151, 46);
		baseValue.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				decToNbaseBut.setText("A base: " + baseValue.getText());
			}
		});
		decPanel.add(baseValue);
	}

	class ToDecimal implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				Double base = Double.parseDouble(baseValue.getText());
				String nbaseNum = nBaseValue.getText();
				nbaseNum = nbaseNum.replaceAll("\s", "");
				int decNum = 0, cont = nbaseNum.length();
				for (char c : nbaseNum.toCharArray()) {
					decNum += letterToNum(c) * Math.pow(base, --cont);
				}
				decimalValue.setText(String.valueOf(decNum));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		private int letterToNum(char c) {
			String digit = String.valueOf(c).toUpperCase();
			switch (digit) {
			case "A":
				return 10;
			case "B":
				return 11;
			case "C":
				return 12;
			case "D":
				return 13;
			case "E":
				return 14;
			case "F":
				return 15;
			default:
				return Integer.parseInt(digit);
			}
		}
	}

	class ToNbaseNumber implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				String decNum = decimalValue.getText();
				String[] decNumSplited = decNum.split("\\.");
				double decNum1 = 0, decNum2 = 0;
				double base = Double.parseDouble(baseValue.getText());
		        String resNum1 = "", resNum2 = "";
				if (decNum.contains(".")) {
					decNum1 = Double.parseDouble(decNum.split("\\.")[0]);
					decNum2 = Double.parseDouble("0." + decNum.split("\\.")[1]);
				}if (decNum.contains(",")) {
					decNum1 = Double.parseDouble(decNum.split("\\,")[0]);
					decNum2 = Double.parseDouble("0." + decNum.split("\\,")[1]);
				} else {
					decNum1 = Double.parseDouble(decNum);
				}		        
		        
		        while (decNum1 > 0) {
		            decNum1 /= base;
		            resNum1 = numToLetter((int) ((decNum1 - Math.floor(decNum1)) * base)) + resNum1;
		            decNum1 = Math.floor(decNum1);
		        }
		        
		        while (decNum2 > 0) {
		            decNum2 *= base;
		            resNum2 += numToLetter((int) (Math.floor(decNum2)));
		            decNum2 = decNum2 - Math.floor(decNum2);
		        }
		        
		        if ("".equals(resNum2)) {
		        	nBaseValue.setText(resNum1);
		        } else {
		        	nBaseValue.setText(resNum1 + "." + resNum2);
		        }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		private String numToLetter(int num) {
			switch (num) {
			case 10:
				return "A";
			case 11:
				return "B";
			case 12:
				return "C";
			case 13:
				return "D";
			case 14:
				return "E";
			case 15:
				return "F";
			default:
				return String.valueOf(num);
			}
		}
	}

	public static JPanel getContentPanel() {
		ConversorMultiBase obj = new ConversorMultiBase();
		return obj.contentPanel;
	}
}
