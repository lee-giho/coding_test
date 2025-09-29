import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 가지고 있는 숫자 카드의 개수 N 입력

    // N개의 숫자를 배열에 저장
    int[] cards = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      cards[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(cards); // 배열 오름차순 정렬

    int M = Integer.parseInt(br.readLine()); // 확인할 숫자 개수 M 입력

    // M개의 숫자를 이분 탐색을 통해 1/0으로 기록
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      int x = Integer.parseInt(st.nextToken());
      sb.append(Arrays.binarySearch(cards, x) >= 0 ? 1 : 0).append(" "); // 찾으면 인덱스 반환 / 즉, >= 0이 참
    }

    System.out.println(sb.toString());
  }
}