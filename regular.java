// Regex character classes, quantifiers and metacharacters from : https://www.javatpoint.com/java-regex

import java.util.regex.*;

class regular {
    public static void main(String[] args) throws java.lang.Exception {
        Boolean b = Pattern.matches("[a-zA-Z]*\\s*[0-9]*","ABCCCCCCCCaaaaa     02342352");
        // [a-z] any values from a to z
        // [A-Z] any values from A to Z
        // writing side by side means OR. E.g. : [a-zA-Z] : a-z or A-Z
        // * : occurrence of 0 or more times
        // \\s : any form of white space
        // [0-9] : Any digits 0 to 9
        // Giving \\s between [a-zA-Z] and [0-9] means it will not accept spaces before [a-zA-Z] or after [0-9]
        System.out.println(b);
    }
}