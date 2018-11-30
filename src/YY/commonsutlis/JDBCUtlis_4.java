package YY.commonsutlis;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * ���Threadlocal
 * @author enter
 *
 */
public class JDBCUtlis_4 {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	private static ThreadLocal<Connection> t1 = new ThreadLocal<>();

	public static Connection getConnection() {
		Connection con=t1.get();
		try {
			if (con != null)
				return con;
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	public static ComboPooledDataSource getdataSource() {
		return dataSource;
	}

	public static void beginTransAction() {
		Connection con=t1.get();
		if (con != null)
			throw new RuntimeException("���Ѿ�����������");
		try {
			con = getConnection();
			con.setAutoCommit(false);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		t1.set(con);
	}

	public static void commitTransAction() {
		Connection con=t1.get();
		if (con == null)
			throw new RuntimeException("��û�п�������");
		try {
			con.commit();
			con.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
		t1.remove();
	}

	public static void rollbackTransAction() {
		Connection con=t1.get();
		if (con == null)
			throw new RuntimeException("��û�п�������");
		try {
			con.rollback();
			con.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
		t1.remove();
	}

	public static void releaseConnection(Connection connection) {
		Connection con=t1.get();
		try {
			// ���CON==NULL����϶�û�п���
			if (con == null)
				connection.close();
			// !=����������
			if (con != connection)
				connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}

	@Test
	public void fun() {
		System.out.println(getConnection());
	}
}
