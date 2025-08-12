import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력 받음

    int n = Integer.parseInt(br.readLine()); // 단어 수 N 정수로 형변환 후 입력

    String[] words = new String[n]; // 단어 수 N개에 대한 배열
    for (int i = 0; i < n; i++) { // 배열에 단어 저장
      words[i] = br.readLine();
    }
    
    words = Arrays.stream(words).distinct().toArray(String[]::new); // 배열 요소 중복 제거

    Arrays.sort(words, (o1, o2) -> { // 배열 정렬
      int o1L = o1.length();
      int o2L = o2.length();
      if (o1L == o2L) {  // 문자의 길이가 같은 경우
        return o1.compareTo(o2); // 사전 순으로 정렬
      } else {
        return o1L - o2L; // 문자 길이 순으로 정렬
      }
    });

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 0; i < words.length; i++) {
      bw.write(words[i]); // 단어 출력
      bw.newLine(); // 줄바꿈
    }
    bw.close();
  }
}