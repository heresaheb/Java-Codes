/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class checkCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        


        while(fast.next.next != null){
                    
            
                    slow= slow.next;
                    fast = fast.next.next;
                    
                    if(fast.next == null)
                        return false;
            
                    if(slow == fast)
                        return true; 
                }
                
        return false;
    }
}
