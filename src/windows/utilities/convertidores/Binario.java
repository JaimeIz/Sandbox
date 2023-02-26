package windows.utilities.convertidores;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class Binario {

	private JPanel contentPanel;
	private JTextField binValue;
	private JTextField DecValue;
	private JSpinner capSel;

	private Binario() {
		contentPanel = new JPanel();
		contentPanel.setLayout(null);

		JLabel lblBinario = new JLabel("Binario");
		lblBinario.setFont(new Font("Dialog", Font.BOLD, 40));
		lblBinario.setBounds(10, 10, 161, 52);
		contentPanel.add(lblBinario);

		JPanel decPanel = new JPanel();
		decPanel.setLayout(null);
		decPanel.setBounds(10, 125, 934, 128);
		contentPanel.add(decPanel);

		DecValue = new JTextField();
		DecValue.setFont(new Font("Dialog", Font.PLAIN, 22));
		DecValue.setColumns(10);
		DecValue.setBounds(10, 10, 275, 46);
		decPanel.add(DecValue);

		JButton toDecBut = new JButton("A Decimal");
		toDecBut.setFont(new Font("Dialog", Font.PLAIN, 22));
		toDecBut.setBounds(295, 72, 199, 45);
		toDecBut.addActionListener(new ToDec());
		decPanel.add(toDecBut);

		JLabel bitSizaLabel = new JLabel("Capacidad: ");
		bitSizaLabel.setFont(new Font("Dialog", Font.PLAIN, 22));
		bitSizaLabel.setBounds(583, 18, 119, 29);
		decPanel.add(bitSizaLabel);

		capSel = new JSpinner();
		capSel.setBounds(712, 15, 68, 36);
		capSel.setModel(new SpinnerNumberModel(4, 4, 36, 4));
		capSel.setFont(new Font("Dialog", Font.PLAIN, 22));
		decPanel.add(capSel);

		JLabel lblBits = new JLabel("bits");
		lblBits.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblBits.setBounds(790, 18, 119, 29);
		decPanel.add(lblBits);

		JButton toBinBut = new JButton("A Binario");
		toBinBut.setFont(new Font("Dialog", Font.PLAIN, 22));
		toBinBut.setBounds(295, 10, 199, 45);
		toBinBut.addActionListener(new ToBin());
		decPanel.add(toBinBut);

		binValue = new JTextField();
		binValue.setBounds(10, 72, 275, 46);
		decPanel.add(binValue);
		binValue.setFont(new Font("Dialog", Font.PLAIN, 22));
		binValue.setColumns(10);
	}

	class ToDec implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				String binNum = binValue.getText();
				binNum = binNum.replaceAll("\s", "");
				while (binNum.length() < (int) capSel.getValue()) {
					binNum = "0" + binNum;
				}
				int decNum = 0;

				if (binNum.charAt(0) == '1') {
					decNum = -(int) Math.pow(2, binNum.length() - 1);
				}

				for (int i = binNum.length() - 1, j = 0; i > 0; i--, j++) {
					decNum += ('1' == binNum.charAt(i)) ? Math.pow(2, j) : 0;
				}

				DecValue.setText(String.valueOf(decNum));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	class ToBin implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				double decNum = Double.parseDouble(DecValue.getText());
				String binNum = "";
				int aux = 0;
				boolean neg = false;

				int selectS = (int) capSel.getValue();

				if ((Math.abs(decNum) > Math.pow(2, selectS - 1))) {
					binValue.setText("Overflow");
					throw new Exception("Overflow");
				} else {

					if (decNum < 0d) {
						neg = true;
						decNum = Math.pow(2, selectS - 1) + decNum;
					}

					for (int i = 1; decNum > 0 || binNum.length() < selectS - 1 + aux; i++) {
						decNum /= 2;
						binNum = (int) ((decNum - Math.floor(decNum)) * 2) + binNum;
						if (i % 4 == 0) {
							binNum = " " + binNum;
							aux++;
						}
						decNum = Math.floor(decNum);
					}

					// while (binNum.length() < selectS) {
					if (neg) {
						binNum = "1" + binNum;
					} else {
						binNum = "0" + binNum;
					}
					// }
				}
				
				if (binNum.length() > selectS + aux) {
					binValue.setText("Overflow");
					throw new Exception("Overflow");
				} else {
					binValue.setText(binNum);
				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public static JPanel getContentPanel() {
		Binario obj = new Binario();
		return obj.contentPanel;
	}
}
