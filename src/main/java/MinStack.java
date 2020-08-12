import java.util.ArrayList;
import java.util.List;

/**
 * @author schandna created on 10/04/20
 */
public class MinStack {

    /** initialize your data structure here. */
    List<Integer> st = null;
    List<Integer> minList = null;
    int idx = -1;

    public MinStack() {
        st = new ArrayList<>();
        minList = new ArrayList<>();
    }

    public void push(int x) {
        st.add(x);
        idx++;
        insertInMin(x);
    }

    private void insertInMin(int x){
        int i=0;
        for(; i<minList.size(); i++){
            if(minList.get(i)>x){
                break;
            }
        }
        minList.add(i, x);
    }

    public void pop() {
        // if(idx == -1){
        //     throw new AssertionError("Runtime Error");
        //     // return;
        // }
        int val = st.remove(idx);
        idx--;

        minList.remove(new Integer(val));
    }

    public int top() {
        // if(idx == -1){
        //     throw new AssertionError("Runtime Error");
        // }
        return st.get(idx);
    }

    public int getMin() {
        // if(idx == -1) {
        //     throw new AssertionError("Runtime Error");
        //     // return -1;
        // }

        return minList.get(0);
    }

    public static void main(String[] args) {

        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();   //--> Returns -3.
        minStack.pop();
        minStack.top();      //--> Returns 0.
        minStack.getMin();

//        System.out.println(minStack.stList.remove(new Integer(2)));
        System.out.println(minStack);

    }

    class MinStack2 {
        private Node head;

        public void push(int x) {
            if(head == null) {
                head = new Node(x, x);
            } else {
                head = new Node(x, Math.min(x, head.min), head);
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }

        private class Node {
            Node next;
            int val;
            int min;

            private Node(int val, int min) {
                this(val, min, null);
            }

            private Node(int val, int min, Node next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }

        }
    }

}
