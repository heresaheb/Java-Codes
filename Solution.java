import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2,
            int m) {
        // Write Your Code Here.

        n--;
        while (n!= -1) {

                if (arr2.contains(arr1.get(n))) {

                    arr2.remove(arr2.indexOf(arr1.get(n)));
                }
            else
                arr1.remove(n);
            n--;
        }

            return arr1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr3 = new ArrayList<Integer>();
        ArrayList<Integer> arr4 = new ArrayList<Integer>();
        arr3.add(11);
        arr3.add(4);
        arr3.add(5);
        // arr3.add(3);

        arr4.add(3);
        arr4.add(4);
        arr4.add(11);
        // arr4.add(3);

        System.out.println(findArrayIntersection(arr3, 3, arr4, 3));
    }
}
