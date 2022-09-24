public class TriangleDrawer {
    public static void drawTriangle(int N) {
        int i,j;
        for(i = 1; i <= N; i+=1){
            for(j = 1; j< i; j+=1 ) {
                System.out.print('*');
            }
            System.out.println('*');
        }
    }

    public static void main(String[] args) {

        TriangleDrawer.drawTriangle(10);
    }
}