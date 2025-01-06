//optimal soln 
class Solution{
    public int[] minOperations(String boxes) {

        int[]result = new int[boxes.length()];
        
        int leftballs = 0, leftmoves = 0, rightballs = 0,rightmoves = 0;

        for(int i=0; i<boxes.length();i++){
            result[i] += leftmoves;
            leftballs += Character.getNumericValue(boxes.charAt(i));
            leftmoves += leftballs;
        } 
        for(int j=boxes.length()-1;j>=0;j--){
            result[j] += rightmoves;
            rightballs += Character.getNumericValue(boxes.charAt(j));
            rightmoves += rightballs;
        }
        return result;
    }
}



// class Solution {
//     public int[] minOperations(String boxes) {
//         char[] box = boxes.toCharArray();
//         ArrayList<Integer> list = new ArrayList<>();
//         for (int i = 0; i < box.length; i++) {
//             if (box[i] == '1') {
//                 list.add(i);
//             }
//         }
//         int[] result = new int[box.length];
//         for (int i = 0; i < result.length; i++) {

//             for (int j = 0; j < list.size(); j++) {
//                 result[i] += Math.abs(i - list.get(j));
//             }
//         }
//         return result;
//     }
// }