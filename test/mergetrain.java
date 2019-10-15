package test;

public class mergetrain {
	public static void main(String args[]) {
		int[] x = new int[] {12, 35, 87, 26, 9, 28, 7};
		int n=1000;
		int[] test = new int[n];
		System.out.println("before");
		for(int i=0;i<n;i++) {
			double tp = Math.random();
			test[i]=(int) (tp*1000);
			System.out.print(test[i]+" ");
		}
		System.out.println();
		Merge(test);
		System.out.println("after");
		for(int i=0;i<n;i++) {
			System.out.print(test[i]+" ");
		}
		System.out.println();
	}
	public static void Merge(int[] x) {
		sort(x, 0, x.length-1);
	}
	static void sort(int[] x, int s, int e) {
		if(s<e) {
			int mid = (s+e)/2;
			sort(x, s, mid);
			sort(x, mid+1, e);
			merge(x, s, mid, e);
		}
	}
	static void merge(int[] x, int s, int mid, int e) {
		int[] temp = new int[e-s+1];
//		System.out.println("before merge");
//		for(int i=s;i<=e;i++) {
//			System.out.print(x[i]+" ");
//		}
//		System.out.println();
		int ss=0, ee=0;
		for(int i=0;i<e-s+1;i++) {
			if(s+ss>mid) {
				temp[i]=x[mid+1+ee];
				ee++;
			}
			else if(mid+1+ee>e) {
				temp[i]=x[s+ss];
				ss++;
			}
			else if(x[s+ss]<=x[mid+1+ee]) {
				temp[i]=x[s+ss];
				ss++;
			}
			else {
				temp[i]=x[mid+1+ee];
				ee++;
			}
		}
//		System.out.println("after merge");
		for(int i=0;i<e-s+1;i++) {
			x[s+i]=temp[i];
//			System.out.print(temp[i]+" ");
		}
//		System.out.println();
	}
}
