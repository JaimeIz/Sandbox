package windows;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import windows.utilities.cardGame.CardFactory;
import windows.utilities.convertidores.Binario;
import windows.utilities.convertidores.Conversor;
import windows.utilities.convertidores.ConversorMultiBase;
import windows.utilities.sounds.MIDI_1;

public class UtilitiesPanel {
	private JPanel contentPanel;
	private JPanel panel;
	private JPanel defaultPanel;
	private JPanel temp;

	public UtilitiesPanel() {
		contentPanel = new JPanel();
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPanel.setSize(1200, 750);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setBorder(null);
		splitPane.setDividerSize(0);
		splitPane.setOpaque(false);
		splitPane.setBackground(Color.GRAY);
		splitPane.setPreferredSize(new Dimension(200, 30));
		splitPane.setMinimumSize(new Dimension(150, 25));
		splitPane.setEnabled(false);
		splitPane.setFocusable(false);
		splitPane.setAlignmentY(Component.CENTER_ALIGNMENT);
		splitPane.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPanel.add(splitPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setMinimumSize(new Dimension(200, 30));
		scrollPane.setFocusable(false);
		scrollPane.setBorder(new CompoundBorder(new LineBorder(
			new Color(192, 192, 192), 4),
			new EmptyBorder(5, 10, 5, 10)
		));
		splitPane.setLeftComponent(scrollPane);

		JLabel listTitle = new JLabel("Utilidades");
		listTitle.setOpaque(true);
		listTitle.setPreferredSize(new Dimension(100, 25));
		listTitle.setBackground(Color.WHITE);
		listTitle.setFocusable(false);
		listTitle.setFont(new Font("Dialog", Font.BOLD, 20));
		scrollPane.setColumnHeaderView(listTitle);

		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("JTree") {
			{
				DefaultMutableTreeNode node_1;
				node_1 = new DefaultMutableTreeNode("Grupo 1");
				node_1.add(new DefaultMutableTreeNode("Entrada 1"));
				node_1.add(new DefaultMutableTreeNode("Entrada 2"));
				node_1.add(new DefaultMutableTreeNode("Entrada 3"));
				add(node_1);

				node_1 = new DefaultMutableTreeNode("Musica");
				node_1.add(new DefaultMutableTreeNode("Entrada 1"));
				node_1.add(new DefaultMutableTreeNode("Entrada 2"));
				node_1.add(new DefaultMutableTreeNode("Entrada 3"));
				node_1.add(new DefaultMutableTreeNode("Entrada 4"));
				add(node_1);

				node_1 = new DefaultMutableTreeNode("Conversores");
				node_1.add(new DefaultMutableTreeNode("ConversorV1"));
				node_1.add(new DefaultMutableTreeNode("ConversorV2"));
				node_1.add(new DefaultMutableTreeNode("Binario"));
				add(node_1);

				node_1 = new DefaultMutableTreeNode("Card game");
				node_1.add(new DefaultMutableTreeNode("Card factory"));
				node_1.add(new DefaultMutableTreeNode("Card player"));
				add(node_1);

				node_1 = new DefaultMutableTreeNode("Otros");
				add(node_1);
			}
		}));
		tree.setRootVisible(false);
		tree.setScrollsOnExpand(false);
		tree.setBackground(Color.WHITE);
		tree.setBorder(new EmptyBorder(10, 10, 0, 0));
		tree.setFont(new Font("Dialog", Font.PLAIN, 16));
		scrollPane.setViewportView(tree);

		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new CompoundBorder(
			new LineBorder(new Color(192, 192, 192), 4),
			new EmptyBorder(10, 10, 10, 10)
		));

		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		splitPane.setRightComponent(panel);

		defaultPanel = new JPanel();
		defaultPanel.setMinimumSize(new Dimension(800, 800));
		defaultPanel.setLayout(new GridLayout(1, 0, 0, 0));
		panel.add(defaultPanel);

		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				String pathSelected = tree.getSelectionPath().toString();
				if (pathSelected.contains("Entrada 1") && pathSelected.contains("Musica")) {
					panel.getComponent(0).setVisible(false);
					panel.removeAll();

					temp = MIDI_1.getContentPanel();
					temp.setVisible(true);
					panel.add(temp);
				}

				if (pathSelected.contains("ConversorV1")) {
					panel.getComponent(0).setVisible(false);
					panel.removeAll();

					temp = Conversor.getContentPanel();
					temp.setVisible(true);
					panel.add(temp);
				}

				if (pathSelected.contains("ConversorV2")) {
					panel.getComponent(0).setVisible(false);
					panel.removeAll();

					temp = ConversorMultiBase.getContentPanel();
					temp.setVisible(true);
					panel.add(temp);
				}

				if (pathSelected.contains("Binario")) {
					panel.getComponent(0).setVisible(false);
					panel.removeAll();

					temp = Binario.getContentPanel();
					temp.setVisible(true);
					panel.add(temp);
				}

				if (pathSelected.contains("Card factory")) {
					panel.getComponent(0).setVisible(false);
					panel.removeAll();

					temp = CardFactory.getContentPanel();
					temp.setVisible(true);
					panel.add(temp);
				}

				if (pathSelected.contains("Otros")) {
					panel.getComponent(0).setVisible(false);
					panel.removeAll();

					temp = defaultPanel;
					temp.setVisible(true);
					panel.add(temp);
				}

				System.out.print(tree.getSelectionPath() + " - " + pathSelected.toString().contains("Otros") + "\n");
			}
		});

	}

	public void setExercisePanel(JPanel defaultPanel) {
		this.defaultPanel = defaultPanel;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}
}
