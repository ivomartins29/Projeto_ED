package linkedstack;

public class LinearNodeDemo {

	public static void main(String[] args) throws EmptyCollectionException {
		LinearNode<String> newObj_a=new LinearNode("Charmander!");
		LinearNode<String> newObj_b=new LinearNode("Bulbussaur!");
		LinearNode<String> newObj_c=new LinearNode("Wobbuffet!");
		LinearNode<String> newObj_d=new LinearNode("Zubat!");
		LinearNode<String> newObj_e=new LinearNode("Caterpie!");
		LinearNode<String> newObj_f=new LinearNode("Diglett!");
		LinearNode<String> newObj_g=new LinearNode("Pikachu!");
 		LinkedStack<Object> newNode = new LinkedStack(newObj_a);
		newNode.push(newObj_b);
		newNode.push(newObj_c);
		newNode.push(newObj_d);
		newNode.push(newObj_e);
		newNode.push(newObj_f);
		newNode.push(newObj_g);
		newNode.toString();
		System.out.println("STACK SIZE: "+newNode.size());
		System.out.println("////////////|\\\\\\\\\\\\");
		System.out.println("Removed: "+newNode.peek());
		newNode.pop();
		System.out.println("////////////|\\\\\\\\\\\\");
		newNode.toString();
		System.out.println("////////////|\\\\\\\\\\\\");
		System.out.println("Removed: "+newNode.peek());
		newNode.pop();
		System.out.println("////////////|\\\\\\\\\\\\");
		newNode.toString();
		System.out.println("////////////|\\\\\\\\\\\\");
		System.out.println("Removed: "+newNode.peek());
		newNode.pop();
		System.out.println("////////////|\\\\\\\\\\\\");
		newNode.toString();
		System.out.println("////////////|\\\\\\\\\\\\");
		System.out.println("Removed: "+newNode.peek());
		newNode.pop();
		System.out.println("////////////|\\\\\\\\\\\\");
		newNode.toString();
		System.out.println("////////////|\\\\\\\\\\\\");
		System.out.println("Removed: "+newNode.peek());
		System.out.println(newNode.isEmpty());
		newNode.pop();
		System.out.println("////////////|\\\\\\\\\\\\");
		newNode.toString();
		System.out.println("////////////|\\\\\\\\\\\\");
		System.out.println("Removed: "+newNode.peek());
		newNode.pop();
		System.out.println("////////////|\\\\\\\\\\\\");
		newNode.toString();
		System.out.println("////////////|\\\\\\\\\\\\");
		System.out.println("Removed: "+newNode.peek());
		newNode.pop();
		System.out.println(newNode.isEmpty());

	}

}
