public class maxValue {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        int i;
        int value = m[0];
        for(i = 1; i< m.length; i+=1) {
            if (m[i] > value){
                value = m[i];
            }
        }
        return value;
    }
    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        System.out.println(maxValue.max(numbers));
    }
}