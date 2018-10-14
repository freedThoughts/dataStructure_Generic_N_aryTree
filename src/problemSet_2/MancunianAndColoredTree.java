package problemSet_2;

import java.util.Scanner;

//https://www.hackerearth.com/practice/data-structures/trees/binary-and-nary-trees/practice-problems/algorithm/mancunian-and-colored-tree/
public class MancunianAndColoredTree {

	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        String[] nameArray = name.split(" ");
        int N = Integer.valueOf(nameArray[0]);
        int C = Integer.valueOf(nameArray[1]);
        
        int[] arr = new int[1024];
        name = s.nextLine();
        String[] vertices = name.split(" ");
        name = s.nextLine();
        String[] colours = name.split(" ");
        for(int i = 0; i< N; i++){
        	if(i == 0){
        		arr[i] = Integer.valueOf(colours[i]);
        		continue;
        	}
        	
        	int value = Integer.valueOf(vertices[i - 1]);
        	if(arr[value *2] != 0){
        		arr[value *2] = Integer.valueOf(colours[i - 1]);
        	} else
        		arr[value *2 + 1] = Integer.valueOf(colours[i -1]);
        	
        }
        
        for(int i = 0; i<=N; i++)
        	System.out.print(arr[i] + ", ");

	}

}
