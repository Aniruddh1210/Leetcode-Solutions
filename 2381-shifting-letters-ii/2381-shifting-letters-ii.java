//Approach (Using Difference Array Technique) watch codestorywithmik

class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n]; // Difference array with size n

        // Step 1: Populate the difference array
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            if (direction == 1) { // Forward shift
                diff[start] += 1;
                if (end + 1 < n) {
                    diff[end + 1] -= 1;
                }
            } else { // Backward shift
                diff[start] -= 1;
                if (end + 1 < n) {
                    diff[end + 1] += 1;
                }
            }
        }

        // Step 2: Compute the prefix sum to get the net shifts for each character
        for (int i = 1; i < n; i++) {
            diff[i] += diff[i - 1]; // Add the value from the previous index
        }

        // Step 3: Apply the shifts to the string
        StringBuilder result = new StringBuilder(s);
        for (int i = 0; i < n; i++) {
            int shift = diff[i] % 26; // Ensure shift is within the range [0, 25]
            if (shift < 0) {
                shift += 26; // Handle negative shifts (backward)
            }

            // Apply the shift to character
            char newChar = (char) (((result.charAt(i) - 'a' + shift) % 26) + 'a');
            result.setCharAt(i, newChar);
        }

        return result.toString();
    }
}



//TLE SOLN
// class Solution {
//     public String shiftingLetters(String s, int[][] shifts) {
//         int[] input = new int[s.length()];
//         Arrays.fill(input,0);
//         for(int i=0;i<shifts.length;i++){
//             for(int j=shifts[i][0];j<shifts[i][1]+1;j++){
//                 if(shifts[i][2]==1){
//                     input[j] = input[j] + 1;
//                 }else{
//                     input[j] = input[j] -1;
//                 }
//             }
//         }

//         // change the alphabets

//         char[] result = s.toCharArray(); // Convert string to char array
//         for (int i = 0; i < result.length; i++) {
//             result[i] = (char) (((result[i] - 'a' + input[i]) % 26 + 26) % 26 + 'a');
//         }
//         return new String(result);
//     }
// }