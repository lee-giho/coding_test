import java.io.*;

public class Main2 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음

    int n = Integer.parseInt(br.readLine()); // n 번째 피보나치 수를 구할 것인지 받음

    if (n < 2) { // n이 0 또는 1일 경우
      System.out.println(n);
      return; // 종료
    }

    long[] nums = new long[n+1]; // 0번째 숫자도 포함하기 때문에 n+1 크기의 배열 생성
    nums[0] = 0; // 0번째 0으로 초기화
    nums[1] = 1; // 1번째 1로 초기화

    for (int i = 2; i < n+1; i++) {
      nums[i] = nums[i-2] + nums[i-1]; // 이전의 두 수를 더해 i번째에 저장
    }

    System.out.println(nums[n]);
  }
}