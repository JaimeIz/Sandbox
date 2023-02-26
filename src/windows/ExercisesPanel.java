package windows;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import windows.exercises.pack001.*;

import java.awt.GridLayout;

public class ExercisesPanel {
	
	private Exercise001 ex001;
	private Exercise002 ex002;
	
	private JPanel contentPanel;
	private JPanel panel;
	private JPanel defaultPanel;
	private JPanel temp;
	
	public ExercisesPanel() {
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
		scrollPane.setBorder(
				new CompoundBorder(new LineBorder(new Color(192, 192, 192), 4), new EmptyBorder(5, 10, 5, 10)));
		splitPane.setLeftComponent(scrollPane);

		JLabel listTitle = new JLabel("Ejercicios");
		listTitle.setOpaque(true);
		listTitle.setPreferredSize(new Dimension(100, 25));
		listTitle.setBackground(Color.WHITE);
		listTitle.setFocusable(false);
		listTitle.setFont(new Font("Dialog", Font.BOLD, 20));
		scrollPane.setColumnHeaderView(listTitle);

		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("JTree") {
			private static final long serialVersionUID = 1L;

			{
				DefaultMutableTreeNode node_1;
				node_1 = new DefaultMutableTreeNode("Boletin 1");
				node_1.add(new DefaultMutableTreeNode("Ejercicio 1"));
				node_1.add(new DefaultMutableTreeNode("Ejercicio 2"));
				node_1.add(new DefaultMutableTreeNode("magenta"));
				add(node_1);
				
				node_1 = new DefaultMutableTreeNode("Boletin 2");
				node_1.add(new DefaultMutableTreeNode("basketball"));
				node_1.add(new DefaultMutableTreeNode("soccer"));
				node_1.add(new DefaultMutableTreeNode("football"));
				node_1.add(new DefaultMutableTreeNode("hockey"));
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
				new EmptyBorder(10, 10, 10, 10)));
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		splitPane.setRightComponent(panel);

		defaultPanel = new JPanel();
		defaultPanel.setMinimumSize(new Dimension(800, 800));
		defaultPanel.setLayout(new GridLayout(1, 0, 0, 0));
		panel.add(defaultPanel);

		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				if (tree.getSelectionPath().toString().contains("Ejercicio 1")) {
					panel.getComponent(0).setVisible(false);
					panel.removeAll();
					ex001 = new Exercise001();
					temp = ex001.getContentPanel();
					temp.setVisible(true);
					panel.add(temp);
				} else if (tree.getSelectionPath().toString().contains("Ejercicio 2")) {
					panel.getComponent(0).setVisible(false);
					panel.removeAll();
					ex002 = new Exercise002();
					temp = ex002.getContentPanel();
					temp.setVisible(true);
					panel.add(temp);
				}
				
				if (tree.getSelectionPath().toString().contains("magenta")) {
					panel.getComponent(0).setVisible(false);
					panel.removeAll();
					defaultPanel.setVisible(true);
					panel.add(defaultPanel);
					defaultPanel.setBackground(Color.MAGENTA);
				}
				System.out.print(tree.getSelectionPath() + " - " + tree.getPathForLocation(1, 1) + " "
						+ (tree.getSelectionPath().toString().contains("magenta")) + "\n");
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
