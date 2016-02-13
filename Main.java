
public class Main extends stego{

    public static void main(String[] args){
        stego mySteg = new stego();
        //System.out.println(mySteg.hideString("This", "Test-image.bmp"));
	System.out.println(mySteg.extractString(mySteg.hideString("This is amazing, why didn't I see this until now!!!", "Test-image.bmp")));

    }
}
