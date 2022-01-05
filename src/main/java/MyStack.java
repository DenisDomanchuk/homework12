import java.util.Optional;

public class MyStack {
    private final int[] stackArray;
    private int top;


    public MyStack(int size) {
        this.stackArray = new int[size];
        this.top = -1;
    }

    public void addElement(int element) throws MyStackFullException {
        if (isFull()) {
            throw new MyStackFullException("Stack is full of elements");
        } else {
            stackArray[++top] = element;

        }
    }

    public int deleteElement() throws MyStackEmptyException {
        if (isEmpty()) {
            throw new MyStackEmptyException("Stack is empty");
        } else {
            return stackArray[top--];
        }
    }

    public Optional<Integer> readTopElementOptional() {
        if (isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(stackArray[top]);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return (top == stackArray.length - 1);
    }
}
