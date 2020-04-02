public class Factory<E extends Comparable<E>>{
	/**
	 * method to create an object using factory
	 * @param priority
	 * @return VectorHeap<E> or PriorityJCF<E> or null
	 */
    public PriorityQueue<E> getPriority(String priority){
        switch(priority){
            case "VectorHeap":
                return new VectorHeap<E>();
            case "PriorityQueueJCF":
                return new PriorityJCF<E>();
            default: return null;
        }
    }
}