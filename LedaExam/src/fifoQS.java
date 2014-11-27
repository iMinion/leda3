import java.util.Scanner;



class myStack<E> {
	private Object[] stack;
	int size = 0;
	int index = 0;
	
	public myStack() {
		stack = new Object[10];
	}
	
	public void push(E item) {
		if(size == stack.length) {
			Object[] tempStack = new Object[2*size];
			System.arraycopy(stack, 0, tempStack, 0, stack.length);
			stack = tempStack;
		}
		stack[size++] = item;
	}
	
	@SuppressWarnings("unchecked")
	public E pop() {
		if(size == 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		else {
			Object temp = stack[size -1];
			stack[size - 1] = null;
			--size;
			return (E)temp;
		}
	}
	
	@SuppressWarnings("unchecked")
	public E peek() {
		if(size == 0 || size == 1) {
			throw new ArrayIndexOutOfBoundsException();
		}
		else {
			return (E) stack[size - 1];
		}
	}
	public int size() {
		return size;
	}
	public String toString() {
		String s = "";
		for(int i = 0; i < size; ++i) {
			if(i < size -1) {
				s = s + stack[i] + ",";
			}
			else {
				s = s + stack[i];
			}
		}
		return s;
	}
}

public class fifoQS {
	public static void main(String[] args) {
		myStack<Integer> stack = new myStack<Integer>();
		myStack<Integer> temp = new myStack<Integer>();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String s = sc.nextLine();
			if(s.substring(0,3).equals("pus")) {
				int a = Integer.parseInt(s.substring(s.indexOf(" ") + 1));
				stack.push(a);
			}
			if(s.equals("pop")) {
				int i = 0;
				while(i < stack.size() - 1) {
					temp.push(stack.pop());
				}
				stack.pop();
				stack = temp;
                temp = new myStack<Integer>();
                System.out.println(stack);
			}		
		}
		System.out.println(stack);
		sc.close();
	}
}