public class Solution {
    public static String genString(String... args) {
        String template = args[0];
        StringBuffer sBuff = new StringBuffer();
        int i = 0;
        while(i < template.length()) {
            char c = template.charAt(i);
            if(c != '$') {
                sBuff.append(c);
            } else {
                if(i != template.length() - 1) { 
                    char nextC = template.charAt(++i);   
                    if(nextC == '$') {
                        sBuff.append(nextC);
                    } else if(nextC >= '0' && nextC <= '9') {
                        int idx = nextC - '0';
                        if(idx + 1 >= args.length) {
                            throw new IllegalArgumentException();
                        } 
                        sBuff.append(args[idx + 1]);
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
            }
            i++;
        }
        return sBuff.toString();
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String tpl = "Hello $0, wahaha $3 waaaa $2 asdfasf $1";
       
        System.out.println(genString(tpl, "test1", "test2", "test3", "test4"));
    }
    

}
