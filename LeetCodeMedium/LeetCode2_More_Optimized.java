package LeetCodeMedium;

public class LeetCode2_More_Optimized {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        LeetCode2_More_Optimized solution = new LeetCode2_More_Optimized();

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
