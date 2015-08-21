package Listeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class Delete implements ActionListener{
	DefaultListModel<String> pendingModel;
	DefaultListModel<String> completeModel;
	JList<String> list_1;
	JList<String> list;
	
	public Delete(JList<String> list1, JList<String> list2, DefaultListModel<String> pModel, DefaultListModel<String> cModel){
		list_1 = list1;
		list = list2;
		pendingModel = pModel;
		completeModel = cModel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int index = list.getSelectedIndex();
		int index2 = list_1.getSelectedIndex();
		if(index >= 0){
			completeModel.remove(index);
		} else if (index2 >= 0){
			pendingModel.remove(index2);
		}
		
	}

}
