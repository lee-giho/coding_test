import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine()); // 수의 개수 입력
        int[] nums = new int[N];

        // N개의 정수 배열에 입력
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(nums); // 오름차순 정렬
        
        // 한 줄에 하나씩 출력 문자열에 담기
        for (int x : nums) {
            sb.append(x).append('\n');
        }
        
        System.out.println(sb.toString());
    }
}