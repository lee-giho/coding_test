import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음

    int n = Integer.parseInt(br.readLine()); // n 번째 피보나치 수를 구할 것인지 받음

    long ppreNum = 0; // i-2번째 수 | 즉, 0번째 수를 0으로 초기화
    long preNum = 1; // i-1번째 수 | 즉, 1번째 수를 1로 초기화
    long answer = (n == 0) ? 0 : 1; // i 번째 수 | 즉, 답인 n번째 수 | 아래의 for문이 2부터 시작하기 때문에 n = 0일 때 0, n = 1일 때 1로 초기화

    for (int i = 2; i < n+1; i++) { // n 번째 수를 구하기 위해 초기 값을 준 0번째, 1번째를 건너뛰고 2부터 시작
      answer = ppreNum + preNum; // 이전 두 수를 더해 다음 수를 구함
      ppreNum = preNum; // 다음 수의 계산을 위해 수를 앞으로 한 칸 당김
      preNum = answer; // 다음 수의 계산을 위해 수를 앞으로 한 칸 당김
    }

    System.out.println(answer);
  }
}