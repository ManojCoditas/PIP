/*
input : [2, 3, -2, 4, -1]
output:48
* */

public class _2_Max_product_subarray {

        public static int maxProductBruteForce(int[] nums) {
            int n = nums.length;
            int maxProduct = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                int product = 1;
                for (int j = i; j < n; j++) {
                    product *= nums[j];
                    maxProduct = Math.max(maxProduct, product);
                }
            }

            return maxProduct;
        }

        public static void main(String[] args) {
            int[] nums = {2, 3, -2, 4, -1};
            System.out.println("Maximum Product Subarray : " + maxProductBruteForce(nums));

        }
    }


