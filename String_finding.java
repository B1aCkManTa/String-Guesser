package experiments;

public class String_finding {
	static int noLetters;
	static String base="mostafagamedfasuhduwbcuwbubuvbvubvubrv";
	
	public static int level(String inp) {
		int lvl=0;//counter of same char.
		int[] inpFreq=new int[26];
		if(inp.length()==base.length()) {
			for(int i=0;i<inp.length();i++) {
				inpFreq[inp.charAt(i)-'a']++;
			}
			
			for(int i=0;i<base.length();i++) {
				if(inpFreq[base.charAt(i)-'a']>0) {
					lvl++;
					inpFreq[base.charAt(i)-'a']--;
				}
				if(base.charAt(i)==inp.charAt(i)) {
					lvl++;
				}
			}
			return lvl;
		}
		return -1;
	}
	
	public static String RandString() {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<noLetters;i++) {
			sb.append((char)((Math.random()*25)+'a')+"");
		}
		return sb.toString();
	}
	
	public static String Shuffle(String s) {
		StringBuilder sb=new StringBuilder();
		char[]c=s.toCharArray();
		int n=(int)(Math.random()*s.length());
		int y=(int)(Math.random()*s.length());
		char temp=c[n];
		c[n]=c[y];
		c[y]=temp;
		for(int i=0;i<c.length;i++) {
			sb.append(c[i]);			
		}
		return sb.toString();
	}
	
	public static String Change1(String s) {
		StringBuilder sb=new StringBuilder();
		int n=(int)(Math.random()*s.length());
		char[]c=s.toCharArray();
		c[n]=(char)((Math.random()*25)+'a');
		for(int i=0;i<c.length;i++) {
			sb.append(c[i]);
		}
		return sb.toString();
	}
	
	public static String Change2(String s) {
		int n=s.length()/2;
		boolean [] changed=new boolean[s.length()];
		char[]c=s.toCharArray();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<n;i++) {
			int z=(int)(Math.random()*s.length());
			if(!changed[z]) {
				c[z]=((char)((Math.random()*25)+'a'));
				changed[z]=true;
			}
		}
		for(int i=0;i<c.length;i++) {
			sb.append(c[i]);
		}
		return sb.toString();
	}
	
	public static String creat(int n) {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append("a");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		int j=0;
		while(level(creat(j))==-1) {
			j++;
		}
		noLetters=j;
		String s1=RandString();
		String s2=RandString();
		String s3=RandString();
		String s4=RandString();
		int c=0;
		while(true) {
			if(level(s1)==level(base)) {
				System.out.println("Done: "+s1+" "+s2+" "+s3+" "+s4+"--->"+c++);
				break;
			}
			if(level(s2)==level(base)) {
				System.out.println("Done: "+s1+" "+s2+" "+s3+" "+s4+"--->"+c++);
				break;
			}
			if(level(s3)==level(base)) {
				System.out.println("Done: "+s1+" "+s2+" "+s3+" "+s4+"--->"+c++);
				break;
			}
			if(level(s4)==level(base)) {
				System.out.println("Done: "+s1+" "+s2+" "+s3+" "+s4+"--->"+c++);
				break;
			}
			int best=level(s1);
			if(level(s2)>best) {
				s1=s2;
			}
			if(level(s3)>best) {
				s1=s3;
			}
			if(level(s4)>best) {
				s1=s4;
			}
			System.out.println(s1+" "+s2+" "+s3+" "+s4+"--->"+c++);
			s2=Shuffle(s1);
			s3=Change1(s1);
			s4=Change2(s1);
		}
		
	}
}
