package windows;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.SystemColor;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainPanel {

	private JPanel contentPanel;
	private JButton extitButton;
	private JButton exerciesButton;
	private JButton utilitiesButton;
	private Point titileLocation;

	public MainPanel() {
		contentPanel = new JPanel();
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setSize(1200, 800);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));

		JPanel titlePanel = new JPanel();
		titlePanel.setForeground(Color.WHITE); // SystemColor.desktop
		titlePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		titlePanel.setBackground(Color.DARK_GRAY);
		titlePanel.setLayout(null);
		contentPanel.add(titlePanel);

		JLabel titleLabel = new JLabel("Sandbox");
		titleLabel.setForeground(Color.WHITE); // SystemColor.desktop
		titleLabel.setSize(260, 80);
		Dimension dim = titleLabel.getSize();
		titileLocation = new Point((dim.width - 100), (dim.height - 25));
		titleLabel.setLocation(titileLocation);
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		titleLabel.setFont(new Font("Dialog", Font.BOLD, 60));
		titlePanel.add(titleLabel);

		JPanel grid = new JPanel();
		grid.setAlignmentX(Component.RIGHT_ALIGNMENT);
		grid.setBackground(Color.LIGHT_GRAY);
		grid.setLayout(new BoxLayout(grid, BoxLayout.X_AXIS));
		contentPanel.add(grid);

		Component whiteSpace = Box.createHorizontalStrut(250);
		grid.add(whiteSpace);

		JPanel innerGrid = new JPanel();
		innerGrid.setPreferredSize(new Dimension(225, 10));
		innerGrid.setMinimumSize(new Dimension(150, 0));
		innerGrid.setMaximumSize(new Dimension(400, 32767));
		innerGrid.setBorder(new EmptyBorder(5, 10, 5, 10));
		innerGrid.setLayout(new GridLayout(9, 1, 5, 10));
		innerGrid.setBackground(Color.GRAY);
		grid.add(innerGrid);

		Box WhiteSpace1 = Box.createVerticalBox();
		WhiteSpace1.setAlignmentX(Component.CENTER_ALIGNMENT);
		innerGrid.add(WhiteSpace1);

		Box WhiteSpace2 = Box.createVerticalBox();
		WhiteSpace2.setAlignmentX(0.5f);
		innerGrid.add(WhiteSpace2);

		exerciesButton = new JButton("Ejercicios");
		exerciesButton.setBorderPainted(false);
		exerciesButton.setFocusable(false);
		exerciesButton.setForeground(Color.WHITE);
		exerciesButton.setBackground(Color.DARK_GRAY);
		exerciesButton.setFont(new Font("Consolas", Font.BOLD, 25));
		exerciesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		innerGrid.add(exerciesButton);

		utilitiesButton = new JButton("Utilidades");
		utilitiesButton.setForeground(Color.WHITE);
		utilitiesButton.setFont(new Font("Consolas", Font.BOLD, 25));
		utilitiesButton.setFocusable(false);
		utilitiesButton.setBorderPainted(false);
		utilitiesButton.setBackground(Color.DARK_GRAY);
		utilitiesButton.setAlignmentX(0.5f);
		innerGrid.add(utilitiesButton);

		Box WhiteSpace3 = Box.createVerticalBox();
		WhiteSpace3.setAlignmentX(0.5f);
		innerGrid.add(WhiteSpace3);

		Box WhiteSpace4 = Box.createVerticalBox();
		WhiteSpace4.setAlignmentX(0.5f);
		innerGrid.add(WhiteSpace4);

		Box WhiteSpace5 = Box.createVerticalBox();
		WhiteSpace5.setAlignmentX(0.5f);
		innerGrid.add(WhiteSpace5);

		Box WhiteSpace6 = Box.createVerticalBox();
		WhiteSpace6.setAlignmentX(0.5f);
		innerGrid.add(WhiteSpace6);

		extitButton = new JButton("EXIT");
		extitButton.setOpaque(false);
		extitButton.setFocusable(false);
		extitButton.setBorderPainted(false);
		extitButton.setForeground(Color.LIGHT_GRAY);
		extitButton.setFont(new Font("Consolas", Font.BOLD, 25));
		extitButton.setBackground(Color.DARK_GRAY);
		extitButton.setAlignmentX(0.5f);
		innerGrid.add(extitButton);

		Component whiteSpace2 = Box.createHorizontalStrut(250);
		grid.add(whiteSpace2);

	}

	public JPanel getContentPanel() {
		return this.contentPanel;
	}

	public JButton getUtilitiesButton() {
		return utilitiesButton;
	}

	public JButton getExtitButton() {
		return extitButton;
	}

	public JButton getExerciesButton() {
		return exerciesButton;
	}

}
