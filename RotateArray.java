import java.util.Arrays;

public class RotateArray {
  public static void main(String[] args) {
    int[] nums = {1,2,3,4,5};
    System.out.println(Arrays.toString(solution(nums, 6)));
  }

  public static int[] solution(int[] A, int K) {
    if (A.length == 0) { return new int[0]; }

    int[] rotated = new int[A.length];
    int rotations = K % A.length;

    for (int i = 0; i < A.length; i++) {
      if (i >= rotations) {
          rotated[i] = A[i - rotations];
      } else {
          rotated[i] = A[A.length - rotations + i];
      }
    }

    return rotated;
  }
}
