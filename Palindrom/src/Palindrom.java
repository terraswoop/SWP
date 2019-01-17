

public class Palindrom {
	public static boolean isPalindrom(String s) {
		String s1=s.substring(0, s.length()/2);
		String s2=s.substring(s.length()/2,s.length());
		String s3="";
		for(int i=0;i<s2.length();i++) {
			s3+=s2.charAt(s2.length()-1-i);
		}
		if(s1.equals(s3)) {
			return true;
		}
		else return false;
	}
	public static boolean isPalindromRek(String s) {
		if(s.length()==0) {
			return true;
		}
		if(s.charAt(0)==s.charAt(s.length()-1)){
			return isPalindromRek(s.substring(1, s.length()-1));
		}
		else return false;
	}
	public static boolean isPalindromRek2(String s, int i) {
		if(i==(s.length()-1)/2) {
			return true;
		}
		if(s.charAt(i)==s.charAt(s.length()-1-i)){
			return isPalindromRek2(s,i+1);
		}
		else return false;
	}
	public static void main(String[] args) {
		System.out.println(isPalindromRek2("pallap",0));

	}

}
