package bunningsWishList.utilities;

public class RandomNumberGenerator {

	public int getRandomInteger()
	{
		int x = (int) ((Math.random()*((4-1)+1))+1);
		return x;
	}

}
