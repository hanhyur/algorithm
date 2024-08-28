import java.util.*;
import java.io.*;

public class Main{
    static StringTokenizer st;
    static int[] heapSort;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        heapSort = new int[n];

        for(int i=0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            heapSort[i] = input;
        }
        buildMaxHeap();

        for(int output: heapSort){
            bw.write(String.valueOf(output));
            bw.newLine();
        }
        bw.flush();
    }

    public static void buildMaxHeap(){
        if(heapSort == null || heapSort.length < 1){
            return;
        }
        
        for(int i = heapSort.length / 2; i >= 0; i--){
            heapify(heapSort, i, heapSort.length);
        }

        for(int i = heapSort.length - 1; i >= 0; i--) {
            int temp = 0;
            temp = heapSort[0];
            heapSort[0] = heapSort[i];
            heapSort[i] = temp;
            heapify(heapSort, 0, i);
        }
    }

    public static void heapify(int[] unsorted, int index, int heapSize){
        int largest = index;
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        int temp = 0;

        if(leftIndex < heapSize && unsorted[leftIndex] > unsorted[largest]){
            largest = leftIndex;
        }
        if(rightIndex < heapSize && unsorted[rightIndex] > unsorted[largest]){
            largest = rightIndex;
        }

        if(largest != index){
            temp = heapSort[largest];
            heapSort[largest] = heapSort[index];
            heapSort[index] = temp;
            heapify(heapSort, largest, heapSize);
        }
    }
}