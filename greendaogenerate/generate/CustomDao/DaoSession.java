package CustomDao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.example.administrator.mobilepacsviewer.app.IPAddressEntity;

import CustomDao.IPAddressEntityDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig iPAddressEntityDaoConfig;

    private final IPAddressEntityDao iPAddressEntityDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        iPAddressEntityDaoConfig = daoConfigMap.get(IPAddressEntityDao.class).clone();
        iPAddressEntityDaoConfig.initIdentityScope(type);

        iPAddressEntityDao = new IPAddressEntityDao(iPAddressEntityDaoConfig, this);

        registerDao(IPAddressEntity.class, iPAddressEntityDao);
    }
    
    public void clear() {
        iPAddressEntityDaoConfig.getIdentityScope().clear();
    }

    public IPAddressEntityDao getIPAddressEntityDao() {
        return iPAddressEntityDao;
    }

}
