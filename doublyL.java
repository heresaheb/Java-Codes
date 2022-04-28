package Others;

// Linked_List Functions: (AddNode , Traverse, Reverse ,  Delete , Insert) Nodes.

public class doublyL {

    class Node {  //For Node Class with its attributes
        int data;
        Node left;
        Node right;

        public Node(int d) {  //Node Constructor
            data = d;
        }
    }

    static Node head = null;
    static Node tail = null;

    void addNode(int d) {

        Node node = new Node(d);

        if (head == null) {

            head = tail = node;
            head.left = null;
            tail.right = null;
        }

        else {
            tail.right = node;
            tail = node;
            tail.right = null;
        }
    }

    void addAfterPos(int Search_data, int value) {

        Node temp = head;

        Node node = new Node(value);
        Node pointer = node;

        // For update the value before searching value
        if (temp.data == Search_data) {

            temp.left = pointer; // update the head prev val
            pointer.right = temp; // update the new Node next val

            {
                pointer.left = null; // new Node prev null if there are no values in prev.
                head = pointer; // pointer over to head
            }
            return;
        }

        while (temp.data != Search_data) {

            if (temp.right == null) {
                System.out.println("Searching Value Not found \n");
                return;
            }
            temp = temp.right;
        }

        Node temp2 = temp.right;

        // Note: Always try to add the value using the reference of new Node.
        // & 1st update the value of old nodes before than new Nodes.

        temp.right = pointer;
        pointer.left = temp;

        temp2.left = pointer;
        node.right = temp2;
    }

    static void printList() {
        Node pointer = head;

        while (pointer != null) {

            System.out.print(" Node Val " + pointer.data);

            System.out.println();

            pointer = pointer.right;
        }
    }

    // static void swap(Node node) {
    // Node left = node.left;
    // node.left = node.right;
    // node.right = left;
    // }

    static Node reverse() {
        // Using two pointers 1st pointer intialized with the head,
        // and other node initializing with the right after head node;
        Node pointer = head;
        Node pointer2 = head.right;

        pointer.right = null; // To update the only 1st Node. This must be outside of the loop.
        pointer.left = pointer2;

        // This piece of code update the other Nodes , Under the While loop.
        while (pointer2 != null) {

            pointer2.left = pointer2.right; // swap every single middle nodes address.
            pointer2.right = pointer; // For rotate the LinkedList

            pointer = pointer2; // To step forward.
            pointer2 = pointer2.left; // Cause we intialize left with right side of the node.

        }

        // Hand-Over the pointer to its original head.
        head = pointer;
        return head;
    }

    static Node deleteNode(int SerachNodeData) {

        Node temp = head;

        if (temp.data == SerachNodeData && temp.right == null) {
            temp = null;
            head = temp;
            System.out.println("Head is Now point to the null! \n");
            return head;
        }

        // Always Keep In Mind:
        // That Any new node should be iterate from the head node 1st.
        // Means you have to initialized the new node with the head Node
        // Otherwise any other references contains in its null Value

        Node temp2 = head;
        Node temp3 = head.right;

        while (temp2.right.data != SerachNodeData) { // temp2 here for to point temp previous node.
            temp2 = temp2.right;
        }

        while (temp.data != SerachNodeData) { // temp use for the check of seraching value.
                                              // temp3 here for point to after temp next node.
            temp = temp.right;

            // Case1: if there have no node containg the seraching val.

            if (temp3.right == null && temp.data != SerachNodeData) {
                System.out.println("We didn't find any node with this value!");
                return head;
            }

            // Case2: If there have nodes right after temp Node.
            else if (temp3.right != null) {
                temp3 = temp3.right;
            }

            // Case3: If there have no node after temp
            else if (temp.data == SerachNodeData && temp3.right == null) {
                temp2.right = null;
                System.out.println("Node value " + temp.data + " has been deleted! \n");
                // tail = temp2;
                return head;
            }

        }

        if (temp.data == SerachNodeData) {
            // Joining with temp2 To temp3 for delete the pointing temp node only.
            temp2.right = temp3;
            temp3.left = temp2;
            System.out.println("Node value " + temp.data + " has been deleted! \n");

        }

        return head;
    }

    static Node InsertValue(int Search_data, int Update_Data) {

        Node temp = head;
        while (temp.data != Search_data && temp.right != null) {
            temp = temp.right;
        }
        if (temp.data != Search_data) {
            System.out.println("Didn't find a node with that Val=> " + Search_data);
            return head;
        }
        temp.data = Update_Data;
        System.out.println(Search_data+" val has been updated over old value of that node. ");
        return head;
    }

    public static void main(String[] args) {

        doublyL list = new doublyL();
         //This function use reference of public Class,
         //Cause in this function  didn't use Static Keyword.

        list.addNode(10); 
        list.addNode(20);
        list.addNode(70);
        list.addNode(100);

        list.addAfterPos(20, 30); //Searching Val, New Node Val

        deleteNode(20); //Searching Val

        InsertValue(70, 75);  //Searching Val,  Inserted Val

        System.out.println("Before Reverse the List: \n");
        printList();

        // here using \n To separate the result from the printing statement
        // Or you can use \t using for starting a new line without middle gaps.

        System.out.println("And After Reverse the list: \n");
        reverse();
        printList();
    }
}

/* OUTPUT:

Node value 20 has been deleted! 

70 val has been updated over old value of that node.
 
Before Reverse the List:

 Node Val 10
 Node Val 30
 Node Val 75
 Node Val 100

And After Reverse the list:

 Node Val 100
 Node Val 75
 Node Val 30
 Node Val 10

*/