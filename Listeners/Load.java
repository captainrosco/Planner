package Listeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;


public class Load implements ActionListener{
	DefaultListModel<String> pendingModel;
	DefaultListModel<String> completeModel;
	String line;
	
	public Load(DefaultListModel<String> pModel, DefaultListModel<String> cModel){
		pendingModel = pModel;
		completeModel = cModel;
	}
	
	
	public void actionPerformed(ActionEvent e){
		//Clear both list before Load.
		
		pendingModel.removeAllElements();
		completeModel.removeAllElements();
		
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION){
		File file = fc.getSelectedFile();
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			
			br.readLine();

			//Loop : check lines 
			mainLoop:
			while ( (line=br.readLine()) != null){
				System.out.println(line);
				if(line.contains("Pending")|| line.isEmpty() ){
					//Do Nothing
				} else if (line.contains("Completed:")){
					break mainLoop;	
				} else {
					String newLine = line.trim();
					pendingModel.addElement(newLine);
				}
				
			} 
			} catch (IOException e1) {
				e1.printStackTrace();
		};
	  }
   }
}
