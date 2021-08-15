package week1;
import java.lang.StringBuilder;
import java.util.Scanner;

public class Main_신규아이디추천_방수영 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(solution(s));
	}

	public static String solution(String new_id) {
		StringBuilder sb = new StringBuilder();
        String answer = "";
        //step 1
        new_id = new_id.toLowerCase();
        
        //step 2
        String str = "~!@#$%^&*()=+[{]}:?,<>/";
        for(int i=0; i<str.length(); i++) {
        	new_id =new_id.replace(Character.toString(str.charAt(i)),"");
        }
        //참고 new_id.replaceAll("^a-zA-Z0-9,_","": return "c_cd,dd,abcABC" 
        //->  숫자와 알파벳, 콤마(,), 언더바(_) 이외의 문자 모두 제거
        //step 3
        while(new_id != new_id.replace("..",".")) {
        	new_id = new_id.replace("..",".");
        }
       
        //step 4
        if(new_id.length()>1){
            if(new_id.charAt(0)=='.')
                new_id = new_id.substring(1,new_id.length());
            if(new_id.charAt(new_id.length()-1)=='.')
                new_id = new_id.substring(0,new_id.length()-1);
        }else if(new_id.length()==1){
            if(new_id.charAt(0)=='.')
                new_id="";
        }
      
        //step 5
         if(new_id.length()<1) new_id ="a";
        //step 6
        if(new_id.length()>15) {
        	new_id = new_id.substring(0,15);
        	if(new_id.charAt(new_id.length()-1)=='.') new_id = new_id.substring(0,new_id.length()-1);
        }
        //step 7
        if(new_id.length()<=2) {
        	sb.append(new_id);
        	while(sb.length()<=2) {
        		sb.append(new_id.charAt(new_id.length()-1));
        	}
        }
        if(sb.length()!=0) new_id=sb.toString();
        System.out.println(new_id);
        
        return new_id;
    
    }
}
