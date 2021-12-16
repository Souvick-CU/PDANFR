import java.io.*;
import java.lang.management.ManagementFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Iterator;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.SystemOutLogger;

class CompressionDecompression {
	//FileWriter fw=null;
	public static void comdecom(String inputString)
	{
		String inString=null;
		 try {
				 FileWriter fw=new FileWriter("output.txt",true);
				 
			     byte[] input = inputString.getBytes("UTF-8");
			     
	
			     // Compress the bytes
			     byte[] output = new byte[100];
			     Deflater compresser = new Deflater();
			     compresser.setInput(input);
			     compresser.finish();
			     byte[] compressedResult = input;
			     int compressedDataLength = compresser.deflate(output);
			     
			     inString = new String(output, 0, compressedDataLength, "UTF-8");
			    
			     
			     byte[]inputStringbyte=inString.getBytes();
			     
			     compresser.end();
			    
			     
			     int compressionlength = compressedDataLength;
			     int actuallength = input.length;
			     int diff=actuallength-compressionlength;
			     double compressionPercentage = (double)diff/actuallength;
			     compressionPercentage = compressionPercentage * 100;
			     
			     fw.write(""+compressionPercentage);
			     fw.write("\n");
			     fw.close();
			     // Decompress the bytes
			     Inflater decompresser = new Inflater();
			     decompresser.setInput(output, 0, compressedDataLength);
			     byte[] result = new byte[100];
			     int resultLength = decompresser.inflate(result);
			     decompresser.end();
	
			     // Decode the bytes into a String
			     String outputString = new String(result, 0, resultLength, "UTF-8");
			     
			    
			 } catch(java.io.UnsupportedEncodingException ex) {
			     // handle
			 } catch (java.util.zip.DataFormatException ex) {
	//		     // handle
		 }
		 catch(Exception e)
		 {
			 
		 }
		 
		 
	}
}

