public class Problem_05 {
    final Container[] containers;
    final static int CONTAINERSIZE = 100000;

    public Problem_05() {
        containers = new Container[CONTAINERSIZE];
    }

    public void put(int key, int value) {
        int i = hash(key);
        if (containers[i] == null) {
            containers[i] = new Container();
        }
        ListNode prev = find(containers[i], key);
        if (prev.next == null) {
            prev.next = new ListNode(key, value);
        } else {
            prev.next.val = value;
        }
    }

    public int get(int key) {
        int i = hash(key);
        if (containers[i] == null) {
            return -1;
        }
        ListNode node = find(containers[i], key);
        return node.next == null ? -1 : node.next.val;
    }

    public void remove(int key) {
        int i = hash(key);
        if (containers[i] == null) {
            return;
        }
        ListNode prev = find(containers[i], key);
        if (prev.next == null) {
            return;
        }
        prev.next = prev.next.next;
    }

    private int hash(int key) {
        return Integer.hashCode(key) % containers.length;
    }

    private ListNode find(Container Container, int key) {
        ListNode node = Container.head;
        ListNode prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Problem_05 hashMap = new Problem_05();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println("hashmap.get(1): " + hashMap.get(1)); // returns 1
        System.out.println("hashmap.get(3): " + hashMap.get(3)); // returns -1 (not found)
        hashMap.put(2, 1); // update the existing value
        System.out.println("hashmap.get(2): " + hashMap.get(2)); // returns 1
        hashMap.remove(2); // remove the mapping for 2
        System.out.println("hashmap.get(2): " + hashMap.get(2)); // returns -1 (not found)
    }
}

class Container {
    final ListNode head = new ListNode(-1, -1);
}

class ListNode {
    int key;
    int val;
    ListNode next;

    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
