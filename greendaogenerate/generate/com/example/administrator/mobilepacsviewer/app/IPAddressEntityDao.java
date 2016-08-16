package com.example.administrator.mobilepacsviewer.app;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.example.administrator.mobilepacsviewer.app.IPAddressEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "IPADDRESS_ENTITY".
*/
public class IPAddressEntityDao extends AbstractDao<IPAddressEntity, Long> {

    public static final String TABLENAME = "IPADDRESS_ENTITY";

    /**
     * Properties of entity IPAddressEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property IPName = new Property(1, String.class, "IPName", false, "IPNAME");
        public final static Property IPLogInAddrLan = new Property(2, String.class, "IPLogInAddrLan", false, "IPLOG_IN_ADDR_LAN");
        public final static Property IPImageAddrLan = new Property(3, String.class, "IPImageAddrLan", false, "IPIMAGE_ADDR_LAN");
        public final static Property IPLogInAddrNet = new Property(4, String.class, "IPLogInAddrNet", false, "IPLOG_IN_ADDR_NET");
        public final static Property IPImageAddrNet = new Property(5, String.class, "IPImageAddrNet", false, "IPIMAGE_ADDR_NET");
        public final static Property OrganizationID = new Property(6, String.class, "OrganizationID", false, "ORGANIZATION_ID");
        public final static Property IsSelLan = new Property(7, Boolean.class, "isSelLan", false, "IS_SEL_LAN");
    };


    public IPAddressEntityDao(DaoConfig config) {
        super(config);
    }
    
    public IPAddressEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"IPADDRESS_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"IPNAME\" TEXT," + // 1: IPName
                "\"IPLOG_IN_ADDR_LAN\" TEXT," + // 2: IPLogInAddrLan
                "\"IPIMAGE_ADDR_LAN\" TEXT," + // 3: IPImageAddrLan
                "\"IPLOG_IN_ADDR_NET\" TEXT," + // 4: IPLogInAddrNet
                "\"IPIMAGE_ADDR_NET\" TEXT," + // 5: IPImageAddrNet
                "\"ORGANIZATION_ID\" TEXT UNIQUE ," + // 6: OrganizationID
                "\"IS_SEL_LAN\" INTEGER);"); // 7: isSelLan
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"IPADDRESS_ENTITY\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, IPAddressEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String IPName = entity.getIPName();
        if (IPName != null) {
            stmt.bindString(2, IPName);
        }
 
        String IPLogInAddrLan = entity.getIPLogInAddrLan();
        if (IPLogInAddrLan != null) {
            stmt.bindString(3, IPLogInAddrLan);
        }
 
        String IPImageAddrLan = entity.getIPImageAddrLan();
        if (IPImageAddrLan != null) {
            stmt.bindString(4, IPImageAddrLan);
        }
 
        String IPLogInAddrNet = entity.getIPLogInAddrNet();
        if (IPLogInAddrNet != null) {
            stmt.bindString(5, IPLogInAddrNet);
        }
 
        String IPImageAddrNet = entity.getIPImageAddrNet();
        if (IPImageAddrNet != null) {
            stmt.bindString(6, IPImageAddrNet);
        }
 
        String OrganizationID = entity.getOrganizationID();
        if (OrganizationID != null) {
            stmt.bindString(7, OrganizationID);
        }
 
        Boolean isSelLan = entity.getIsSelLan();
        if (isSelLan != null) {
            stmt.bindLong(8, isSelLan ? 1L: 0L);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public IPAddressEntity readEntity(Cursor cursor, int offset) {
        IPAddressEntity entity = new IPAddressEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // IPName
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // IPLogInAddrLan
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // IPImageAddrLan
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // IPLogInAddrNet
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // IPImageAddrNet
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // OrganizationID
            cursor.isNull(offset + 7) ? null : cursor.getShort(offset + 7) != 0 // isSelLan
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, IPAddressEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setIPName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setIPLogInAddrLan(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setIPImageAddrLan(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setIPLogInAddrNet(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setIPImageAddrNet(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setOrganizationID(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setIsSelLan(cursor.isNull(offset + 7) ? null : cursor.getShort(offset + 7) != 0);
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(IPAddressEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(IPAddressEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}