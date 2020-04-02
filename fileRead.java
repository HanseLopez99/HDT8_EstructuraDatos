import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class fileRead{
	/**
	 * method to get the path
	 * @return the path 
	 */
    public static String getPath(){
        JFileChooser chooser = new JFileChooser();
	 	FileNameExtensionFilter fileExtensionFilter =new FileNameExtensionFilter("*.TXT", "txt");
	 	chooser.setFileFilter(fileExtensionFilter);
	 	File f = null;
	 	
		try {
			f = new File(new File(".").getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String path = "";
		
		try {
			chooser.setCurrentDirectory(f);
			chooser.setCurrentDirectory(null);
			chooser.showOpenDialog(null);
	    
			path = chooser.getSelectedFile().toString();
		}catch(Exception e) {
			
		}
        return path;
    }
    
    /**
     * Method to read a file using the file explorer
     * @param path
     * @return array with patients
     */
    public static Object[] readTXT(String path) {
		
		File newFile = new File(path);
		FileReader reader;
		BufferedReader br;
		ArrayList<Patient> patients = new ArrayList<Patient>();
		
		try {
			
			reader = new FileReader(newFile);
			br = new BufferedReader(reader);
			
			String line = "";
			
			while((line = br.readLine()) != null) {
				String[] parameters = line.split(", "); 
				patients.add(new Patient(parameters[0].trim(),parameters[1].trim(),parameters[2].trim()));		
			}
				
			br.close();
			reader.close();		
		} catch (Exception e) {
			
		}	
		return patients.toArray();
	}
}