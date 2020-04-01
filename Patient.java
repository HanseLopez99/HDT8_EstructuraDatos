public class Patient implements Comparable<Patient>{
    private String name;
    private String symptom;
    private String priority;
    
    public Patient() {
    	
    }
    
    public Patient(String name, String symptom, String priority) {
    	this.name = name;
    	this.symptom = symptom;
    	this.priority = priority;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setSymptom(String symptom){
        this.symptom = symptom;
    }

    public String getSymptom(){
        return this.symptom;
    }

    public void setPriority(String priority){
        this.priority = priority;
    }

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