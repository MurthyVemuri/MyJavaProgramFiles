import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PerfectSkyline {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int flag = 2;
		int H[] = new int[n];
		
		for(int H_i=0; H_i < n; H_i++){
			H[H_i] = in.nextInt();
		}

		for(int j = 0; j < H.length; j++) {
			if(H[j] == H[H.length - 1 - j] && H[j] < H[j/2]) {
				flag = 1;
			} else {
				flag =0;	
			}
		}

		if(flag == 1) {
			System.out.print("Perfect");
		}else {
			System.out.print("Not perfect");
		}
	}
}
