package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	private static List<Integer> okunanBytesArray = new ArrayList<Integer>();

	public static void main(String[] args) {
		
		orijinalDosyayiOku("java.jpg.jpg");
		
		yeniDosyayaYaz("javakopya3.jpg");
	}
	
	public static void orijinalDosyayiOku(String DosyaAdi) {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(DosyaAdi);
			int okunan;
			while((okunan = fileInputStream.read()) != -1) {
				okunanBytesArray.add(okunan);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fileInputStream.close();
			} catch (IOException e) {
				System.out.println("Dosya I/O hatası oluştu!");
				e.printStackTrace();
			}
		}
		
	}
	
	public static void yeniDosyayaYaz(String DosyaAdi) {
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(DosyaAdi);
			for(int i=0;i<okunanBytesArray.size();i++) {
				fileOutputStream.write(okunanBytesArray.get(i));
			}
		} catch (Exception e) {
			System.out.println("File operations exception.");
			e.printStackTrace();
		}finally {
			try {
				fileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
