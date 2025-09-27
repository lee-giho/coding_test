import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 자연수 5개를 배열에 입력하고, 합계에 저장.
        int[] nums = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            nums[i] = Integer.parseInt(br.readLine().trim());
            sum += nums[i];
        }
        
        Arrays.sort(nums); // 배열 오름차순 정렬

        int avg = sum / 5; // 평균 계산
        int median = nums[2]; // 중앙값
        
        System.out.println(avg);
        System.out.println(median);
    }
}