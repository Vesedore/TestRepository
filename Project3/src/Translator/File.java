package Translator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class File implements Serializable {
	private static final long serialVersionUID = 1L;

	public Object openList(String file_name){
		Object retObject = null;
		try {
			FileInputStream fis = new FileInputStream(file_name + ".map");
			ObjectInputStream in = new ObjectInputStream(fis);
			retObject = in.readObject();
			fis.close();
			in.close();
		} catch (FileNotFoundException e) {
			//System.out.println("Файл не найден");
			Translator tr = new Translator();
			tr.ifFileNotFound();
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Ошибка ввода/вывода");
			System.exit(2);
		} catch (ClassNotFoundException e) {
			System.out.println("Класс не найден");
			System.exit(3);
		}
		return retObject;
	}
	
	public void saveList(String file_name, Object obj){
		try {
			FileOutputStream fos = new FileOutputStream(file_name + ".map");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(obj);
			fos.close();
			out.close();
		} catch (FileNotFoundException e) {
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Ошибка ввода/вывода");
			System.exit(2);
		}
	}
}
