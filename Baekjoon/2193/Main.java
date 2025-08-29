import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음

    int N = Integer.parseInt(br.readLine()); // 몇 자리 수의 이친수 개수를 구할 것인지 입력

    long[] pnList = new long[N+1]; // 각 숫자에 대한 이친구 개수 저장할 배열

    // 1과 2를 1로 초기화
    pnList[1] = 1;
    if (N > 1) {
      pnList[2] = 1;
    }

    // 3부터 식을 통해 N자리 수의 이친수 개수를 구해간다.
    for (int i = 3; i < N+1; i++) {
      pnList[i] = pnList[i-1] + pnList[i-2];
    }

    System.out.println(pnList[N]);
  }
}