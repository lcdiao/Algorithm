package 算法;

public class 正则 {

	public static void main(String[] args) {
		String s="12345...12345..12345.12345";
//		String[] a = s.split("\\.{3}");	//重复3次
//		String[] a = s.split("\\.{2,3}");		//重复2-3次，默认贪婪模式
//		String[] a = s.split("\\.{2,3}?");	//非贪婪模式
		String[] a = s.split("\\.{2,}");	//至少重复2次
		for(String b:a){
			System.out.println(b);
		}
		
	}

}
