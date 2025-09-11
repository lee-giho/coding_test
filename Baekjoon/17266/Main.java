import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine()); // 굴다리의 길이 N
    int M = Integer.parseInt(br.readLine()); // 가로등 개수 M

    // 가로등 위치 입력
    int[] lamps = new int[M];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      lamps[i] = Integer.parseInt(st.nextToken());
    }

    // 왼쪽 끝부터 첫 번째 가로등까지의 길이
    int need = lamps[0];

    // 가운데 가로등 사이의 거리
    for (int i = 0; i < M-1; i++) {
      int gap = lamps[i+1] - lamps[i];
      int half = (gap+1) / 2;
      if (half > need) {
        need = half;
      }
    }

    // 오른쪽 끝부터 마지막 가로등까지의 거리
    int right = N - lamps[M-1];
    if (right > need) {
      need = right;
    }

    System.out.println(need);
  }
}