import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); // 녹색거탑의 높이 N 입력

    int count = (int) Math.pow(2, N); // 2의 N제곱 계산
    System.out.println(count);
  }
}