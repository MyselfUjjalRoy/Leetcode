class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        Set<String> validBusinessLines = new HashSet<>(Arrays.asList("electronics", "grocery", "pharmacy", "restaurant"));
        Map<String, List<String>> couponsByLine = new HashMap<>();

        for (int i = 0; i < code.length; i++) {
            String c = code[i];
            String b = businessLine[i];

            if (isActive[i] &&
                c != null && !c.isEmpty() &&
                c.matches("[a-zA-Z0-9_]+") &&
                validBusinessLines.contains(b)) {

                couponsByLine.putIfAbsent(b, new ArrayList<>());
                couponsByLine.get(b).add(c);
            }
        }

        List<String> result = new ArrayList<>();
        List<String> businessOrder = Arrays.asList("electronics", "grocery", "pharmacy", "restaurant");

        for (String line : businessOrder) {
            List<String> coupons = couponsByLine.getOrDefault(line, new ArrayList<>());
            Collections.sort(coupons);
            result.addAll(coupons);
        }

        return result;
    }
}