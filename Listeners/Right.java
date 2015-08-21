package Listeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class Right implements ActionListener {
	DefaultListModel<String> pendingModel;
	DefaultListModel<String> completeModel;
	JList<String> list_1;
	JList<String> list;

	public Right(JList<String> list1, DefaultListModel<String> pModel, DefaultListModel<String> cModel){
	list_1 = list1;
	pendingModel = pModel;
	completeModel = cModel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int index = list_1.getSelectedIndex();
		 if(index >= 0 ){
		 String getText = list_1.getSelectedValue().toString();
		 pendingModel.remove(index);
		 completeModel.addElement(getText);
		
	}
  }
}
