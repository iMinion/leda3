import java.util.Scanner;

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