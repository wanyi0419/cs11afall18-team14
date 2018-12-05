import java.util.*;


public class BAttelShip2
{
	Scanner console = new Scanner(System.in);
	static int x1=0;
	static int y1=0;
	static int x2=0;
	static int y2=0;
    static BattleShip1 user = new BattleShip1(x1,y1);
    static BattleShip1 comp = new BattleShip1(x2,y2);
	static int Hit1x=0;
	static int Hit1y=0;
	static int Hit2x=0;
	static int Hit2y=0;
	static boolean a=true;
	static int[][] map = new int[5][5];
	static int count=1;
	static int maxHit=0;
	static int maxHitc=0;


	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		System.out.print("In this game you will first set up your Battleship. Then if you hit the enemy's ship, you win, if the enemy hit your ship, you lose.");
		System.out.println();
		System.out.print("Get Ready!!!!");
		System.out.println("");
		StartGame();
	}


	public static void StartGame() throws Exception
	{
		System.out.print("Now set up your Battleship.");
	    System.out.println();
		Scanner console = new Scanner(System.in);
	    System.out.print("Enter the position x:");
	    int x1 = console.nextInt()-1;
	    System.out.print("Enter the position y:");
	    int y1 = console.nextInt()-1;
	    user.setPosx(x1);
	    user.setPosy(y1);
	    x1 = user.getPosx();
		y1 = user.getPosy();
		map[x1][y1]=1;
		int x2 = (int) (Math.random()*5);
	    int y2 = (int) (Math.random()*5);
	 	comp.setPosx(x2);
		comp.setPosy(y2);
		x2 = comp.getPosx();
		y2 = comp.getPosy();

		for(int i=0;i<map.length;i++)
		{
			for(int j=0; j<map[0].length; j++)
			{
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

		Hit();
	}


	public static void Hit () throws Exception
	{
		System.out.print("Round"+" "+count);
		System.out.println();
		Scanner console = new Scanner(System.in);
		System.out.print("Your Turn Now!!!! Please choose where to hit. (enter x position and y position)");
		Hit1x = console.nextInt()-1	;
	    Hit1y = console.nextInt()-1;
			System.out.println("Hit1x: " + Hit1x + " Hit1y: " + Hit1y);
			if((Hit1x > 4 || Hit1x < 0) || (Hit1y > 4 || Hit1y < 0)) {
        System.out.println("That entry is out of bounds. You lose a turn");
      }
	    Hit2x = (int) (Math.random()*5);
	    Hit2y = (int) (Math.random()*5);

	    x1 = user.getPosx();
		y1 = user.getPosy();
	    x2 = comp.getPosx();
		y2 = comp.getPosy();

	    if (Hit1x == x2 && Hit1y == y2)
		{
			System.out.println("You win");
			end();
		}
		if (Hit2x == x1 && Hit2y == y1)
		{
			System.out.println("The enemy has attacked.");
			System.out.println("You lose");
			end();
		}
		else
		{
			count++;
			System.out.print("The enemy has attacked");
			System.out.println();
			if (count>=3 && count%3==0)
			{
				MaxHit();
			}
			if (count>=15)
			{
				tie();
			}
			else
			{
				move();
			}
		}
	}

	public static void MaxHit() throws Exception
	{
		x2=comp.getPosx();
		y2=comp.getPosy();
		x1=user.getPosx();
		y1=user.getPosy();
		Scanner console = new Scanner(System.in);
		System.out.print("Here comes the Maximum hit. Now please choose a cross line to eliminate!!!! (enter the cross line you want to hit)");
		maxHit =  console.nextInt()-1;
		maxHitc =(int) (Math.random()*5);
		if (maxHit == x2 || maxHit == y2)
		{
			System.out.println("You win");
			end();
		}
		if (maxHit == x1 || maxHitc == y1)
		{
			System.out.println("You lose");
			end();
		}
		else
		{
			move();
		}
	}


	public static void move() throws Exception
	{
		Scanner console = new Scanner(System.in);
		System.out.println("Your turn to move, Please enter a new position (enter up, down, left, right).");
		String move1 = console.next();
		System.out.println("enemy has moved his ship move.");
		switch (move1)
		{
		case "up":
			x1--;
			if(x1 < 0) {
				x1 = 4;
			}
			user.setPosx(x1);
			break;
		case "down":
			x1++;
			if(x1>4) {
				x1 = 0;
			}
			user.setPosx(x1);
			break;

		case "left":
			y1--;
			if(y1 < 0) {
				y1 = 4;
			}
			user.setPosy(y1);
			break;

		case "right":
			y1++;
			if(y1 > 4) {
				y1=0;
			}
			user.setPosy(y1);
			break;
		}
		int move2 = (int) (Math.random()*5);
		switch (move2)
		{
		case 0:
			y2--;
			if(y2 < 0) {
				y2 = 4;
			}
			comp.setPosy(y2);
			break;

		case 1:
			y2++;
			if(y2 > 4) {
				y2 = 0;
			}
			comp.setPosy(y2);
			break;
		case 2:
			x2--;
			if(x2 < 0) {
				x2 = 4;
			}
			comp.setPosx(x2);
			break;
		case 3:
			x2++;
			if(x2 > 4) {
				x2 = 0;
			}
			comp.setPosx(x2);
			break;
		}
		x1=user.getPosx();
		y1=user.getPosy();
		x2=comp.getPosx();
		y2=comp.getPosy();
		int [][] map2 = new int [5][5];
		map2[x1][y1]=1;
	    for (int i = 0; i < map2.length; i++)
		{
			for (int j = 0; j < map2[0].length; j++)
			{
				System.out.print(map2[i][j]);
			}
			System.out.println();
		}
	    Hit();
	}


	public static void tie() throws Exception
	{
		System.out.print("TIE!!!!!!!!");
		end();
	}


	public static void end() throws Exception
	{
		System.out.println("The Game has ended. Do you want to play again?");
		Scanner console = new Scanner(System.in);
		System.out.println("please enter yes or no");
		String judge = console.next();
		if (judge.equals("yes"))
		{
			count=0;
			StartGame();
		}
		else
		{
			System.out.println("GoodBye");
			throw new Exception("test exception");
		}
	}

}
