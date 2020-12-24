import java.util.Scanner;

public class RotOranges {
		
		static int R = 3;
		static int C = 5;

		// Check if i, j is under the array 
		// limits of row and column
		static boolean issafe(int i, int j)
		{
			if (i >= 0 && i < R && 
				j >= 0 && j < C)
				return true;
				
			return false;
		}

		static void rotOranges(int v[][])
		{
			boolean changed = false;
			int no = 2;
			int freshCount=0;
			int rottonCount=0;
			while (true) 
			{
				for(int i = 0; i < R; i++) 
				{
					for(int j = 0; j < C; j++)
					{
						
						// Rot all other oranges present at
						// (i+1, j), (i, j-1), (i, j+1), (i-1, j)
						if (v[i][j] == no) 
						{
							if (issafe(i + 1, j) && 
									v[i + 1][j] == 1)
							{
								v[i + 1][j] = v[i][j] + 1;
								changed = true;
							}
							if (issafe(i, j + 1) && 
									v[i][j + 1] == 1) 
							{
								v[i][j + 1] = v[i][j] + 1;
								changed = true;
							}
							if (issafe(i - 1, j) &&
									v[i - 1][j] == 1)
							{
								v[i - 1][j] = v[i][j] + 1;
								changed = true;
							}
							if (issafe(i, j - 1) && 
									v[i][j - 1] == 1)
							{
								v[i][j - 1] = v[i][j] + 1;
								changed = true;
							}
						}
					}
				}

				// If no rotten orange found it means all
				// oranges rottened now
				if (!changed)
					break;
					
				changed = false;
				no++;
			}

			for(int i = 0; i < R; i++)
			{
				for(int j = 0; j < C; j++) 
				{
					if(v[i][j]==1)
					{
						freshCount++;
					}
					if(v[i][j]>1){
						rottonCount++;
					}
				}
			}
			
			// Because initial value for a rotten
			// orange was 2
			System.out.println("time frame :" + (no - 2)); 
			System.out.println("fresh oranges :"+freshCount);
			System.out.println("Rotten oranges :"+rottonCount);
		}

		// Driver Code
		public static void main(String[] args)
		{
			Scanner sc=new Scanner(System.in);
			int row=sc.nextInt();
			int col=sc.nextInt();
			int [][]arr = new int[row][col];
			for(int i=0;i<row;i++) {
				for(int j=0;j<col;j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
			rotOranges(arr);
		}

	}