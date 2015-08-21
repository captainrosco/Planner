package Listeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

public class Save implements ActionListener {
	private Date currentDate = new Date();
	String txtDate = new SimpleDateFormat("MM/dd/yyyy").format(currentDate);
	DefaultListModel<String> pendingModel;
	DefaultListModel<String> completeModel;
	
	public Save(DefaultListModel<String> pModel, DefaultListModel<String> cModel){
		pendingModel = pModel;
		completeModel = cModel;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Create file
		
		JFileChooser fc = new JFileChooser();
		int retrival = fc.showSaveDialog(null);
		File file = new File(fc.getSelectedFile() + ".txt");
		
		if (retrival == JFileChooser.APPROVE_OPTION){
		PrintWriter pw = null;
			try {
				pw = new PrintWriter(new FileOutputStream(file));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			//Format Text
			pw.println(txtDate + "\n");
			pw.println("Pending:\n");
			//Loop through Pending list and print
	
	        for (int i = 0; i < pendingModel.getSize(); i++) {
	            pw.println("     " +  pendingModel.getElementAt(i).toString());
	        } 
	        
	        //Loop through Complete list and print
	        
	        pw.println("");
	        pw.println("Completed: \n");

	        for (int i = 0; i < completeModel.getSize(); i++) {
	            pw.println("     " + completeModel.getElementAt(i).toString()); 
	        }
	        pw.close();
		}
	}
}


