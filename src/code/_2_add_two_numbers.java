package code;

public class _2_add_two_numbers {
    public static void main(String[] args) {
        int[] i1 = { 9};
        int[] i2 = {1,9,9,9,9,9,9,9,9,9};
        ListNode l1 = null;
        ListNode ll1 = null;
        ListNode l2 = null;
        ListNode ll2 = null;
        for (int i : i1) {
            if (l1==null){
                l1 = new ListNode(i);
                ll1 = l1;
            }else {
                l1.next = new ListNode(i);
                l1 = l1.next;
            }
        }
        for (int i : i2) {
            if (l2==null){
                l2 = new ListNode(i);
                ll2 = l2;
            }else {
                l2.next = new ListNode(i);
                l2 = l2.next;
            }
        }
        Solution2 solution2 = new Solution2();
        ListNode listNode = solution2.addTwoNumbers(ll1, ll2);
        print(listNode);
    }
    public static void print(ListNode listNode){
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

//  Definition for singly-linked list.
class ListNode {
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

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val+l2.val;
        int plus = sum>9?1:0;
        ListNode res = new ListNode(sum%10);
        ListNode temp = res;
        ListNode b1 = l1.next;
        ListNode b2 = l2.next;
        while(b1!=null||b2!=null||plus==1){
            int sumt = (b1!=null?b1.val:0)+(b2!=null?b2.val:0)+plus;
            plus=sumt>9?1:0;
            temp.next = new ListNode(sumt%10);
            temp=temp.next;
            if(b1!=null){
                b1=b1.next;
            }
            if(b2!=null){
                b2=b2.next;
            }
        }
        return res;
    }
}
