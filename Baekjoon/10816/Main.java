import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 가지고 있는 숫자 카드의 개수 입력
    HashMap<Integer, Integer> countMap = new HashMap<>(); // 숫자 카드에 대해 나온 횟수 저장하는 Map

    // 숫자 카드 입력받고 나온 횟수 계산 후 입력
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      countMap.put(num, countMap.getOrDefault(num, 0) + 1);
    }

    int M = Integer.parseInt(br.readLine()); // 가지고 있는지 숫자인지 확인할 질문의 수 입력
    st = new StringTokenizer(br.readLine());

    // 질문의 숫자 개수를 확인하고 출력 버퍼에 저장
    for (int i = 0; i < M; i++) {
      int query = Integer.parseInt(st.nextToken());
      sb.append(countMap.getOrDefault(query, 0)).append(" ");
    }

    System.out.println(sb.toString().trim());
  }
}