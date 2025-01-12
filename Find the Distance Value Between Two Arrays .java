class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
    int distanceValue = 0;

        // Loop through each element in arr1
        for (int num1 : arr1) {
            boolean isValid = true;

            // Compare with each element in arr2
            for (int num2 : arr2) {
                if (Math.abs(num1 - num2) <= d) {
                    isValid = false;
                    break; // No need to check further for this num1
                }
            }

            // If num1 is valid (all differences > d), increment the count
            if (isValid) {
                distanceValue++;
            }
        }

        return distanceValue;
    }
}
