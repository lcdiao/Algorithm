public class 选择排序 {
    public static void main(String[] args) {
        int[] a = new int[]{5,2,4,7,6,10,1,3,8,9};

        selection_sort(a);
        for(int i:a){
            System.out.print(i+"\t");
        }
    }
    //每次从i位起将最小的放在第i位
    public static void selection_sort(int[] a){
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]>a[j]){
                    a[i]^=a[j];
                    a[j]^=a[i];
                    a[i]^=a[j];
                }
            }
        }
    }
}
