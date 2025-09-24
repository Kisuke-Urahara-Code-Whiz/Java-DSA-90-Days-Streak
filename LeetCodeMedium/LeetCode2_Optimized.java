package LeetCodeMedium;

import Programs.CarrySum;

import java.util.ArrayList;

public class LeetCode2_Optimized {
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
        ListNode head = null;
        ListNode current = null;
        int carry = 0;
        int sum = 0;
        CarrySum obj = new CarrySum();
        ArrayList<Integer> arr = new ArrayList<>();
        while(!n1.isEmpty() || !n2.isEmpty()){
            if(n1.isEmpty()){
                if(n2.length()==1){
                    int res = obj.addition(Integer.parseInt(String.valueOf(n2.charAt(n2.length()-1))),0, carry,true);
                    sum = res;
                }
                else{
                    arr = obj.addition(Integer.parseInt(String.valueOf(n2.charAt(n2.length()-1))),0, carry);
                    sum = arr.get(0);
                    carry = arr.get(1);
                }
                n2 = n2.substring(0,n2.length()-1);
            }
            else if(n2.isEmpty()){
                if(n1.length()==1){
                    int res = obj.addition(Integer.parseInt(String.valueOf(n1.charAt(n1.length()-1))),0, carry, true);
                    sum = res;
                }
                else{
                    arr = obj.addition(Integer.parseInt(String.valueOf(n1.charAt(n1.length()-1))),0, carry);
                    sum = arr.get(0);
                    carry = arr.get(1);
                }
                n1 = n1.substring(0,n1.length()-1);
            }
            else{
                if(n1.length()==1 && n2.length()==1){
                    int res = obj.addition(
                            Integer.parseInt(String.valueOf(n1.charAt(n1.length()-1))),
                            Integer.parseInt(String.valueOf(n2.charAt(n2.length()-1))),
                            carry,
                            true
                    );
                    sum = res;
                }
                else{
                    arr = obj.addition(
                            Integer.parseInt(String.valueOf(n1.charAt(n1.length()-1))),
                            Integer.parseInt(String.valueOf(n2.charAt(n2.length()-1))),
                            carry
                    );
                    sum = arr.get(0);
                    carry = arr.get(1);
                }
                n2 = n2.substring(0,n2.length()-1);
                n1 = n1.substring(0,n1.length()-1);
            }
            if(String.valueOf(sum).length()>1){
                int[] temp_arr = new int[2];
                temp_arr[0] = sum%10;
                temp_arr[1] = sum/10;
                ListNode tempo = createLinkedList(temp_arr);
                if(head==null)
                    head = tempo;
                else
                    current.next = tempo;
            }
            else{
                if(head==null){
                    ListNode temp = new ListNode(sum);
                    head = temp;
                    current = temp;
                }
                else {
                    ListNode temp = new ListNode(sum);
                    current.next = temp;
                    current = temp;
                }
            }
        }

        return head;
    }

    public static void main(String[] args) {
        LeetCode2_Optimized solution = new LeetCode2_Optimized();

        int[] arr1 = {5};
        int[] arr2 = {5};

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

