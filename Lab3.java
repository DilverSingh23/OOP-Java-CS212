public class Lab3 {
   public static void main(String[] args) {
	float fahrenheit = 98.6f;
	float centigrade = (5.0f/9.0f)*(fahrenheit - 32.0f);
        System.out.println("98.6 fahrenheit in centigrade is " + centigrade);
	for (int i=0; i<=8; i++) {
	    fahrenheit = 5.0f * i;
	    centigrade = (5.0f/9.0f)*(fahrenheit - 32.0f);
	    System.out.println(fahrenheit + " fahrenheit in centigrade is " + centigrade); 
	}
	int j = 0;
	while (j <= 8) {
	    fahrenheit = 5.0f * j;
            centigrade = (5.0f/9.0f)*(fahrenheit - 32.0f);
	    System.out.println(fahrenheit + " fahrenheit in centigrade is " + centigrade);
	    j++;
        }
   }
}
