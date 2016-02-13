import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


/*
* TODO: Remove all static definitions & main
* */

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
	//setup file object for getting the size of it
	File cf = new File(cover_filename);
	long cf_lsb_can_hide = cf.length() - 86;
	byte[] payload_bytes = payload.getBytes();
	int bytes_to_hide = payload_bytes.length;
	int bits_to_hide = bytes_to_hide*8;
	int curr_byte2hide = 0;
	int curr_bit2hide = 0;
	boolean message_hidden = false;
	//if trying to hide more bits than available lsb's, stop
	if (bits_to_hide > cf_lsb_can_hide){
		return "Fail: " + payload + " was too big for " + cover_filename;
	}

	// Load the cover image on an input stream.
	InputStream coverim = null;
	int cover_image;
	try {
		coverim = new FileInputStream(cover_filename);
	} catch (IOException e){
		return "Fail: couldn't load cover image.";
	}
	//
	FileOutputStream coverim_mod = null;
	File file_mod;
	try {
		file_mod = new File("modified.bmp");
		coverim_mod = new FileOutputStream(file_mod);

		if (!file_mod.exists()){
			file_mod.createNewFile();
		}

	} catch (IOException e){
		return "Fail: some issue creating output stream.";
	}

	// Determine the size of the payload to be hidden
	String payload_size = String.format("%032d", Integer.parseInt(Integer.toBinaryString(bytes_to_hide)));
	int curr_char_pls = 0;
	for(int i = 0; i < cf.length(); i++){
		try {
			cover_image = coverim.read();
			
			if (i < 54){
				coverim_mod.write(cover_image);

			}
			else if (i >= 54 && i < 86){
				coverim_mod.write(swapLsb(Character.getNumericValue(payload_size.charAt(curr_char_pls)),cover_image));
				curr_char_pls++;
			}
			else {
				if(curr_byte2hide == bytes_to_hide){
					message_hidden = true;
				}
				if (message_hidden){
					coverim_mod.write(cover_image);
				} else {
					int lsb;

					int curr_pBitVal = bit_shifter(payload_bytes[curr_byte2hide],curr_bit2hide%8);
					coverim_mod.write(swapLsb(curr_pBitVal, cover_image));
					curr_bit2hide = curr_bit2hide + 1;
					if (curr_bit2hide%8 == 0){
						curr_byte2hide += 1;
					}
				}
			}
		} catch (IOException e){
			return "Fail: unable to move past header of image file.";
		}
	}
	try{
		coverim_mod.flush();
		coverim_mod.close();
		coverim.close();
	} catch(IOException e){
		return "Fail: couldn't close off streams.";
	}
	
	return null;
}
//TODO you must write this method
/**
The extractString method should extract a string which has been hidden in the stegoimage
@param the name of the stego image 
@return a string which contains either the message which has been extracted or 'Fail' which indicates the extraction
was unsuccessful
*/
public static String extractString(String stego_image)
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
public static String hideFile(String file_payload, String cover_image)
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
public static String extractFile(String stego_image)
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
public static int swapLsb(int bitToHide,int byt)
{
	return byt - byt%2 + bitToHide;
}

/*
* determining if current bit  to hide is 1 or 0
* */
public static int bit_shifter(int byte_x,int bit_idx)
{
	return ((byte_x) >> bit_idx)%2;
}




}
