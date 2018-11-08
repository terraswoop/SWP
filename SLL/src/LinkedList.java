
public class LinkedList {
	private Node head;
	private int size=0;
	public void add(int value) {
		Node n=new Node(value);
		if(head==null) {
		head=n;
		}
		else {
			Node tmp=head;
			while(tmp.getNext()!=null) {
				tmp=tmp.getNext();
				
			}
			tmp.setNext(n);
		}
		size++;
	}
	public int getSize() {
		return size;
	}
	public void remove(int index) {
		Node tmp=head;
		for(int i=0;i<index;i++) {
			if(tmp.getNext()==null || head==null) {
				throw new IndexOutOfBoundsException();
			}
			tmp=tmp.getNext();
		}
		size--;
		Node prev=head;
		Node next=head;
		if(index==0) {
			head=head.getNext();
		}
		else {
			for(int i=0;i<index-1;i++) {
				prev=prev.getNext();
			}
			for(int i=0;i<index+1;i++) {
				next=next.getNext();
			}
			prev.setNext(next);
		}
	}
	public int getValue(int index){
		Node tmp=head;
		for(int i=0;i<index;i++) {
			if(tmp.getNext()==null) {
				throw new IndexOutOfBoundsException();
			}
			else {
			tmp=tmp.getNext();
			}
		}
		return tmp.getValue();
	}
}
