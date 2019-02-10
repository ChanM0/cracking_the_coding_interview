class IsUnique{

    public static void main(String[]args){

        System.out.println(Is_Unique("abc"));
        System.out.println(Is_Unique("abcdc"));
        System.out.println(Check_Permuation("abcdc","accdb"));
        System.out.println(Check_Permuation("abcdc","dccbe"));
        URLify("Mr John Smith             ".toCharArray(),13);
        System.out.println(palindrome_permuation("Tact Coa"));
        System.out.println(one_way("pale","ple"));
        System.out.println(one_way("pales","pale"));
        System.out.println(one_way("pale","bale"));
        System.out.println(one_way("pale","bake"));
        System.out.println(string_compression("aabcccccaaa"));
        System.out.println(string_compression("aaaaaaaaaa"));
        System.out.println(string_compression("aa"));
        System.out.println(string_compression("ab"));
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

    static int[] getOccruanceTable(String str)
    {
        int z = Character.getNumericValue('z'), a = Character.getNumericValue('a');
        int[] occuranceCharTable = new int[ z - a + 1];
        int x = -1, value = 0;


        for(char c : str.toCharArray()){
            value = Character.getNumericValue(c);

            if(a <= value && value <= z){
                value = value - a;
                occuranceCharTable[value]++;
            } 

        }

        return occuranceCharTable;

    }

    static boolean palindrome_permuation(String str)
    {
        int[] occuranceCharTable = getOccruanceTable(str);
       

        boolean odd = false;

        for(int v : occuranceCharTable){
            if( v%2 == 1 ){
                if(odd){
                    return false;
                }
                odd = true;
            }
        }

        return true;
    }

    static boolean a_single_letter_change(String str1,String str2)
    {
        boolean morethanOneLetterChange = false;

        for(int i = 0; i < str1.length(); i++)
        {
            if( str1.charAt(i) != str2.charAt(i) ){
                if(morethanOneLetterChange){
                    return false;
                }
                morethanOneLetterChange = true;
            }
        }
        return true;
    }

    static boolean remove_a_letter(String str1,String str2)
    {
        int[] occuranceCharTable = new int[ 128 ];

        for(char c : str1.toCharArray()){
            occuranceCharTable[c]++;
        }

        boolean morethanOneLetterChange = false; 
        for(char c: str2.toCharArray()){
            occuranceCharTable[c]--;
            if(occuranceCharTable[c] == -1){
                if(morethanOneLetterChange){
                    return false;
                }
                morethanOneLetterChange = true;
            }
        }

        return true;
    }

    static boolean one_way(String str1, String str2)
    {
        int str1Len = str1.length();
        int str2Len = str2.length();

        if( str1Len == str2Len){
            return a_single_letter_change(str1,str2);
        }
        else if( str1Len+1 == str2Len ){
            return remove_a_letter(str1,str2);
        }
        else if (str1Len == str2Len+1){
            return remove_a_letter(str2,str1);
        }
        return false;
    }


    static String string_compression(String str)
    {
        if(str.length() <= 1) return str;

        StringBuilder ans = new StringBuilder(); 

        char prev = str.charAt(0), curr = str.charAt(1);

        int counter = 1;

        for(int i = 1; i < str.length(); i++)
        {
            prev = str.charAt(i-1);
            curr = str.charAt(i);

            if(prev==curr){
                counter++;
            }
            else if(prev!=curr){
                ans.append(prev);
                ans.append(counter);
                counter = 1;
            }
        }
        ans.append(curr);
        ans.append(counter);

        return (ans.length() <= str.length()) ? ans.toString() : str;
    }
}