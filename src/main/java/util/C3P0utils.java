package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;

public class C3P0utils {
    public static DataSource dataSource=new ComboPooledDataSource();
    public static QueryRunner qr=new QueryRunner(dataSource);
}
