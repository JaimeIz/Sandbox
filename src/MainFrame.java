import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;

import windows.MainPanel;
import windows.UtilitiesPanel;
import windows.ExercisesPanel;

import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.Box;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	MainPanel mainPanel = new MainPanel(); // Make a "MainPanel" Object
	ExercisesPanel exercisesPanel = new ExercisesPanel(); // Make a "ExercisesPanel" Object
	UtilitiesPanel utilitiesPanel = new UtilitiesPanel();

	private JPanel contentPanel = mainPanel.getContentPanel(); // Get the JPanel from the "MainPanel" object called

	public MainFrame() {
		setBackground(Color.WHITE);
		setBounds(150, 20, 1200, 800);
		setResizable(false);
		setContentPane(contentPanel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		contentPanel.setVisible(true);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(SystemColor.desktop);
		menuBar.setVisible(false);
		setJMenuBar(menuBar);

		JMenuItem MainMenuButton = new JMenuItem("Main Menu");
		MainMenuButton.setOpaque(true);
		MainMenuButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		MainMenuButton.setMaximumSize(new Dimension(200, 32767));
		MainMenuButton.setFont(new Font("Dialog", Font.BOLD, 18));
		MainMenuButton.setBackground(SystemColor.desktop);
		MainMenuButton.setForeground(Color.WHITE);
		menuBar.add(MainMenuButton);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setMaximumSize(new Dimension(1000, 32767));
		menuBar.add(horizontalStrut);

		JMenuItem menuExitButton = new JMenuItem("Exit");
		menuExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		menuExitButton.setHorizontalAlignment(SwingConstants.RIGHT);
		menuExitButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		menuExitButton.setMaximumSize(new Dimension(150, 32767));
		menuExitButton.setForeground(Color.WHITE);
		menuExitButton.setFont(new Font("Dialog", Font.BOLD, 18));
		menuExitButton.setOpaque(true);
		menuExitButton.setBackground(SystemColor.desktop);
		menuBar.add(menuExitButton);

		MainMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuBar.setVisible(false);
				contentPanel = mainPanel.getContentPanel();
				setContentPane(contentPanel);

			}
		});

		mainPanel.getExerciesButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuBar.setVisible(true);
				contentPanel = exercisesPanel.getContentPanel();
				setContentPane(contentPanel);
			}
		});

		mainPanel.getUtilitiesButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuBar.setVisible(true);
				contentPanel = utilitiesPanel.getContentPanel();
				setContentPane(contentPanel);
			}
		});

		mainPanel.getExtitButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	public void start() {
		this.setVisible(true);
	}

}
