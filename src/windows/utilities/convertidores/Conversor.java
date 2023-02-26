package windows.utilities.convertidores;

import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Conversor {

	private JPanel contentPanel;
	private JTextField decimalValue1;
	private JTextField hexValue;
	private JTextField decimalValue2;
	private JTextField octValue;
	private JTextField decimalValue3;
	private JTextField binaryValue;

	private Conversor() {
		contentPanel = new JPanel();
		contentPanel.setLayout(null);

		JLabel titleLabel = new JLabel("Conversores");
		titleLabel.setFont(new Font("Dialog", Font.BOLD, 40));
		titleLabel.setBounds(25, 10, 275, 52);
		contentPanel.add(titleLabel);

		JPanel hexPanel = new JPanel();
		hexPanel.setBounds(276, 75, 560, 153);
		contentPanel.add(hexPanel);
		hexPanel.setLayout(null);

		decimalValue1 = new JTextField();
		decimalValue1.setFont(new Font("Dialog", Font.PLAIN, 22));
		decimalValue1.setBounds(10, 10, 275, 46);
		hexPanel.add(decimalValue1);
		decimalValue1.setColumns(10);

		hexValue = new JTextField();
		hexValue.setBounds(10, 97, 275, 46);
		hexValue.setFont(new Font("Dialog", Font.PLAIN, 22));
		hexValue.setColumns(10);
		hexPanel.add(hexValue);

		JButton decToHexBut = new JButton("A Hexadecimal");
		decToHexBut.setFont(new Font("Dialog", Font.PLAIN, 22));
		decToHexBut.setBounds(351, 10, 199, 45);
		decToHexBut.addActionListener(new DecToHex());
		hexPanel.add(decToHexBut);

		JButton hexToDecimalBut = new JButton("A Decimal");
		hexToDecimalBut.setBounds(351, 96, 199, 47);
		hexToDecimalBut.setFont(new Font("Dialog", Font.PLAIN, 22));
		hexToDecimalBut.addActionListener(new HexToDecimal());
		hexPanel.add(hexToDecimalBut);

		JPanel octPanel = new JPanel();
		octPanel.setLayout(null);
		octPanel.setBounds(276, 308, 560, 153);
		contentPanel.add(octPanel);

		decimalValue2 = new JTextField();
		decimalValue2.setFont(new Font("Dialog", Font.PLAIN, 22));
		decimalValue2.setColumns(10);
		decimalValue2.setBounds(10, 10, 275, 46);
		octPanel.add(decimalValue2);

		octValue = new JTextField();
		octValue.setFont(new Font("Dialog", Font.PLAIN, 22));
		octValue.setColumns(10);
		octValue.setBounds(10, 97, 275, 46);
		octPanel.add(octValue);

		JButton decToOctBut = new JButton("A Octal");
		decToOctBut.setFont(new Font("Dialog", Font.PLAIN, 22));
		decToOctBut.setBounds(351, 10, 199, 45);
		decToOctBut.addActionListener(new DecToOct());
		octPanel.add(decToOctBut);

		JButton octToDecimalBut = new JButton("A Decimal");
		octToDecimalBut.setFont(new Font("Dialog", Font.PLAIN, 22));
		octToDecimalBut.setBounds(351, 96, 199, 47);
		octToDecimalBut.addActionListener(new OctToDec());
		octPanel.add(octToDecimalBut);

		JPanel decPanel = new JPanel();
		decPanel.setLayout(null);
		decPanel.setBounds(276, 530, 560, 153);
		contentPanel.add(decPanel);

		decimalValue3 = new JTextField();
		decimalValue3.setFont(new Font("Dialog", Font.PLAIN, 22));
		decimalValue3.setColumns(10);
		decimalValue3.setBounds(10, 10, 275, 46);
		decPanel.add(decimalValue3);

		binaryValue = new JTextField();
		binaryValue.setFont(new Font("Dialog", Font.PLAIN, 22));
		binaryValue.setColumns(10);
		binaryValue.setBounds(10, 97, 275, 46);
		decPanel.add(binaryValue);

		JButton decToBinBut = new JButton("A Binario");
		decToBinBut.setFont(new Font("Dialog", Font.PLAIN, 22));
		decToBinBut.setBounds(351, 10, 199, 45);
		decToBinBut.addActionListener(new DecToBin());
		decPanel.add(decToBinBut);

		JButton binToDecimalBut = new JButton("A Decimal");
		binToDecimalBut.setFont(new Font("Dialog", Font.PLAIN, 22));
		binToDecimalBut.setBounds(351, 96, 199, 47);
		binToDecimalBut.addActionListener(new BinToDec());
		decPanel.add(binToDecimalBut);

		JLabel lblBinario = new JLabel("Binario");
		lblBinario.setHorizontalAlignment(SwingConstants.CENTER);
		lblBinario.setFont(new Font("Dialog", Font.BOLD, 22));
		lblBinario.setBounds(432, 491, 232, 29);
		contentPanel.add(lblBinario);

		JLabel lblOctal = new JLabel("Octal");
		lblOctal.setHorizontalAlignment(SwingConstants.CENTER);
		lblOctal.setFont(new Font("Dialog", Font.BOLD, 22));
		lblOctal.setBounds(432, 269, 232, 29);
		contentPanel.add(lblOctal);

		JLabel lblHexadecimal = new JLabel("Hexadecimal");
		lblHexadecimal.setHorizontalAlignment(SwingConstants.CENTER);
		lblHexadecimal.setFont(new Font("Dialog", Font.BOLD, 22));
		lblHexadecimal.setBounds(432, 36, 232, 29);
		contentPanel.add(lblHexadecimal);

		JPanel infPanel = new JPanel();
		infPanel.setBounds(86, 88, 180, 133);
		contentPanel.add(infPanel);
		infPanel.setLayout(null);

		JLabel lblHexadecimal_1 = new JLabel("Hexadecimal");
		lblHexadecimal_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHexadecimal_1.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblHexadecimal_1.setBounds(10, 94, 160, 29);
		infPanel.add(lblHexadecimal_1);

		JLabel lblDecimal = new JLabel("Decimal");
		lblDecimal.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDecimal.setBounds(10, 10, 160, 29);
		infPanel.add(lblDecimal);
		lblDecimal.setFont(new Font("Dialog", Font.PLAIN, 22));

		JPanel infPanel_1 = new JPanel();
		infPanel_1.setLayout(null);
		infPanel_1.setBounds(86, 316, 180, 133);
		contentPanel.add(infPanel_1);

		JLabel lblHexadecimal_1_1 = new JLabel("Octal");
		lblHexadecimal_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHexadecimal_1_1.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblHexadecimal_1_1.setBounds(10, 94, 160, 29);
		infPanel_1.add(lblHexadecimal_1_1);

		JLabel lblDecimal_1 = new JLabel("Decimal");
		lblDecimal_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDecimal_1.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblDecimal_1.setBounds(10, 10, 160, 29);
		infPanel_1.add(lblDecimal_1);

		JPanel infPanel_2 = new JPanel();
		infPanel_2.setLayout(null);
		infPanel_2.setBounds(86, 541, 180, 133);
		contentPanel.add(infPanel_2);

		JLabel lblHexadecimal_1_2 = new JLabel("Binario");
		lblHexadecimal_1_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHexadecimal_1_2.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblHexadecimal_1_2.setBounds(10, 94, 160, 29);
		infPanel_2.add(lblHexadecimal_1_2);

		JLabel lblDecimal_2 = new JLabel("Decimal");
		lblDecimal_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDecimal_2.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblDecimal_2.setBounds(10, 10, 160, 29);
		infPanel_2.add(lblDecimal_2);

	}

	class DecToHex implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				double decNum = Integer.parseInt(decimalValue1.getText());
				String hexNum = "";

				while (decNum > 0) {
					decNum /= 16;
					hexNum = numToLetter((int) ((decNum - Math.floor(decNum)) * 16)) + hexNum;
					decNum = Math.floor(decNum);
				}
				hexValue.setText(hexNum);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		private String numToLetter(int aux) {
			switch (aux) {
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
				return String.valueOf(aux);
			}
		}
	}

	class HexToDecimal implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				String hexNum = hexValue.getText();
				hexNum = hexNum.replaceAll("\s", "");
				int decNum = 0, cont = hexNum.length();
				for (char c : hexNum.toCharArray()) {
					decNum += letterToNum(c) * Math.pow(16, --cont);
				}
				decimalValue1.setText(String.valueOf(decNum));
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

	class DecToOct implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				double decNum = Double.parseDouble(decimalValue2.getText());
				String octNum = "";

				while (decNum > 0) {
					decNum /= 8;
					octNum = (int) ((decNum - Math.floor(decNum)) * 8) + octNum;
					decNum = Math.floor(decNum);
				}

				octValue.setText(octNum);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	class OctToDec implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				String octNum = octValue.getText();
				octNum = octNum.replaceAll("\s", "");
				int decNum = 0, cont = octNum.length();
				for (char c : octNum.toCharArray()) {
					decNum += Integer.parseInt(String.valueOf(c)) * Math.pow(8, --cont);
				}
				decimalValue2.setText(String.valueOf(decNum));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	class DecToBin implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			double decNum = Double.parseDouble(decimalValue3.getText());
			String binNum = "";

			while (decNum > 0) {
				decNum /= 2;
				binNum = (int) ((decNum - Math.floor(decNum)) * 2) + binNum;
				decNum = Math.floor(decNum);
			}
			binaryValue.setText(binNum);
		}
	}

	class BinToDec implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String binNum = binaryValue.getText();
			binNum = binNum.replaceAll(" ", "");
			int decNum = 0, cont = binNum.length();
			for (char c : binNum.toCharArray()) {
				decNum += Integer.parseInt(String.valueOf(c)) * Math.pow(2, --cont);
			}
			decimalValue3.setText(String.valueOf(decNum));
		}
	}

	public static JPanel getContentPanel() {
		Conversor obj = new Conversor();
		return obj.contentPanel;
	}
}
