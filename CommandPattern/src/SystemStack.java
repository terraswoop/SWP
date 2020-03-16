import java.util.*; 
	
public class SystemStack<T> {
  
private Stack<T> stack;
public SystemStack() {
	stack=new Stack<T>();
}
	    void stack_push(T value) 
	    {    
	            stack.push(value);
	            System.out.println(value);
	    } 
	      
	     
	    void stack_pop() 
	    {        
	            stack.pop();   
	    } 
	  
	    T stack_peek() 
	    { 
	    	System.out.println(stack.peek());
	        return (T) stack.peek();
	        
	    } 
	    T stack_search( int element) 
	    { 
	        int pos =  stack.search(element); 
	        if(pos == -1) { 
	            System.out.println("Element not found");
	        return null;
	        }
	        else {
	        	System.out.println(stack.peek());
	        	return stack.get(pos);
	        }
	            
	    } 
}
