import java.util.Stack;

class MyQueue {

    // Two stacks are used to simulate the queue behavior
    Stack<Integer> stack1; // Used for push (newest elements on top)
    Stack<Integer> stack2; // Used for pop/peek (oldest elements on top)

    // Constructor to initialize the stacks
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Push element x to the back of the queue
    public void push(int x) {
        // Always push to stack1
        stack1.push(x);
    }

    // Removes the element from the front of the queue and returns it
    public int pop() {
        // If stack2 is empty, move all elements from stack1 to stack2
        // This reverses the order so the oldest element is on top of stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        // Pop from stack2 (front of queue)
        return stack2.pop();
    }

    // Get the front element without removing it
    public int peek() {
        // Transfer elements if stack2 is empty (same as pop logic)
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        // Peek from stack2 (front of queue)
        return stack2.peek();      
    }

    // Returns true if the queue is empty
    public boolean empty() {
        // Queue is empty only when both stacks are empty
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
