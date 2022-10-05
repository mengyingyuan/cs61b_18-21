
public class ArrayDequeTest {
    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     * && is the "and" operation. */
    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");

        ArrayDeque<String> a1 = new ArrayDeque<>();

        boolean passed = checkEmpty(true, a1.isEmpty());

        a1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        passed = checkSize(1, a1.size()) && passed;
        passed = checkEmpty(false, a1.isEmpty()) && passed;

        a1.addLast("middle");
        passed = checkSize(2, a1.size()) && passed;

        a1.addLast("back");
        passed = checkSize(3, a1.size()) && passed;

        System.out.println("Printing out deque: ");
        a1.printDeque();

        printTestStatus(passed);

    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");


        ArrayDeque<Integer> a1 = new ArrayDeque<>();
        // should be empty
        boolean passed = checkEmpty(true, a1.isEmpty());

        a1.addFirst(10);
        // should not be empty
        passed = checkEmpty(false, a1.isEmpty()) && passed;

        a1.removeFirst();
        // should be empty
        passed = checkEmpty(true, a1.isEmpty()) && passed;

        printTestStatus(passed);

    }

    //check what happens if the data structure goes from empty, to some non-zero size (e.g. 4 items)
    // back down to zero again, and then back to some non-zero size. This is a common oversight.
    public static void printTest() {
        ArrayDeque<Integer> a1 = new ArrayDeque<>();
        for (int i = 0; i < 5; i += 1) {
            a1.addFirst(1);
            a1.addFirst(2);
            a1.addFirst(3);
            a1.addLast(4);
            a1.printDeque();
            System.out.println(", size = " + a1.size());
        }

        for (int i = 0; i < 5; i += 1) {
            a1.removeFirst();
            a1.removeLast();
            a1.removeFirst();
            a1.removeLast();
            a1.printDeque();
            System.out.println(", size = " + a1.size());
        }
        System.out.print(a1.isEmpty()); // True
        a1.addLast(3);
        a1.addFirst(1);
        a1.addLast(4);
        a1.printDeque(); // 1 3 4
    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
        printTest();
    }

}
