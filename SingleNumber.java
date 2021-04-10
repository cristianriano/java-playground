import java.util.Arrays;

public class SingleNumber {
  public static void main(String[] args) {
    int[] x = {4, 3, 2, 4, 1, 1, 2};
    System.out.println(Arrays.toString(x));
    System.out.println(solution(x));
  }

  // Given a list of numbers, where every number shows up twice except for one number, find that one number.
  // Challenge: Find a way to do this using O(1) memory.
  public static int solution(int[] nums) {
    quickSort(nums, 0, nums.length - 1);
    System.out.println(Arrays.toString(nums));

    int prev = nums[0], count = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == prev) {
        count++;
      } else {
        if (count == 1) { return nums[i-1]; }
        count = 1;
      }

      prev = nums[i];
    }

    return -1;
  }

  public static void quickSort(int[] nums, int first, int last) {
    int i = first, j = last, pivot = (first + last)/2;

    while(i < j) {
      while (nums[i] < nums[pivot]) { i++; }
      while (nums[j] > nums[pivot]) { j--; }

      if (i <= j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

        i++;
        j--;
      }
    }

    if (j > first) { quickSort(nums, first, j); }
    if (i < last) { quickSort(nums, i, last); }
  }
}
