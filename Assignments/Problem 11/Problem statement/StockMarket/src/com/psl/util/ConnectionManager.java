package com.psl.util;

import java.sql.Connection;

public interface ConnectionManager {

	void closeConnection();
	Connection getConnection();
}
