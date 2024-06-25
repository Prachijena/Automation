package GenericUtilities;

import java.util.Random;

public class JavaUtility {
public int getRandonNum(){
	Random ran=new Random();
	int r=ran.nextInt(100);
	return r;
}
}
