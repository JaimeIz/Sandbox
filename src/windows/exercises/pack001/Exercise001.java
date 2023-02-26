package windows.exercises.pack001;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Exercise001 {

	JPanel contentPanel;
	private JTextField xValue;
	private JTextField yValue;

	public Exercise001() {
		contentPanel = new JPanel();
		contentPanel.setLayout(null);

		JLabel statement = new JLabel();
		statement.setText("Ejercicio 1: \nPrograma para intercambiar el valor de \"A\" y \"b\" \n");
		statement.setFont(new Font("Tahoma", Font.PLAIN, 20));
		statement.setBounds(30, 30, 584, 96);
		contentPanel.add(statement);

		JPanel panel = new JPanel();
		panel.setBounds(30, 136, 495, 108);
		contentPanel.add(panel);
		panel.setLayout(null);

		JButton changeValueButton = new JButton("Cambiar");
		changeValueButton.setBounds(278, 10, 207, 86);
		panel.add(changeValueButton);
		changeValueButton.setFont(new Font("Dialog", Font.BOLD, 18));

		JPanel xContainer = new JPanel();
		xContainer.setBounds(10, 10, 233, 34);
		panel.add(xContainer);
		xContainer.setMinimumSize(new Dimension(200, 60));
		xContainer.setLayout(new BoxLayout(xContainer, BoxLayout.X_AXIS));

		JLabel xLabel = new JLabel("X = ");
		xContainer.add(xLabel);
		xLabel.setMaximumSize(new Dimension(666, 666));
		xLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		xLabel.setFont(new Font("Dialog", Font.BOLD, 18));

		xValue = new JTextField();
		xValue.setFont(new Font("Dialog", Font.BOLD, 18));
		xContainer.add(xValue);
		xValue.setColumns(10);

		JPanel yContainer = new JPanel();
		yContainer.setBounds(10, 62, 233, 34);
		panel.add(yContainer);
		yContainer.setPreferredSize(new Dimension(260, 60));
		yContainer.setMinimumSize(new Dimension(200, 60));
		yContainer.setLayout(new BoxLayout(yContainer, BoxLayout.X_AXIS));

		JLabel yLabel = new JLabel("Y = ");
		yLabel.setMaximumSize(new Dimension(666, 666));
		yLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		yLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		yContainer.add(yLabel);

		yValue = new JTextField();
		yValue.setSelectionColor(SystemColor.desktop);
		yValue.setFont(new Font("Dialog", Font.BOLD, 18));
		yValue.setColumns(10);
		yContainer.add(yValue);
		
		changeValueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = xValue.getText();
				xValue.setText(yValue.getText());
				yValue.setText(temp);
			}
		});
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}
}
