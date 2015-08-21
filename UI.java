
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import Listeners.*;

public class UI extends JFrame{
	private static final long serialVersionUID = 1L;
	JMenuBar menuBar;
	JMenu File;
	JMenuItem Save;
	JMenuItem Load;
	JMenuItem Quit;
	JButton button_1, button_2, btnDelete, btnEdit;
	JTextField textField;
	JTabbedPane tabbedPane;
	JScrollPane listScroller, listScroller1;
	JPanel contentPane;
	DefaultListModel<String> pendingModel = new DefaultListModel<String>();
	DefaultListModel<String> completeModel = new DefaultListModel<String>();
	JList<String> list_1 = new JList<String>(pendingModel);
	JList<String> list = new JList<String>(completeModel);
	
	public UI() {
	
		menuBar = new JMenuBar();
		File = new JMenu("File");
		Save = new JMenuItem("Save");
		Load = new JMenuItem("Load");
		Quit = new JMenuItem("Quit");
		button_1 = new JButton(">");
		button_2 = new JButton("<");
		btnDelete = new JButton("Del");
		btnEdit = new JButton("Edit");
		textField = new JTextField();
		textField.setColumns(10);
		
		setJMenuBar(menuBar);
		menuBar.add(File);
		File.add(Save);
		File.add(Load);
		File.add(Quit);
		
		Save.addActionListener(new Save(pendingModel, completeModel));
		Load.addActionListener(new Load(pendingModel, completeModel));
		Quit.addActionListener(new Quit());
		button_1.addActionListener(new Right(list_1, pendingModel, completeModel));
		button_2.addActionListener(new Left(list, pendingModel, completeModel));
		btnDelete.addActionListener(new Delete(list_1, list, pendingModel, completeModel));
		btnEdit.addActionListener(new Edit(list_1, list, pendingModel, completeModel));
		textField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(textField.getText().length() >= 1){
						String getText = textField.getText();
						pendingModel.addElement(getText);
					}
					textField.setText("");
				  }
			});

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);	
		listScroller = new JScrollPane(list_1);
		listScroller.setPreferredSize(new Dimension(200,500));
		list_1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list_1.setLayoutOrientation(JList.VERTICAL);
		list_1.setVisibleRowCount(1);
		
		listScroller1 = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(200,500));
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(1);
		list.setSize(GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE);
		
		contentPane = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(getContentPane());
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap()));
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnEdit)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDelete)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_1)
							.addGap(3)
							.addComponent(button_2)
							.addGap(31))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
							.addContainerGap()))));
		tabbedPane.addTab("Pending", null, listScroller, null);
		tabbedPane.addTab("Completed", null, listScroller1, null);
		contentPane.setLayout(gl_contentPane);
	}
}


