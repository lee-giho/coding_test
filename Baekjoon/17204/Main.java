import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음
    StringTokenizer st = new StringTokenizer(br.readLine()); // 공백을 기준으로 잘라주는 st 생성

    int N = Integer.parseInt(st.nextToken()); // 게임에 참여하는 사람의 수 N 입력받기
    int bosung = Integer.parseInt(st.nextToken()); // 보성이의 번호 입력받기
    int count = 1; // 지목한 횟수
    int[] target = new int[N]; // 각 사람들이 지목한 사람의 번호 저장할 배열
    boolean[] visited = new boolean[N]; // 지모했던 사람인지 확인하는 배열

    for (int i = 0; i < N; i++) { // 사람들이 지목한 번호 저장
      target[i] = Integer.parseInt(br.readLine());
    }

    int next = target[0]; // 영기가 지목한 사람
    visited[0] = true;

    while (true) { // 한 사이클을 돌거나 보성이를 찾을 때까지 반복
      if (next == bosung) { // 보성이를 찾았을 경우
        break;
      }
      if (visited[next]) { // 한 사이클을 돌며 보성이를 찾지 못한 경우
        count = -1;
        break;
      }
      visited[next] = true; // 방문했다고 표시
      next = target[next]; // 다음으로 지목된 사람
      count++; // 지목한 횟수 +1
    }

    System.out.println(count);
  }
}