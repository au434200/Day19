package YY.commonsutlis;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

public class TXQueryRunner extends QueryRunner {

	@Override
	public int[] batch(String sql, Object[][] params) throws SQLException {
		Connection con = JDBCUtlis_4.getConnection();
		int[] result = super.batch(con, sql, params);
		JDBCUtlis_4.releaseConnection(con);
		return result;
	}

	@Override
	public int execute(String sql, Object... params) throws SQLException {
		Connection con = JDBCUtlis_4.getConnection();
		int result = super.execute(con, sql, params);
		JDBCUtlis_4.releaseConnection(con);
		return result;
	}

	@Override
	public <T> List<T> execute(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
		Connection con = JDBCUtlis_4.getConnection();
		List<T> result = super.execute(con, sql, rsh, params);
		JDBCUtlis_4.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T insert(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
		Connection con = JDBCUtlis_4.getConnection();
		T result = super.insert(con, sql, rsh, params);
		JDBCUtlis_4.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T insert(String sql, ResultSetHandler<T> rsh) throws SQLException {
		Connection con = JDBCUtlis_4.getConnection();
		T result = super.insert(con, sql, rsh);
		JDBCUtlis_4.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T insertBatch(String sql, ResultSetHandler<T> rsh, Object[][] params) throws SQLException {
		Connection con = JDBCUtlis_4.getConnection();
		T result = super.insertBatch(con, sql, rsh, params);
		JDBCUtlis_4.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T query(String sql, Object param, ResultSetHandler<T> rsh) throws SQLException {
		Connection con = JDBCUtlis_4.getConnection();
		T result = super.query(con, sql, rsh, param);
		JDBCUtlis_4.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T query(String sql, Object[] params, ResultSetHandler<T> rsh) throws SQLException {
		Connection con = JDBCUtlis_4.getConnection();
		T result = super.query(con, sql, rsh, params);
		JDBCUtlis_4.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
		Connection con=JDBCUtlis_4.getConnection();
		T result=super.query(con,sql, rsh,params);
		JDBCUtlis_4.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
		Connection con=JDBCUtlis_4.getConnection();
		T result=super.query(con,sql, rsh);
		JDBCUtlis_4.releaseConnection(con);
		return result;
	}

	@Override
	public int update(String sql, Object... params) throws SQLException {
		Connection con=JDBCUtlis_4.getConnection();
		int result=super.update(con,sql,params);
		JDBCUtlis_4.releaseConnection(con);
		return result;
	}

	@Override
	public int update(String sql, Object param) throws SQLException {
		Connection con=JDBCUtlis_4.getConnection();
		int result=super.update(con,sql,param);
		JDBCUtlis_4.releaseConnection(con);
		return result;
	}

	@Override
	public int update(String sql) throws SQLException {
		Connection con=JDBCUtlis_4.getConnection();
		int result=super.update(con,sql);
		JDBCUtlis_4.releaseConnection(con);
		return result;
	}

}
