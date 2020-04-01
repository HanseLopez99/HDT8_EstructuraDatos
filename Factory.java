public class Factory<E extends Comparable<E>>{
    public PriorityQueue<E> getPriority(String priority){
        switch(priority){
            case "VectorHeap":
                return new VectorHeap<E>();
            case "PriorityQueue":
                return new PriorityJCF<E>();
            default: return null;
        }
    }
}