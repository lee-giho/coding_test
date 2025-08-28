import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음

    int N = Integer.parseInt(br.readLine()); // 전체 사람의 수 입력

    int[] number = new int[5]; // 한 사람이 받는 카드 5장
    int[] maxNum = new int[N]; // 각 사람의 가장 큰 일의 자리
    int maxNumber = 0; // 가장 큰 일의 자리 숫자
    int personNumber = 0; // 가장 큰 일의 자리 숫자를 가진 사람의 번호

    for (int p = 0; p < N; p++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      for (int m = 0; m < 5; m++) { // 카드 다섯장 받기
        number[m] = Integer.parseInt(st.nextToken());
      }

      // 각 사람의 최대 숫자 구하기
      for (int i = 0; i < 5; i++) {
        for (int j = i+1; j < 5; j++) {
          for (int k = j+1; k < 5; k++) {
            int now = (number[i] + number[j] + number[k]) % 10; // 현재 가져온 세 숫자 합의 일의 자리
            if (now > maxNum[p]) { // 현재 구한 값이 더 크면
              maxNum[p] = now;
            }
          }
        }
      }
    }

    // 사람들 중 누가 더 큰 수를 가지고 있는지 확인하기
    for (int i = 0; i < N; i++) {
      if (maxNum[i] >= maxNumber) { // 같은 숫자일 경우 뒷 번호 사람을 출력해야 하기 때문에 등호도 넣음
        maxNumber = maxNum[i];
        personNumber = i + 1;
      }
    }

    System.out.println(personNumber);
  }
}