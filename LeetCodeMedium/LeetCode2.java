package LeetCodeMedium;

import java.math.BigInteger;

public class LeetCode2 {
//    **
//     * Definition for singly-linked list.
     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
//     *

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode temp1 = l1;
         ListNode temp2 = l2;
         String n1 = "";
         String n2 = "";
        while(temp1!=null){
            n1 = String.valueOf(temp1.val)+n1;
            temp1 = temp1.next;
        }
        while(temp2!=null){
            n2 = String.valueOf(temp2.val)+n2;
            temp2 = temp2.next;
        }
        BigInteger num1 = new BigInteger(n1);
        BigInteger num2 = new BigInteger(n2);
        BigInteger sum = num1.add(num2);
        String s = sum.toString();
        ListNode head = null;
        ListNode current = null;
        if(s.equals('0')){
            head = new ListNode(0);
        }
        else{
            int length = s.length();
            for(int i=0; i<length; i++){
                if(head==null && current==null){
                    char lastDigit = s.charAt(s.length()-1);
                    ListNode temp = new ListNode(Integer.parseInt(String.valueOf(lastDigit)));
                    head = temp;
                    current = temp;
                }
                else{
                    char lastDigit = s.charAt(s.length()-1);
                    ListNode temp = new ListNode(Integer.parseInt(String.valueOf(lastDigit)));
                    current.next = temp;
                    current = temp;
                }
                s = s.substring(0,s.length()-1);
            }
        }
        return head;
    }

    public static void main(String[] args) {
        LeetCode2 solution = new LeetCode2();

        int[] arr1 = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
        int[] arr2 = {5,6,4};

        ListNode l1 = solution.createLinkedList(arr1);
        ListNode l2 = solution.createLinkedList(arr2);

        System.out.print("Input List 1: ");
        printLinkedList(l1);

        System.out.print("Input List 2: ");
        printLinkedList(l2);

        ListNode result = solution.addTwoNumbers(l1, l2);

        System.out.print("Result List:  ");
        printLinkedList(result);
    }

    public ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode head = null;
        ListNode current = null;
        for(int i=0; i<arr.length; i++){
            if(head==null){
                ListNode temp = new ListNode(arr[i]);
                head = temp;
                current = temp;
            }
            else {
                ListNode temp = new ListNode(arr[i]);
                current.next = temp;
                current = temp;
            }
        }

        return head;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
