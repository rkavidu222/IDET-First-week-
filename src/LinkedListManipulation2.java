public class LinkedListManipulation2 {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node reverse(Node node) {
        if (node == null)
            return null;
        if (node.next == null) {
            head = node;
            return node;
        }
        Node node1 = reverse(node.next);
        node1.next = node;
        node.next = null;
        return node;
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LinkedListManipulation2 list = new LinkedListManipulation2();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);
        list.head.next.next.next.next=new Node(87);

        System.out.println("Given Linked list");
        list.printList(head);

        list.reverse(list.head);

        System.out.println("\nReversed linked list");
        list.printList(head);
    }
}


/*Recursive method
Time Complexity : O(N), Visiting every node of the linked list of size N
Space Complexity: O(N)*/