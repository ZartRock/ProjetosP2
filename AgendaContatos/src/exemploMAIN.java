import java.util.Scanner;


public class exemploMAIN {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			int num = sc.nextInt();
			try {
				exemplo ex = new exemplo(num);
			} catch (IndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		
	}
}
