package com.bookapp.util;

public class AllQueries {
	public static final String SELECTQUERY="select * from book";
	public static final String AUTHORQUERY="select * from book where author=?";
	public static final String CAQUERY="select * from book where category=?";
	public static final String PRICEQUERY="select * from book where price=?";
	public static final String INSERTQUERY="insert into book values(?,?,?,?,?)";
	public static final String UPDATEQUERY="update book set price=? where bookid=?";
	public static final String DELETEQUERY="delete from book where bookid=?";
	public static final String SELECTONEQUERY="select * from book where bookid=?";
}
