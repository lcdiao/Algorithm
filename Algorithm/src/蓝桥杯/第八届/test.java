package 第八届;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;

public class test {

	public static void main(String[] args) {
		Queue<Character> q = new LinkedList<Character>();
		q.add('a');
		q.add('b');
		q.add('c');
		for(Character c:q)System.out.print(c+" ");System.out.println();
		q.poll();
		for(Character c:q)System.out.print(c+" ");System.out.println();
		q.add('d');
		for(Character c:q)System.out.print(c+" ");System.out.println();
		q.peek();q.poll();
		for(Character c:q)System.out.print(c+" ");System.out.println();
		char cc=q.peek();
		System.out.println(cc);
		for(Character c:q)System.out.print(c+" ");System.out.println();
		
		JOptionPane.showMessageDialog(null, "33");
	}

}
