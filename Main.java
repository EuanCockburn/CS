
public class Main extends stego{

    public static void main(String[] args){
        /*System.out.println(Integer.parseInt("00011010", 2));
        System.out.println(Integer.parseInt("00001011", 2));*/
        //FileReader fr = new FileReader("Test2-image.bmp");

        stego mySteg = new stego();
        //System.out.println(mySteg.hideString("This", "Test-image.bmp"));
        String out_string = mySteg.hideFile("testpdf.pdf","Test-image.bmp");
        System.out.println("Created : " + out_string);
        System.out.println(mySteg.extractFile(out_string));
        /*String out_string = mySteg.hideString("Budgie bird fun foil", "Test-image.bmp");
	    System.out.println("Created : " + out_string);*/
        //System.out.println(mySteg.extractString(out_string));
    }
}
