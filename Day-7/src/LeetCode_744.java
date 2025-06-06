//744. Find Smallest Letter Greater Than Target
//You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.
//
//Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.
//
//
//
//        Example 1:
//
//Input: letters = ["c","f","j"], target = "a"
//Output: "c"
//Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
//Example 2:
//
//Input: letters = ["c","f","j"], target = "c"
//Output: "f"
//Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.
//Example 3:
//
//Input: letters = ["x","x","y","y"], target = "z"
//Output: "x"
//Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].
//
//
//Constraints:
//
//        2 <= letters.length <= 104
//letters[i] is a lowercase English letter.
//letters is sorted in non-decreasing order.
//letters contains at least two different characters.
//target is a lowercase English letter.


//My-Solution
class LeetCode_744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int lexo = 123;
        for(int i=0;i<letters.length;i++){
            if(((int)letters[i])>(int)target && ((int)letters[i])<lexo){
                lexo = letters[i];
            }
        }
        if(lexo==123)
            return letters[0];
        else
            return (char)lexo;
    }

    //GPT-Binary Search
    public char nextGreatestLette(char[] letters, char target) {
        int l = 0, r = letters.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (letters[mid] <= target)
                l = mid + 1;
            else
                r = mid - 1;
        }

        return letters[l % letters.length];
    }



}
