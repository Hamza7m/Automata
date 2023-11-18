package otomata_odevi;

import java.io.*;
import java.util.*;
public class _20670310030_main {



    public static void main(String[] args)   {
    	_20670310030_Okuma oku = new _20670310030_Okuma();
    	oku.fun();
		System.out.println("Lütfen birinci input’u giriniz");

    	Scanner in = new Scanner(System.in);
    	String str = in.next();
		oku.okumak(str);
		System.out.println("Lütfen ikinci input’u giriniz");

    	String str2 = in.next();
		oku.okumak(str2);
    	
    }}