import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import java.awt.image.*;

public class stego
{

/**
 * A constant to hold the number of bits per byte
 */
private final int byteLength=8;

/**
 * A constant to hold the number of bits used to store the size of the file extracted
 */
protected final int sizeBitsLength=32;
/**
 * A constant to hold the number of bits used to store the extension of the file extracted
 */
protected final int extBitsLength=64;


public static void main(String[] args)
	{
		// Provide a string and image to test hide string function
		hideString("Always bet on the Duke", "Test-image.bmp");
	}

 /**
Default constructor to create a steg object, doesn't do anything - so we actually don't need to declare it explicitly. Oh well. 
*/

public void Steg()
{

}

/**
A method for hiding a string in an uncompressed image file such as a .bmp or .png
You can assume a .bmp will be used
@param cover_filename - the filename of the cover image as a string 
@param payload - the string which should be hidden in the cover image.
@return a string which either contains 'Fail' or the name of the stego image which has been 
written out as a result of the successful hiding operation. 
You can assume that the images are all in the same directory as the java files
*/
//TODO you must write this method
public static String hideString(String payload, String cover_filename)
{
	// Open image as a file and initialise the bufferedimage variable
	File imgpath;
	BufferedImage coverim = null;
	imgpath = new File(cover_filename);
	
	// Read through head of image, assuming 54 byte image head
	for(int i = 0; i < 54; i++){
		try {
			coverim = ImageIO.read(imgpath);
		} catch (IOException e){
			System.out.println("Fail: Failed to read cover image on iteration: " + i);
		}
		WritableRaster raster = coverim.getRaster();
		DataBufferByte coverbytes = (DataBufferByte) raster.getDataBuffer();
		System.out.println(coverbytes.getData());
	}

	// Transform payload into a byte array
	byte[] bytes = payload.getBytes();
	//byte imgbyte = (byte)cover_image;
	//System.out.println(imgbyte);
	System.out.println(bytes);
	
	return null;
}
//TODO you must write this method
/**
The extractString method should extract a string which has been hidden in the stegoimage
@param the name of the stego image 
@return a string which contains either the message which has been extracted or 'Fail' which indicates the extraction
was unsuccessful
*/
public String extractString(String stego_image)
{
return null;
}

//TODO you must write this method
/**
The hideFile method hides any file (so long as there's enough capacity in the image file) in a cover image

@param file_payload - the name of the file to be hidden, you can assume it is in the same directory as the program
@param cover_image - the name of the cover image file, you can assume it is in the same directory as the program
@return String - either 'Fail' to indicate an error in the hiding process, or the name of the stego image written out as a
result of the successful hiding process
*/
public String hideFile(String file_payload, String cover_image)
{
	return null;
}

//TODO you must write this method
/**
The extractFile method hides any file (so long as there's enough capacity in the image file) in a cover image

@param stego_image - the name of the file to be hidden, you can assume it is in the same directory as the program
@return String - either 'Fail' to indicate an error in the extraction process, or the name of the file written out as a
result of the successful extraction process
*/
public String extractFile(String stego_image)
{

	return null;
}

//TODO you must write this method
/**
 * This method swaps the least significant bit with a bit from the filereader
 * @param bitToHide - the bit which is to replace the lsb of the byte of the image
 * @param byt - the current byte
 * @return the altered byte
 */
public int swapLsb(int bitToHide,int byt)
{		
	return 0;
}




}
