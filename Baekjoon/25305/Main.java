import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음
    StringTokenizer st = new StringTokenizer(br.readLine()); // 공백을 기준으로 잘라주는 st 생성

    int n = Integer.parseInt(st.nextToken()); // 응시자 수 n
    int k = Integer.parseInt(st.nextToken()); // 상을 받는 사람의 수 k

    Integer[] scores = new Integer[n]; // 상을 받는 사람의 수 k에 대한 배열
    st = new StringTokenizer(br.readLine()); // 둘째 줄로 넘어가기
    for (int i = 0; i < n; i++) { // n명의 응시자들 점수 배열에 저장
      scores[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(scores, Collections.reverseOrder()); // 점수를 내림차순으로 정렬

    System.out.println(scores[k-1]); // 상을 받는 사람들 중 가장 낮은 점수 출력
  }
}