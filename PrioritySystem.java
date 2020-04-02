public class PrioritySystem{
    private PriorityQueue<Patient> data;
	private Patient currentPatient;
	
	/**
	 * PrioritySystem constructor
	 * @param factory
	 */
	public PrioritySystem(String factory) {
		Factory<Patient> fact = new Factory<Patient>();
		data = fact.getPriority(factory);
	}
	
	/**
	 * method to add patients stored in a txt file
	 */
	public void addPatient() {
		Object[] data = fileRead.readTXT(fileRead.getPath());
		for (Object a : data) {
			this.data.add(((Patient)a));
		}
	}
	
	/**
	 * method to transfer a patient to the clinic
	 */
	public void transferPatient() {
		currentPatient = data.remove();
	}
	
	/**
	 * method to get the current patient
	 * @return currentPatient
	 */
	public Patient getPatient() {
		return currentPatient;
	}
	
	/**
	 * method to check a patient
	 * @return true or false
	 */
	public boolean checkPatient() {
		currentPatient = null;
		return true;
	}
	
	/**
	 * method to get a clone of all patients
	 * @return clone
	 */
	public PriorityQueue<Patient> getPatients(){
		return data.clone();
	}
	
	/**
	 * method to get the size
	 * @return size
	 */
	public int size() {
		return data.size();
	}
}