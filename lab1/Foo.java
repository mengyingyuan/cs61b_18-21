public class Foo {
    public int x, y;

public Foo (int x, int y) {
         this.x = x;
         this.y = y;
}
public static void switcheroo (Foo a, Foo b) {
        Foo temp = a;
        a = b;
        b = temp;
}
 public static void fliperoo (Foo a, Foo b) {
     Foo temp = new Foo(a.x, a.y);
      a.x = b.x;  30
      a.y = b.y;  40
       b.x = temp.x;
        b.y = temp.y;
}
 public static void swaperoo (Foo a, Foo b) {
         Foo temp = a;
         a.x = b.x;
        a.y = b.y;
         b.x = temp.x;
         b.y = temp.y;
         }
 public static void main (String[] args) {
         Foo foobar = new Foo(10, 20);
         Foo baz = new Foo(30, 40);
        switcheroo(foobar, baz);  // foobar.x: 10  foobar.y: 20  baz.x: 30 baz.y: 40
        fliperoo(foobar, baz); //foobar.x: 30  foobar.y: 40 baz.x: 10 baz.y: 20
         swaperoo(foobar, baz); //foobar.x: 10 foobar.y: 20 baz.x: 10 baz.y:20
        }
 }

// Discussion Q2
public class QuikMaths {
 public static void mulitplyBy3(int[] A) {
        for (int x: A) {
             x = x * 3;
             }
         }

public static void multiplyBy2(int[] A) {
int[] B = A;
 for (int i = 0; i < B.length; i+= 1) {
 B[i] *= 2;
}
 }

public static void swap (int A, int B ) {
 int temp = B;  7
 B = A; 6
 A = temp;  7
 }

 public static void main(String[] args) {
 int[] arr;
 arr = new int[]{2, 3, 3, 4};
 multiplyBy3(arr);

 /* Value of arr: {2,3,3,4} */

 arr = new int[]{2, 3, 3, 4};
 multiplyBy2(arr);

 /* Value of arr: {4,6,6,8} */

 int a = 6;
 int b = 7;
 swap(a, b);

 /* Value of a: 6 Value of b: 7 */
 }
}