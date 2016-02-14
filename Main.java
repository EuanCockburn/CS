
public class Main extends stego{

    public static void main(String[] args){
        FileReader fr = new FileReader("Test2-image.bmp");

        stego mySteg = new stego();
        //System.out.println(mySteg.hideString("This", "Test-image.bmp"));
	System.out.println(mySteg.extractString(mySteg.hideString("This is amazing, why didn't I see this until now!!!", "Test-image.bmp")));

    }
}
