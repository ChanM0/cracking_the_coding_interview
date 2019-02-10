class IsUnique{

    public static void main(String[]args){

        System.out.println(Is_Unique("abc"));
        System.out.println(Is_Unique("abcdc"));
        System.out.println(Check_Permuation("abcdc","accdb"));
        System.out.println(Check_Permuation("abcdc","dccbe"));
        URLify("Mr John Smith             ".toCharArray(),13);
        // System.out.println(URLify("Mr John Smith"));
        // System.out.println(URLify("    h      "));
    }

    static boolean Is_Unique(String str)
    {
        if (str.length() > 128){
            return false;
        }

        boolean[] asciiAlphabet = new boolean[128]; 
        for(int i = 0; i < str.length(); i++){

            if(asciiAlphabet[str.charAt(i)])
                return false;
            asciiAlphabet[str.charAt(i)] = true;
        }
        return true;
    }

    static boolean Check_Permuation(String str1, String str2)
    {
        if( str1.length() != str2.length()){
            return false;
        }

        int[] char_count = new int[128];
        for(int i = 0; i < str1.length(); i++){
            char_count[str1.charAt(i)]++;
        }

        for(int j = 0; j < str2.length(); j++){
            char_count[str2.charAt(j)]--;
            if(char_count[str2.charAt(j)] < 0){
                return false;
            }
        }

        return true;

    }

    static void URLify(char[] str, int length)
    {
        final int SPACE = 32;
        int spaceCount = 0, newLength = 0, i = 0;

        for(i = 0; i < length; i++) {
            if (str[i] == ' ') 
                spaceCount++;
        }

        newLength = length + (spaceCount * 2);
        str[newLength] = '\0';
        for(i = length - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength -= 3;
            }
            else {
                str[newLength - 1] = str[i];
                newLength--;
            }
        }
        System.out.println(str);
    }

    static void palindrome_permuation(String str)
    {
        
    }
}