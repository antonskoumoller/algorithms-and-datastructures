public class DetectCircularString {
    public static void main(String[] args) {
        
    }

    public static boolean hasCircularString(String t, String s) {
        String ss = s + s;
        String tt = t + t;
        return ss.contains(t) && tt.contains(s) && s.length() == t.length();
    }

    public static item peek() {
        return a[N-1];
    }
    
}
