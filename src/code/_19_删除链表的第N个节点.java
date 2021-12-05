package code;

public class _19_删除链表的第N个节点 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
//        ListNode h = head1;
//        ListNode head2 = new ListNode(2);
//        ListNode head3 = new ListNode(3);
//        ListNode head4 = new ListNode(4);
//        ListNode head5 = new ListNode(5);
//        head4.next=head5;
//        head3.next = head4;
//        head2.next = head3;
//        head1.next = head2;
        Solution solution = new Solution();
        solution.removeNthFromEnd(head1,1);
    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode h2 = head;
            ListNode h1 = head;
            int index = 0;

            Integer length =1;
            while (true){
                h1 = h1.next;
                if(h1==null){
                    break;
                }else {
                    length++;
                }
            }
            n = length-n;
            if(n == 0){
                h2 = head.next;
                return h2;
            }
            while (h2 != null) {
                if (index == n-1) {
                    h2.next = h2.next.next;
                    break;
                } else {
                    h2 = h2.next;
                    index++;
                }
            }
            return head;
        }
    }

    //      Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
