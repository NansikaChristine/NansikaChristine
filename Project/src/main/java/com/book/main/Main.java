package com.book.main;

import com.book.xmltodb.Books;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		try {
			ObjectMapper mapper = new XmlMapper();
			FileInputStream inputStream = new FileInputStream(new File("D:\\GJANAM\\Project\\Project\\src\\main\\java\\com\\book\\xmlfile\\Book.xml"));
			TypeReference<List<Books>> typeReference = new TypeReference<List<Books>>() {};
			List<Books> booksList = mapper.readValue(inputStream, typeReference);
			inputStream.close();

			for (Books book : booksList) {
				System.out.println(book.getBookName());
				book.Database();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
