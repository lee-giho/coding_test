import java.io.*;

public class Main {
  static int count; // 재귀 함수 호출 횟수

  // 팰린드롬인지 판별
  public static int recursion(String s, int l, int r) {
    count++;
    if (l >= r) return 1; // 문자열의 중앙이면 팰린드롬 O
    else if (s.charAt(l) != s.charAt(r)) return 0; // 좌우가 다르면 X
    else return recursion(s, l + 1, r - 1); // 좌우가 같으면 안쪽으로 이동
  }

  // 팰린드롬 판별 함수
  public static int isPalindrome(String s) {
    count = 0;
    return recursion(s, 0, s.length() - 1);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

    while(T-- > 0) {
      String s = br.readLine();
      int result = isPalindrome(s);
      sb.append(result).append(" ").append(count).append("\n");
    }

    System.out.println(sb.toString());
  }
}