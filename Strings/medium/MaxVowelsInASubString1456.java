package Strings.medium;

public class MaxVowelsInASubString1456 {

//    time limit exceeds for larger inputs
    public static int maxVowelsBrute(String s, int k) {
        int maxVowels = 0;

//        missed equals and last element was considered
        for (int i = 0; i <= s.length() - k; i++) {
            int vowels = 0;
            for (int j = i; j < i + k; j++) {
                if (isVowel(s.charAt(j))){
                    vowels++;
                }
            }
            maxVowels = Math.max(vowels, maxVowels);
        }

        return maxVowels;
    }

    public static int maxVowelsOpti(String s, int k) {
        int windowVowels = 0;

        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))){
                windowVowels++;
            }
        }
        int maxVowels = windowVowels;
        for (int i = k; i < s.length(); i++) {
//            When i = k, you're adding the new character at index k.
//
//So you need to remove the character that is leaving the window: index i - k.
//
//You currently have:
//            if (isVowel(s.charAt(i))) {
//                windowVowels--;
//            }

            if (isVowel(s.charAt(i - k))){
                windowVowels--;
            }
//            mistook and did i + k
            if (isVowel(s.charAt(i))){
                windowVowels++;
            }
            maxVowels = Math.max(maxVowels,windowVowels);

        }

        return maxVowels;
    }

    public static boolean isVowel(char ch){
        if (ch == 'a'|| ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "weallloveyou";
        System.out.println("Brute "+ maxVowelsBrute(s,7));
        System.out.println("Optimal "+ maxVowelsOpti(s,3));
    }
}
