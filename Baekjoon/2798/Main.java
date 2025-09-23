import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 카드의 개수 N 입력
    int M = Integer.parseInt(st.nextToken()); // 목표값 M 입력

    // 카드 배열에 N개의 숫자 저장
    int[] cards = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      cards[i] = Integer.parseInt(st.nextToken());
    }

    int answer = 0; // M을 넘지 않는 가장 큰 합

    // 카드 3장 선택
    for (int i = 0; i < N-2; i++) {
      for (int j = i+1; j < N-1; j++) {
        for (int k = j+1; k < N; k++) {
          int best = cards[i] + cards[j] + cards[k]; // 뽑은 카드의 합

          // 최대값 갱신
          if (best <= M && best > answer) {
            answer = best;
          }
        }
      }
    }

    System.out.println(answer);
  }
}