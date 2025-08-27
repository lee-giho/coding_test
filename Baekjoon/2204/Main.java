import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력 받음
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while(true) { // n이 0이 될 때까지 반복
      int n = Integer.parseInt(br.readLine()); // 단어의 개수 입력받기
      
      if (n == 0) { // 0이 될때, 남은 테스트 케이스가 없기 때문에 반복문 종료
        break;
      }

      String[] words = new String[n];
      for (int i = 0; i < n; i++) { // n개의 단어 입력받기
        words[i] = br.readLine();
      }

      Arrays.sort(words, (o1, o2) -> { // 단어를 소문자로 바꾼 뒤, 오름차순 정렬한다.
        String word1 = o1.toString().toLowerCase();
        String word2 = o2.toString().toLowerCase();
        return word1.compareTo(word2);
      });

      bw.write(words[0]); // 사전상 가장 앞서는 단어 버퍼에 저장
      bw.newLine(); // 줄바꿈
    }

    bw.flush(); // 버퍼에 저장되어 있는 문자열 출력
    bw.close(); // 스트림 종료
  }
}