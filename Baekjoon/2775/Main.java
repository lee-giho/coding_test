import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음

    int T = Integer.parseInt(br.readLine()); // Test case의 수 T를 입력받는다.

    for (int t = 0; t < T; t++) { // Test case의 수만큼 반복
      int floor = Integer.parseInt(br.readLine()); // 몇 층인지 입력받기
      int number = Integer.parseInt(br.readLine()); // 몇 호인지 입력받기

      int[][] numOfMember = new int[floor+1][number]; // 0층을 포함한 floor과 number에 맞는 배열 생성
      for (int n = 0; n < number; n++) { // 0층의 1호 ~ number호까지 인원수를 1 ~ number로 입력
        numOfMember[0][n] = n+1;
      }
      for (int f = 1; f < floor+1; f++) { // 1층부터 floor층까지 반복
        for (int n = 0; n < number; n++) { // 1호부터 number호까지 반복
          if (n == 0) { // 각 층의 1호는
            numOfMember[f][n] = 1; // 인원수가 1
          } else { // 1층 이상, 2호 이상은
            numOfMember[f][n] = numOfMember[f][n-1] + numOfMember[f-1][n]; // 인원수가 자신의 이전 호의 인원수와 바로 아래층 호의 인원수의 합과 같다
          }
        }
      }
      System.out.println(numOfMember[floor][number-1]); // floor와 number에 만족하는 인원수 출력
    }
  }
}