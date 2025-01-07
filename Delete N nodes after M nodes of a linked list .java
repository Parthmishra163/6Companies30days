class Solution {
    static void linkdelete(Node head, int n, int m) {
             Node curr = head;

        while (curr != null) {
            // Skip m nodes
            for (int i = 1; i < m && curr != null; i++) {
                curr = curr.next;
            }

            // If current is null, return as there's nothing to delete
            if (curr == null) return;

            // Start deleting the next n nodes
            Node temp = curr.next;
            for (int i = 0; i < n && temp != null; i++) {
                temp = temp.next;
            }

            // Link the remaining nodes
            curr.next = temp;
            curr = temp;
        }
    }
}
