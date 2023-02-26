package windows.utilities.cardGame;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class CardFactory {

	private JPanel contentPanel;
	private ArrayList<Card> deckOfCards;
	private int currentCardIndex;
	private JTextArea answerText;
	private JTextArea questionText;
	private JSpinner spinner;

	public CardFactory() {
		deckOfCards = new ArrayList<Card>();
		deckOfCards.add(new Card("defaut", "default"));
		currentCardIndex = 0;
		setUpGUI();
	}

	private void setUpGUI() {
		contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		Font titText = new Font("Dialog", Font.BOLD, 22);
		Font genText = new Font("Dialog", Font.BOLD, 16);

		JPanel menuButtons = new JPanel();
		menuButtons.setBackground(Color.WHITE);
		menuButtons.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		menuButtons.setMaximumSize(new Dimension(32767, 100));
		menuButtons.setAlignmentY(Component.TOP_ALIGNMENT);
		contentPanel.add(menuButtons);

		JPanel fileSavePanel = new JPanel();
		fileSavePanel.setBackground(Color.WHITE);
		menuButtons.add(fileSavePanel);
		fileSavePanel.setLayout(new BoxLayout(fileSavePanel, BoxLayout.Y_AXIS));

		JButton saveFileBtn = new JButton("Save File");
		saveFileBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		saveFileBtn.setFont(genText);
		saveFileBtn.addActionListener(new SaveFile());
		fileSavePanel.add(saveFileBtn);

		JButton loadFileBtn = new JButton("Load File");
		loadFileBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		loadFileBtn.setFont(genText);
		loadFileBtn.addActionListener(new LoadFile());
		fileSavePanel.add(loadFileBtn);

		Component horizontalStrut = Box.createHorizontalStrut(80);
		menuButtons.add(horizontalStrut);

		JPanel saveAndCreatePanel = new JPanel();
		saveAndCreatePanel.setBackground(Color.WHITE);
		menuButtons.add(saveAndCreatePanel);
		saveAndCreatePanel.setLayout(new BoxLayout(saveAndCreatePanel, BoxLayout.Y_AXIS));

		JButton newCardButton = new JButton("New Card");
		newCardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		newCardButton.setFont(genText);
		newCardButton.addActionListener(new NewCard());
		saveAndCreatePanel.add(newCardButton);

		JButton saveChangesbtn = new JButton("Save Changes");
		saveChangesbtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		saveChangesbtn.setFont(genText);
		saveChangesbtn.addActionListener(new SaveChages());
		saveAndCreatePanel.add(saveChangesbtn);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		menuButtons.add(horizontalStrut_1);

		JPanel navButtonsPanel = new JPanel();
		navButtonsPanel.setBackground(Color.WHITE);
		menuButtons.add(navButtonsPanel);
		navButtonsPanel.setLayout(new BoxLayout(navButtonsPanel, BoxLayout.Y_AXIS));

		JButton previousButton = new JButton("Previous");
		previousButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		previousButton.setFont(genText);
		previousButton.addActionListener(new Previous());
		navButtonsPanel.add(previousButton);

		JButton nextButton = new JButton("Next");
		nextButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		nextButton.setFont(genText);
		nextButton.addActionListener(new Next());
		navButtonsPanel.add(nextButton);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		menuButtons.add(horizontalStrut_2);

		JPanel navPanel = new JPanel();
		navPanel.setBackground(Color.WHITE);
		menuButtons.add(navPanel);
		navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.Y_AXIS));

		JButton goToButton = new JButton("Go to");
		goToButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		goToButton.setFont(genText);
		goToButton.addActionListener(new GoTo());
		navPanel.add(goToButton);

		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, deckOfCards.size() - 1, 1));
		spinner.setEditor(new JSpinner.DefaultEditor(spinner));
		spinner.setFont(genText);
		navPanel.add(spinner);

		JLabel questionTit = new JLabel("Question:");
		questionTit.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPanel.add(questionTit);
		questionTit.setFont(titText);

		questionText = new JTextArea();
		questionText.setWrapStyleWord(true);
		questionText.setAlignmentY(Component.TOP_ALIGNMENT);
		questionText.setTabSize(4);
		questionText.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		questionText.setLineWrap(true);
		questionText.setFont(genText);

		JScrollPane scroll1 = new JScrollPane(questionText);
		scroll1.setAlignmentY(Component.TOP_ALIGNMENT);
		contentPanel.add(scroll1);

		JLabel answerTit = new JLabel("Answer:");
		answerTit.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPanel.add(answerTit);
		answerTit.setFont(titText);

		answerText = new JTextArea();
		answerText.setWrapStyleWord(true);
		answerText.setAlignmentY(Component.TOP_ALIGNMENT);
		answerText.setTabSize(4);
		answerText.setFont(genText);
		answerText.setLineWrap(true);
		// contentPanel.add(answerText);

		JScrollPane scroll = new JScrollPane(answerText);
		scroll.setAlignmentY(Component.TOP_ALIGNMENT);
		scroll.setMinimumSize(new Dimension(0, 200));

		contentPanel.add(scroll);

		contentPanel.setVisible(true);
	}

	class Previous implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (currentCardIndex - 1 >= 0) {
					currentCardIndex--;
					spinner.setValue(currentCardIndex);
					setText(deckOfCards.get(currentCardIndex));
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	class Next implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (currentCardIndex + 1 < deckOfCards.size()) {
					currentCardIndex++;
					spinner.setValue(currentCardIndex);
					setText(deckOfCards.get(currentCardIndex));
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	class GoTo implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			setText(deckOfCards.get((int) spinner.getValue()));
			currentCardIndex = (int) spinner.getValue();
		}
	}

	class SaveChages implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			deckOfCards.set(currentCardIndex, new Card(questionText.getText(), answerText.getText()));
		}
	}

	class NewCard implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			deckOfCards.add(new Card());
			spinner.setModel(new SpinnerNumberModel((int) spinner.getValue(), 0, deckOfCards.size() - 1, 1));
		}
	}

	class SaveFile implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String fileName = JOptionPane.showInputDialog("Name the file") + ".card";
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
				oos.writeObject(deckOfCards);
				oos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	class LoadFile implements ActionListener {
		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				JFileChooser file = new JFileChooser();
				file.showOpenDialog(contentPanel);
				FileInputStream fis = new FileInputStream(file.getSelectedFile());
				ObjectInputStream ois = new ObjectInputStream(fis);
				deckOfCards = (ArrayList<Card>) ois.readObject();

				currentCardIndex = 0;
				setText(deckOfCards.get(currentCardIndex));
				spinner.setModel(new SpinnerNumberModel((int) spinner.getValue(), 0, deckOfCards.size() - 1, 1));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		CardFactory obj = new CardFactory();
		obj.start();
	}

	private void start() {
		deckOfCards = new ArrayList<Card>();
		deckOfCards.add(new Card("defaut", "default"));
		currentCardIndex = 0;
		setUpGUI();
		setText(deckOfCards.get(currentCardIndex));
	}

	private void setText(Card a) {
		questionText.setText(a.getQuestion());
		answerText.setText(a.getAnswer());
	}

	public static JPanel getContentPanel() {
		CardFactory obj = new CardFactory();
		obj.start();
		return obj.contentPanel;
	}

}
