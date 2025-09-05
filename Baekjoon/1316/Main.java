import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int answer = 0;

    for (int i = 0; i < N; i++) {
      String word = br.readLine();
      if (isGroupWord(word)) {
        answer++;
      }
    }

    System.out.println(answer);
  }

  static boolean isGroupWord(String word) {
    boolean[] used = new boolean[26]; // 한 번 나타난 적이 있는 문자 표시
    int last = -1; // 이전 문자 인덱스

    for (int i = 0; i < word.length(); i++) {
      int current = word.charAt(i) - 'a'; // 알파벳을 인덱스 값으로 바꾸기
      if (current != last) { // 다른 글자가 나오는 순간
        if (used[current]) { // 이전에 나타났던 문자라면 다시 시작
          return false;
        }
        used[current] = true; // 처음 등장하는 문자로 시작
        last = current;
      }
    }
    return true;
  }
}