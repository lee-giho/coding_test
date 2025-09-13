import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine()); // 수열의 길이 N 입력
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 수열 원소 입력
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // N=1이면 가능한 연속 구간의 길이는 1
    if (N == 1) {
      System.out.println(1);
      return;
    }

    int upLen = 1; // 현재까지 arr[i] >= arr[i-1]이 연속으로 유지된 구간의 길이
    int downLen = 1; // 현재까지 arr[i] <= arr[i-1]이 연속으로 유지된 구간의 길이
    int answer = 1;

    for (int i = 1; i < N; i++) {
      if (arr[i] >= arr[i-1]) { // 오름차순 조건 검사
        upLen++;
      } else {
        upLen = 1; // 오름차순이 아니면 구간 길이 1로 초기화
      }

      if (arr[i] <= arr[i-1]) { // 내림차순 조건 검사
        downLen++;
      } else {
        downLen = 1; // 내림차순이 아니면 구간 길이 1로 초기화
      }

      // 가장 긴 길이 찾기
      answer = Math.max(answer, Math.max(upLen, downLen));
    }

    System.out.println(answer);
  }
}