import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String N = br.readLine(); // 숫자를 문자열로 입력
    char[] digits = N.toCharArray(); // 각 자릿수를 문자 배열로 변환

    Arrays.sort(digits); // 오름차순 정렬

    StringBuilder sb = new StringBuilder(new String(digits));
    System.out.println(sb.reverse().toString()); // 내림차순으로 출력
  }
}