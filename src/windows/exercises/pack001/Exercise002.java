package windows.exercises.pack001;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exercise002 implements ActionListener {
	
	private JPanel contentPanel;
	private JTextField xValue;
	private JTextField yValue;
	
	private JButton addButton;
	private JButton substractButton;
	private JButton multiplyButton;
	private JButton divideButton;
	private JLabel resultLabel;
	
	public Exercise002() {
		contentPanel = new JPanel();
		contentPanel.setLayout(null);
		
		JTextArea statement = new JTextArea();
		statement.setBounds(30, 30, 488, 56);
		statement.setText("Calcular el valor de su suma, resta, multiplicaci\u00F3n y divisi\u00F3n de dos n\u00FAmeros reales.");
		statement.setFont(new Font("Dialog", Font.PLAIN, 20));
		statement.setLineWrap(true);
		statement.setWrapStyleWord(true);
		statement.setOpaque(false);
		contentPanel.add(statement);
		
		JPanel generalPanel = new JPanel();
		generalPanel.setBounds(30, 120, 393, 186);
		contentPanel.add(generalPanel);
		generalPanel.setLayout(null);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		buttonPanel.setBounds(253, 10, 100, 100);
		generalPanel.add(buttonPanel);
		buttonPanel.setLayout(new GridLayout(2, 2, 5, 5));
		
		addButton = new JButton("+");
		addButton.setFocusable(false);
		addButton.setHorizontalTextPosition(SwingConstants.CENTER);
		addButton.setFont(new Font("Consolas", Font.BOLD, 20));
		buttonPanel.add(addButton);
		addButton.addActionListener(this);
		
		substractButton = new JButton("-");
		substractButton.setFocusable(false);
		substractButton.setHorizontalTextPosition(SwingConstants.CENTER);
		substractButton.setFont(new Font("Consolas", Font.BOLD, 20));
		buttonPanel.add(substractButton);
		substractButton.addActionListener(this);
		
		multiplyButton = new JButton("X");
		multiplyButton.setFocusable(false);
		multiplyButton.setHorizontalTextPosition(SwingConstants.CENTER);
		multiplyButton.setFont(new Font("Consolas", Font.BOLD, 20));
		buttonPanel.add(multiplyButton);
		multiplyButton.addActionListener(this);
		
		divideButton = new JButton("/");
		divideButton.setFocusable(false);
		divideButton.setHorizontalTextPosition(SwingConstants.CENTER);
		divideButton.setFont(new Font("Consolas", Font.BOLD, 20));
		buttonPanel.add(divideButton);
		divideButton.addActionListener(this);
		
		JPanel yPanel = new JPanel();
		yPanel.setBounds(10, 75, 204, 36);
		generalPanel.add(yPanel);
		yPanel.setLayout(new BoxLayout(yPanel, BoxLayout.X_AXIS));
		
		JLabel yLabel = new JLabel("Y = ");
		yLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		yPanel.add(yLabel);
		
		yValue = new JTextField();
		yValue.setFont(new Font("Dialog", Font.BOLD, 18));
		yPanel.add(yValue);
		yValue.setColumns(10);
		
		JPanel xPanel = new JPanel();
		xPanel.setBounds(10, 10, 204, 36);
		generalPanel.add(xPanel);
		xPanel.setLayout(new BoxLayout(xPanel, BoxLayout.X_AXIS));
		
		JLabel xLabel = new JLabel("X = ");
		xLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		xPanel.add(xLabel);
		
		xValue = new JTextField();
		xValue.setFont(new Font("Dialog", Font.BOLD, 18));
		xPanel.add(xValue);
		xValue.setColumns(10);
		
		resultLabel = new JLabel("New label");
		resultLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultLabel.setRequestFocusEnabled(false);
		resultLabel.setFocusable(false);
		resultLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		resultLabel.setBounds(96, 141, 200, 35);
		generalPanel.add(resultLabel);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			double x = Double.parseDouble(xValue.getText());
			double y = Double.parseDouble(yValue.getText());
			
			if (e.getSource() == addButton) {
				resultLabel.setText("X + Y = " + (x + y));
				
			} else if (e.getSource() == substractButton) {
				resultLabel.setText("X - Y = " + (x - y));
				
			} else if (e.getSource() == multiplyButton) {
				resultLabel.setText("X * Y = " + (x * y));
				
			} else if (e.getSource() == divideButton) {
				resultLabel.setText("X / Y = " + (x / y));
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
	}
	
	public JPanel getContentPanel() {
		return contentPanel;
	}

}
