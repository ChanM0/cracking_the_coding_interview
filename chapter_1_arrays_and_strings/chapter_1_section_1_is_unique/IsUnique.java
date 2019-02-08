class IsUnique{

    public static void main(String[]args){

        System.out.println(Is_Unique("abc"));
        System.out.println(Is_Unique("abcdc"));
        System.out.println(Check_Permuation("abcdc","accdb"));
        System.out.println(Check_Permuation("abcdc","dccbe"));
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



}