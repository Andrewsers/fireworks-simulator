package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class Util {
	
	private static MessageDigest CRYPTER = null;
	private static InputStreamReader INPUT_READER = null;
	private static BufferedReader READER = null;
	
	/**
	 * Retorna um objeto preparado para ler Strings digitadas no
	 * teclado
	 * @return BufferedReader leitor de teclado
	 */
	private static BufferedReader getKeyboardReader()
	{
		if(Util.READER == null) {
			Util.READER = new BufferedReader(Util.getInputReader());
		}
		return Util.READER;		
	}
	
	/**
	 * @return Retorna um InputStreamReader preparado com a entrada de teclado
	 */
	private static InputStreamReader getInputReader()
	{
		if(Util.INPUT_READER == null)
		{
			Util.INPUT_READER = new InputStreamReader(System.in);
		}
		return Util.INPUT_READER;

	}
	
	
	/**
	 * Le uma string do teclado e a retorna
	 * @return string lida do teclado do usuário
	 * @throws IOException 
	 */
	public static String readLine() throws IOException
	{
		System.in.skip(System.in.available());
		return Util.getKeyboardReader().readLine();
	}
	
	
	
	/**
	 * Criptografa string passada por parametro e retorna valor criptografado
	 * @param strToCrypt string que devera ser criptografada
	 * @return string criptografada
	 */
	public static String crypt(String strToCrypt){
		if(Util.CRYPTER == null) {
			try {
				Util.CRYPTER = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		Util.CRYPTER.update(strToCrypt.getBytes(),0,strToCrypt.length());
		strToCrypt = (new BigInteger(1,Util.CRYPTER.digest())).toString();
		return strToCrypt;
	}
	
	/**
	 * Codifica a string html para ser exibida corretamente indepetende da codificação
	 * @param s string com caracteres especiais
	 * @return string com caracters especiais convertidos
	 */
	public static String encodeHtml(String s)
	{
	    StringBuffer out = new StringBuffer();
	    for(int i=0; i<s.length(); i++)
	    {
	        char c = s.charAt(i);
	        if(c > 127 || c=='"' || c=='<' || c=='>')
	        {
	           out.append("&#"+(int)c+";");
	        }
	        else
	        {
	            out.append(c);
	        }
	    }
	    return out.toString();
	}
	
	/**
	 * Retorna true se a string contiver um numero inteiro
	 * @param input string a ser testada
	 * @return true se a string contiver um numero
	 */
	public static boolean isInt(String input) {
		try {  
          Integer.parseInt(input);  
          return true;  
       }  catch( Exception e)  {  
          return false;  
       }
	}
	
	/**
	 * Calcula distancia euclidiana entre os dois vetores numericos
	 * @param arr1 primeiro vetor numerico
	 * @param arr2 segundo vetor numerico
	 * @return distancia euclidiana entre estes dois pontos em RN onde N e a dimensao dos vetores
	 */
	public static double distanciaEuclidiana(double[] arr1, double[] arr2) {
		double distancia = 0;
		int lCont;
		if(arr1.length == arr2.length) {
			for(lCont=0;lCont < arr1.length; lCont++) {
				distancia += Math.pow(arr2[lCont]-arr1[lCont],2);
			}
			distancia = Math.sqrt(distancia);
		} else {
			throw new ArrayIndexOutOfBoundsException("Vetores incompativeis para calculo de distancia");
		}
		
		return distancia;
	}
	
	
	/**
	 * Returns the Euclidian Distance between two points
	 * @param x1 
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return the distance between points
	 */
	public static double distanciaEuclidiana(double x1, double y1, double x2, double y2) {
		double[] arr1 = new double[2], arr2 = new double[2];
		arr1[0] = x1;
		arr1[1] = y1;
		arr2[0] = x2;
		arr2[1] = y2;
		return Util.distanciaEuclidiana(arr1, arr2);
	}
}
