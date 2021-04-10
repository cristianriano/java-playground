import java.util.Arrays;

class MedianSortedArrays {
  public static void main(String[] args) {
    int[] x = {3};
    int[] y = {};
    double d = findMedianSortedArrays(x,y);
    System.out.println(d);
  }

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int totalSize = nums1.length + nums2.length;

    boolean avg;
    int medianPos;
    if (totalSize == 0) {
      return 0.0;
    } else if (totalSize == 1) {
      if (nums1.length == 0) { return nums2[0]; }
      return nums1[0];
    }
    else if (totalSize % 2 == 0) {
      avg = true;
      medianPos = (totalSize / 2) - 1;
    } else {
      avg = false;
      medianPos = (totalSize / 2);
    }

    int i = 0, j = 0, k = 0;
    int[] merged = new int[totalSize];

    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] > nums2[j]) {
        merged[k] = nums2[j];
        j++;
      } else {
        merged[k] = nums1[i];
        i++;
      }
      k++;
    }

    if (i < nums1.length) {
      for (; i < nums1.length; i++) {
        merged[k] = nums1[i];
        k++;
      }
    }
    if (j < nums2.length) {
      for (; j < nums2.length; j++) {
        merged[k] = nums2[j];
        k++;
      }
    }

    if (avg) {
      return (merged[medianPos] + merged[medianPos + 1]) / 2.0;
    } else {
      return Double.valueOf(merged[medianPos]);
    }
  }
}