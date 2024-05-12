package s1mpl3.coder.service;

public class FindServise {
    public boolean search(String s, String word){
        s = s.toUpperCase();
        word = word.toUpperCase();
        if (s.length() > word.length()) return false;
        else if (s.length() == word.length() && s.equals(word)) return true;
        else {
            int c=0;
            for (int i=s.length(); i<word.length()+1; i++){
                if (s.equals(word.substring(0+(c++),i))) return true;
            }
            return false;
        }

    }
}
