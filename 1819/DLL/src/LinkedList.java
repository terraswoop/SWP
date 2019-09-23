
public class LinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size=0;
	public void add(T value) {
		Node<T> n=new Node<T>(value);
		if(head==null) {
		head=n;
		tail=n;
		}
		else {
			Node<T> tmp=head;
			while(tmp.getNext()!=null) {
				tmp=tmp.getNext();
				
			}
			tmp.setNext(n);
			n.setPrevious(tmp);
			tail=n;
		}
		size++;
	}
	public int getSize() {
		return size;
	}
	public void remove(int index) {
		//if(index<size/2) {
		Node<T> tmp=head;
		for(int i=0;i<index;i++) {
			if(tmp.getNext()==null || head==null) {
				throw new IndexOutOfBoundsException();
			}
			tmp=tmp.getNext();
		}
		size--;
		Node<T> prev=head;
		Node<T> next=head;
		if(index==0) {
			head=head.getNext();
			tmp.setPrevious(head);
		}
		else if(index==size) {
			tail=tail.getPrevious();
			tmp.setNext(tail);
		}
		else {
			for(int i=0;i<index-1;i++) {
				prev=prev.getNext();
			}
			for(int i=0;i<index+1;i++) {
				next=next.getNext();
			}
			prev.setNext(next);
			if(next.getPrevious()!=null) {
				next.setPrevious(prev);
			}
			
		}
	/*}
		else {
		Node<T> tmp=tail;
		for(int i=size;i>index;i--) {
			if(tmp.getPrevious()==null || tail==null) {
				throw new IndexOutOfBoundsException();
			}
			tmp=tmp.getPrevious();
		}
		size--;
		Node<T> prev=tail;
		Node<T> next=tail;
		if(index==size) {
			tail=tail.getPrevious();
			tmp.setNext(tail);
		}
		else {
			for(int i=size;i>index-1;i--) {
				prev=prev.getPrevious();
			}
			for(int i=size;i>index+1;i--) {
				next=next.getNext();
			}
			prev.setNext(next);
			if(next.getPrevious()!=null) {
				next.setPrevious(prev);
			}
			
		}
		}*/
	}
	public T getValue(int index){
		if(index<size/2) {
			Node<T> tmp=head;
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
	else {
		Node<T> tmp=tail;
		if(index>=size) {
			throw new IndexOutOfBoundsException();
		}
			for(int i=size-1;i>index;i--) {
				if(tmp.getPrevious()==null) {
					throw new IndexOutOfBoundsException();
				}
				else {
				tmp=tmp.getPrevious();
			}
			}
			return tmp.getValue();
		}
	}
}
