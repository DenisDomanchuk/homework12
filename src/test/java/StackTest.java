import org.junit.jupiter.api.Assertions;
import org.junit.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StackTest {

    @Test
    void shouldThrowExceptionEmptyStack() throws MyStackEmptyException {
        var mystack = new MyStack(10);
        mystack.deleteElement();
        MyStackEmptyException myStackEmptyException =
                assertThrows(MyStackEmptyException.class, () -> mystack.deleteElement());
        Assertions.assertEquals(myStackEmptyException.getMessage(), "Stack is empty");

    }

    @Test
    void shouldThrowExceptionFullStack() throws MyStackFullException {
        var mystack = new MyStack(10);
        MyStackFullException myStackFullException =
                assertThrows(MyStackFullException.class, () -> mystack.addElement(5));
        Assertions.assertEquals(myStackFullException.getMessage(), "Stack is full");
    }

    @Test
    public void shouldReturnOptionalFromReadTopElement() throws MyStackFullException {
        var mystack = new MyStack(10);
        mystack.addElement(10);
        Optional<Integer> integer = mystack.readTopElementOptional();
        Assertions.assertEquals(Optional.of(10), integer);
    }

    @Test
    public void shouldReturnEmptyOptionalReadTopElement() {
        var mystack = new MyStack(10);
        Optional<Integer> integer = mystack.readTopElementOptional();
        Assertions.assertEquals(Optional.empty(), integer);

    }

}




