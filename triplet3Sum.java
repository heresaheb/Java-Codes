//package Others;     //Qs link posted below file name

import java.util.ArrayList;
import java.util.Arrays;

public class triplet3Sum {

    public static ArrayList<ArrayList<Integer>> tripletSet(int[] arr , int n, int K) {

        Arrays.sort(arr);
        // arraySort(arr);

        ArrayList<ArrayList<Integer>> ans= new ArrayList<>();



        for (int i = 0; i <n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int j2 = n-1; j2 > j; j2--) {
                    if (arr[i]+ arr[j]+ arr[j2] == K) {

                        ArrayList<Integer> list = new ArrayList<>();

                        list.add(arr[i]); 
                        list.add(arr[j]);
                        list.add(arr[j2]);

                        if(ans.contains(list)== false)
                        ans.add(list);

                        
                    }
                }
            }
        }

        return ans;
    }

    static int [] arraySort (int[] arr){
		
        for (int ind = 0; ind < arr.length; ind++) {

            for(int i= ind+1; i< arr.length ; i++ ){
    			if(arr[ind] > arr[i]){
    				int temp= arr[i];
    				arr[i] = arr[ind];
    				arr[ind] = temp;
    			}
    		}
        }

        return arr;

    }
    public static void main(String[] args) {
        int []a = {10 ,5, 5 ,5, 2};
        // int a [] = {-1, 0, 1, 2, -1, -4};
        // int a [] = {-1, 0, 1, 0};

        // tripletSet(a, 6, 5);

        ArrayList<ArrayList<Integer>> print1= new ArrayList<>();

        print1.addAll(tripletSet(a, 5, 12));

        for (ArrayList<Integer> arrayList : print1) {

            for (int i = 0; i < arrayList.size(); i++) {

                    System.out.print(arrayList.get(i)+" ");
                }
                System.out.println();

                //System.out.println(arrayList.isEmpty());
                
        }

    }

}


/*
Sample Input 1:
int []a = {10 ,5, 5 ,5, 2};
tripletSet(a, 5, 12)

Sample Output 1:
2 5 5

*/
    
