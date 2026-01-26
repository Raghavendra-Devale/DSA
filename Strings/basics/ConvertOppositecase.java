package Strings.basics;

public class ConvertOppositecase {
    public static void convertCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                sb.append((char) (ch -32));
            }else{
                sb.append((char) (ch+32));
            }
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        String str = "RajaRama";
        convertCase(str);
    }
}

/*
This program converts each character of a string to its opposite case.
It iterates through the string character by character using a loop.
If the character is lowercase, it converts it to uppercase using ASCII subtraction.
Otherwise, it converts the character to lowercase using ASCII addition.
The converted characters are stored using StringBuilder.
Finally, the modified string is printed.
 */
