class Solution{
   static ArrayList<ArrayList<String>> displayContacts(int n, String[] contact, String s) {
        TreeMap<String, TreeSet<String>> prefixMap = new TreeMap<>();
        for (String c : contact) {
            String prefix = "";
            for (char ch : c.toCharArray()) {
                prefix += ch;
                prefixMap.computeIfAbsent(prefix, k -> new TreeSet<>()).add(c);
            }
        }

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        String prefix = "";
        for (char ch : s.toCharArray()) {
            prefix += ch;
            ArrayList<String> matches = new ArrayList<>(prefixMap.getOrDefault(prefix, new TreeSet<>()));
            if (matches.isEmpty()) matches.add("0");
            result.add(matches);
        }

        return result;
    }
}
