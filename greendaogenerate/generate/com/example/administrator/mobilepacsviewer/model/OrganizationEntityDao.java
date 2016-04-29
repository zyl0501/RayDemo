package com.example.administrator.mobilepacsviewer.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.example.administrator.mobilepacsviewer.model.OrganizationEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ORGANIZATION_ENTITY".
*/
public class OrganizationEntityDao extends AbstractDao<OrganizationEntity, Long> {

    public static final String TABLENAME = "ORGANIZATION_ENTITY";

    /**
     * Properties of entity OrganizationEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property OrganizationID = new Property(1, String.class, "OrganizationID", false, "ORGANIZATION_ID");
        public final static Property OrganizationName = new Property(2, String.class, "OrganizationName", false, "ORGANIZATION_NAME");
    };


    public OrganizationEntityDao(DaoConfig config) {
        super(config);
    }
    
    public OrganizationEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ORGANIZATION_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"ORGANIZATION_ID\" TEXT NOT NULL ," + // 1: OrganizationID
                "\"ORGANIZATION_NAME\" TEXT NOT NULL );"); // 2: OrganizationName
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ORGANIZATION_ENTITY\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, OrganizationEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getOrganizationID());
        stmt.bindString(3, entity.getOrganizationName());
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public OrganizationEntity readEntity(Cursor cursor, int offset) {
        OrganizationEntity entity = new OrganizationEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // OrganizationID
            cursor.getString(offset + 2) // OrganizationName
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, OrganizationEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setOrganizationID(cursor.getString(offset + 1));
        entity.setOrganizationName(cursor.getString(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(OrganizationEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(OrganizationEntity entity) {
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
