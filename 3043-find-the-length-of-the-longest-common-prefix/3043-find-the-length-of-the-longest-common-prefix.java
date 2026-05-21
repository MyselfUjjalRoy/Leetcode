class Solution { // pasted
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
         HashSet<String> prefixesSet = new HashSet<>();
        for (int num : arr1) {
            String numStr = String.valueOf(num);
            for (int i = 1; i <= numStr.length(); i++) {
                prefixesSet.add(numStr.substring(0, i));
            }
        }
        
        // Step 2: Check prefixes of arr2 elements against the HashSet
        int maxLength = 0;
        for (int num : arr2) {
            String numStr = String.valueOf(num);
            // Check from longest to shortest for efficiency
            for (int i = numStr.length(); i > 0; i--) {
                String prefix = numStr.substring(0, i);
                if (prefixesSet.contains(prefix)) {
                    maxLength = Math.max(maxLength, i);
                    break; // Found the longest prefix for this number
                }
            }
        }
        
        return maxLength;
    }
}