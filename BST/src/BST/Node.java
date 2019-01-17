package BST;

public class Node<T> {
private Node<T> smaller=null;
private Node<T> bigger=null;
private Node<T> parent=null;
private T value;
public Node(T value){
	this.value=value;
}
public boolean biggerThan(Node<T> n) {
	return (int)this.value>(int)n.getValue();
}
public Node<T> getSmaller() {
	return smaller;
}

public void setSmaller(Node<T> smaller) {
	this.smaller = smaller;
}
public Node<T> getNode(){
	return this;
}
public Node<T> getBigger() {
	try {return bigger;}
	catch(NullPointerException e) {
		return null;
	}
}

public void setBigger(Node<T> bigger) {
	this.bigger = bigger;
}

public Node<T> getParent() {
	return parent;
}

public void setParent(Node<T> parent) {
	this.parent = parent;
}
public T getValue() {
	return value;
}
public void setValue(T value) {
	this.value = value;
}
}
