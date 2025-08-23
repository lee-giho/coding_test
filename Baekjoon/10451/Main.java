import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine()); // Test case의 수 T를 입력받는다.

    for (int t = 0; t < T; t++) {
      int N = Integer.parseInt(br.readLine()); // 순열의 크기 N을 입력받는다.
      int arr[] = new int[N+1]; // 노드 값 배열에 저장
      boolean visited[] = new boolean[N+1]; // 방문한 노드인지 저장하는 배열
      int count = 0; // 몇 개의 순열 사이클이 있는지

      StringTokenizer st = new StringTokenizer(br.readLine()); // 공백을 기준으로 잘라주는 st 생성
      for (int i = 1; i < N+1; i++) {
        arr[i] = Integer.parseInt(st.nextToken()); // 노드 값 배열에 저장
      }

      for (int i = 1; i < N+1; i++) { // 순열 사이클 확인
        if (!visited[i]) { // 방문하지 않은 노드라면
          visited[i] = true; // 방문했다고 표시
          int next = arr[i]; // 다음으로 이동할 노드
          while (true) {
            if (visited[next]) { // 순열 사이클이 만들어졌다면
              count++; // 순열 사이클 개수 증가
              break;
            }
            visited[next] = true; // 방문했다고 표시
            next = arr[next]; // 다음으로 이동할 노드
          }
        }
      }

      bw.write(Integer.toString(count)); // 해당 테스트 케이스의 답
      bw.newLine(); // 줄바꿈
    }

    bw.flush(); // 버퍼에 저장되어 있는 문자열 출력
    bw.close(); // 스트림 종료
  }
}