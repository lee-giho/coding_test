import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음

    int N = Integer.parseInt(br.readLine()); // 정수 N을 입력받는다.

    int[] cnts = new int[N+1]; // 각 숫자가 갖는 연산의 최솟값을 저장할 배열 / 인덱스와 정수는 동일하다.
    cnts[1] = 0; // 1은 이미 1이므로 0으로 초기화

    for (int i = 2; i < N+1; i++) {
      // -1은 전부 할 수 있는 연산이기 때문에 기본으로 먼저 처리한다.
      // 조건에 맞게 2와 3으로 나누기를 진행하며 이전에 했던 연산과 최솟값 비교를 해 더 작은 수를 best에 저장한다.
      int best = cnts[i-1] + 1; // -1 연산
      if (i%2 == 0) best = Math.min(best, cnts[i/2] + 1); // 2로 나누기
      if (i%3 == 0) best = Math.min(best, cnts[i/3] + 1); // 3으로 나누기
      cnts[i] = best; // 최솟값을 해당 수의 인덱스에 저장
    }

    System.out.println(cnts[N]); // 정수 N이 가지는 연산의 최솟값을 출력한다.
  }
}