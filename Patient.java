
public class Patient implements Comparable<Patient>{
    private String name;
    private String symptom;
    private String priority;
    
    /**
     * empty constructor
     */
    public Patient() {
    	
    }
    
    /**
     * constructor to create a patient with all the parameters
     * @param name
     * @param symptom
     * @param priority
     */
    public Patient(String name, String symptom, String priority) {
    	this.name = name;
    	this.symptom = symptom;
    	this.priority = priority;
    }

    /**
     * method to set name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * method to get name
     * @return name
     */
    public String getName(){
        return this.name;
    }

    /**
     * method to set symptom
     * @param symptom
     */
    public void setSymptom(String symptom){
        this.symptom = symptom;
    }

    /**
     * method to get symptom
     * @return symptom
     */
    public String getSymptom(){
        return this.symptom;
    }

    /**
     * method to set priority
     * @param priority
     */
    public void setPriority(String priority){
        this.priority = priority;
    }

    /**
     * method to get priority
     * @return priority
     */
    public String getPriority(){
        return this.priority;
    }
    
	@Override
	public int compareTo(Patient o) {
		return this.priority.compareTo(o.priority);
    }
    
    @Override
	public String toString() {
		return "Prioridad: " + priority + "\nNombre: " + name + "\nSintoma: " + symptom;
	}
}