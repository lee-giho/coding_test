import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음

    int N = Integer.parseInt(br.readLine()); // 배달해야 할 설탕의 무게

    int answer = -1; // 기본값: 불가능할 경우 -1
    int canFive = N / 5; // 5kg 봉지를 사용할 수 있는 최대 개수

    // 5kg 봉지를 최대한 많이 쓰는 경우부터 하나씩 줄여가며 3kg 봉지로 채울 수 있는지 확인
    while (canFive >= 0) {
      int remainNum = N - (canFive * 5); // 5kg 봉지를 뺀 나머지 무게
      if (remainNum % 3 == 0) { // 나머지가 3으로 나누어 떨어지면
        answer = canFive + (remainNum / 3); // 총 봉지의 개수
        break;
      }
      canFive--;
    }

    System.out.println(answer);
  }
}