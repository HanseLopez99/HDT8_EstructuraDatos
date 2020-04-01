public class PrioritySystem{
    private PriorityQueue<Patient> data;
	private Patient currentPatient;
	
	public PrioritySystem(String factory) {
		Factory<Patient> fact = new Factory<Patient>();
		data = fact.getPriority(factory);
	}
	
	/**
	 * Metodo para agregar pacientes
	 */
	public void addPatient() {
		Object[] data = fileRead.readTXT(fileRead.getPath());
		for (Object a : data) {
			this.data.add(((Patient)a));
		}
	}
	
	/**
	 * Metodo para transferir pacientes
	 */
	public void transferPatient() {
		currentPatient = data.remove();
	}
	
	/**
	 * Metodo para retornar el paciente actual
	 * @return
	 */
	public Patient getPatient() {
		return currentPatient;
	}
	
	/**
	 * Metodo para atender al paciente
	 * @return
	 */
	public boolean attendPatient() {
		currentPatient = null;
		return true;
	}
	
	/**
	 * metodo que devuelve a todos los pacientes
	 * @return
	 */
	public PriorityQueue<Patient> getPatients(){
		return data.clone();
	}
	
	/**
	 * Metodo que retorna el size 
	 * @return
	 */
	public int size() {
		return data.size();
	}
}