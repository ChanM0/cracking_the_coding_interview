class IsUnique{

    public static void main(String[]args){

        System.out.println(IsUnique("abc"));
        System.out.println(IsUnique("abcdc"));
    }

    static boolean IsUnique(String str)
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



}