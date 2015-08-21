package Listeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class Left implements ActionListener {
	DefaultListModel<String> pendingModel;
	DefaultListModel<String> completeModel;
	JList<String> list;
	
	public Left(JList<String> list1,DefaultListModel<String> pModel, DefaultListModel<String> cModel){
		list = list1;
		pendingModel = pModel;
		completeModel = cModel;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int index = list.getSelectedIndex();
		if(index >= 0){
		String getText = list.getSelectedValue().toString();
		completeModel.remove(index);
		pendingModel.addElement(getText);
		
	  }
   }
}