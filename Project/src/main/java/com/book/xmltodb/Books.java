package com.book.xmltodb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Books {
    private String bookName;
    private String authorName;
    private String language;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void Database() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "");
            if (connection != null) {
                String insertQuery = "INSERT INTO books (bookName, authorName, language) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                preparedStatement.setString(1, bookName);
                preparedStatement.setString(2, authorName);
                preparedStatement.setString(3, language);

                int rowsAffected = preparedStatement.executeUpdate();

            }
        } catch (SQLException e) {
            System.err.println("Can not connect to database!");
            e.printStackTrace();
        }
    }

    public static void Database(List<Books> booksList) {
        for (Books book : booksList) {
            book.Database();
        }
    }
}
