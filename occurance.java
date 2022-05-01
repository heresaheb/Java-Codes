//Question Link Given Below under the file name.

import java.util.*;
public class occurance {

    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.
		int count =1;
		int a [] = new int[2]; 
		a[0] =-1;
		a[1]=-1;
		int i=0;
		for(int temp : arr){
			
			if(temp == k){
				
				if(i==0){
				a[i]= count-1;   //1st occur
				i++;
				}
				
				 if(i==1){
					a[i]= count-1;  //last occur
				 }
				
			}
			
			else if(a[0]!= -1 && a[1] == -1 && count == n){
				a[1] = a[0];
			} 
			
		    else if(a[0]== -1 && count == n){
				a[0]= -1;
				a[1]= -1;
			}
			count++;
		}
		
		return a;
		
    }

};
