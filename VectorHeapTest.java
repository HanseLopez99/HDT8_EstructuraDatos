import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

public class VectorHeapTest extends TestCase{
	private VectorHeap<Patient> vectorHeap;
	
	public void init() {
		vectorHeap = new VectorHeap<Patient>();
		
	}
	
	@Test
	public void test() {
		vectorHeap.add(new Patient("Ricardo Miloz","Dolor de espalda","B"));
		vectorHeap.add(new Patient("Bob Esponja","Alergia","D"));
		vectorHeap.add(new Patient("Roberto Ratas","Cancer","A"));
		vectorHeap.add(new Patient("Lester Guerra","Sarampeon","C"));
		
		assertEquals(vectorHeap.remove().getName(), "Roberto Ratas");
		assertEquals(vectorHeap.remove().getSymptom(), "Sarampeon");
		assertEquals(vectorHeap.size(), 2);
	}


}