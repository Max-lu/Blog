package cn.maxlu.db;

import com.mchange.v2.c3p0.AbstractConnectionCustomizer;

import java.sql.Connection;

/**
 * Created by max.lu on 2015/10/20.
 */
public class IsolationLevelReadUncommittedConnectionCustomizer extends AbstractConnectionCustomizer {

    @Override
    public void onAcquire(Connection c, String parentDataSourceIdentityToken) throws Exception {
        super.onAcquire(c, parentDataSourceIdentityToken);
        c.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
    }
}