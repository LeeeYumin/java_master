package com.yedam.book.serviceImpl;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;

public class BookServiceImpl {
	SqlSession session = DataSource.getInstance().openSession(true);
}
