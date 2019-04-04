import java.util.*;
class NqueenBacktracking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//size of the table
        int x[] = new int[n + 1];//craeting an n tuple array
        for (int i = 1; i <= n; i++) {//assigning zeros to x array
            x[i] = 0;
        }
        Nqueen(1, n, x);//calling Nqueen function with (queen number,size of table,n tuple array)
    }
    public static void Nqueen(int k, int n, int x[]) {
        for (int j = 1; j <= n; j++) {
            if (Place(k, j, x)) {//checks wheather queen is placable in that column
                x[k] = j;
                if (k == n) {//base case if k==n prints the output else calls the Nqueen once again
                    for (int i = 1; i <= n; i++) {
                        System.out.print(x[i] + " ");
                    }
                    System.out.println();
                } else {
                    Nqueen(k + 1, n, x);//recursive function call,if queen k placed then k increments to k+1
                }
            }
        }
    }
    
    /*This function checks the bounding cases like no two queens in same diagonal,same row,same column 
    returns true if all cases pass else return false*/
    public static boolean Place(int k, int j, int x[]) {
        for (int i = 1; i <= k - 1; i++) {
            if (x[i] == j || Math.abs(x[i] - j) == Math.abs(k - i)) {
                return false;
            }
        }
        return true;
    }
}
