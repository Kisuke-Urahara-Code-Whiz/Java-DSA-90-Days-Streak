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
            while(a<size-1){
                temp=temp.next;
                a++;
            }
            temp.next = null;
            size--;
        }

    }

    public void deleteIndex(int index){
        if(index>size-1 || index<0)
            System.out.println("Invalid index");
        else if(size==0 || size==1)
            deleteFirst();
        else{
            if(index==0)
                deleteFirst();
            else if(index==size-1)
                deleteLast();
            else{
                Node temp = head;
                for(int i=1;i<=index-1;i++)
                    temp = temp.next;
                System.out.println("Deleting index "+index+" , value = "+temp.next.value);
                temp.next = temp.next.next;
                size--;
            }
        }
    }

    public int size(){
        return size;
    }

    //indexing starts from 0
    public void insertBefore(int value, int index){
        if(index>size-1 || index<0)
            System.out.println("Invalid index");
        else if(size==0 || size==1 || index==0)
            insertFirst(value);
        else{
            Node temp = head;
            for(int i=1;i<index;i++)
                temp = temp.next;
            Node node = new Node(value,temp.next);
            temp.next = node;
            size++;
        }


    }

    //indexing starts from 0
    public void insertAfter(int value, int index){
        if(index>size-1 || index<0)
            System.out.println("Invalid index");
        else if(size==0)
            insertFirst(value);
        else if(size==1)
            insertLast(value);
        else{
            if(index==size-1){
                insertLast(value);
            }
            else{
                insertBefore(value,index+1);
            }
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
