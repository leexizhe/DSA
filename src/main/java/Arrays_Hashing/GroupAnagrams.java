package Arrays_Hashing;

import java.util.*;

public class GroupAnagrams {
    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> list = new LinkedList<>();

        for (String str: strs) {
            char[] arr = new char[26];
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }

            String strKey = String.valueOf(arr);
            map.computeIfAbsent(strKey, k -> new ArrayList<>());
            map.get(strKey).add(str);
        }

        return new ArrayList<>(map.values());

//        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
//            List<String> l1 = new LinkedList<>();
//            for (String s : entry.getValue()){
//                l1.add(s);
//            }
//            list.add(l1);
//        }
//        return list;

    }

    public static void main(String[] args) {
        String[] strings1 = {"eat","tea","tan","ate","nat","bat"};
        String[] strings2 = {"eat", "tea", "ate"};
        String[] strings3 = {"a"};
        System.out.println(groupAnagrams(strings1));
        System.out.println(groupAnagrams(strings2));
        System.out.println(groupAnagrams(strings3));
    }
}
