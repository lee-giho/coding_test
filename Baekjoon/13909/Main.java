import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    long N = Long.parseLong(br.readLine()); // 창문과 사람의 수 입력

    long count = (long)Math.sqrt(N); // N 이하의 제곱수 개수
    System.out.println(count);
  }
}