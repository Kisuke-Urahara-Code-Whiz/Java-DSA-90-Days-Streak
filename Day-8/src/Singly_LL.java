public class Singly_LL {

    private Node head;
    private int size;

    public Singly_LL(){
        this.size = 0;
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;
        size+=1;
    }

    public void insertLast(int value){
        if(size==0)
            insertFirst(value);
        else{
            Node node = new Node(value);
            node.next = null;
            Node temp = head;
            int a = 1;
            while(a<=size-1){
                temp=temp.next;
                a++;
            }
            temp.next = node;
            size++;
        }

    }

    public void deleteFirst(){
        if(size!=0){
            if(size==1)
                head = null;
            else
                head = head.next;
            size--;
        }
    }

    public void deleteLast(){
        if(size<2)
            deleteFirst();
        else{
            Node temp = head;
            int a = 1;
            while(a<=size-1){
                temp=temp.next;
                a++;
            }
            temp.next = null;
            size--;
        }

    }

    public void displaySize(){
        System.out.println("Size of the linked list is - "+size);
    }

    public void display() {
        Node temp = head;
        System.out.println("Linked List:");
        System.out.print("START -> ");
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }


}
