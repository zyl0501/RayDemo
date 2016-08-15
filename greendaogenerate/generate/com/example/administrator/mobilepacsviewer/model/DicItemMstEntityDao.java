package com.example.administrator.mobilepacsviewer.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.example.administrator.mobilepacsviewer.model.DicItemMstEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DIC_ITEM_MST_ENTITY".
*/
public class DicItemMstEntityDao extends AbstractDao<DicItemMstEntity, Long> {

    public static final String TABLENAME = "DIC_ITEM_MST_ENTITY";

    /**
     * Properties of entity DicItemMstEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property ItemName = new Property(1, String.class, "ItemName", false, "ITEM_NAME");
        public final static Property ItemRepresen = new Property(2, String.class, "ItemRepresen", false, "ITEM_REPRESEN");
        public final static Property TypeCode = new Property(3, String.class, "TypeCode", false, "TYPE_CODE");
    };


    public DicItemMstEntityDao(DaoConfig config) {
        super(config);
    }
    
    public DicItemMstEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DIC_ITEM_MST_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"ITEM_NAME\" TEXT," + // 1: ItemName
                "\"ITEM_REPRESEN\" TEXT," + // 2: ItemRepresen
                "\"TYPE_CODE\" TEXT);"); // 3: TypeCode
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DIC_ITEM_MST_ENTITY\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, DicItemMstEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String ItemName = entity.getItemName();
        if (ItemName != null) {
            stmt.bindString(2, ItemName);
        }
 
        String ItemRepresen = entity.getItemRepresen();
        if (ItemRepresen != null) {
            stmt.bindString(3, ItemRepresen);
        }
 
        String TypeCode = entity.getTypeCode();
        if (TypeCode != null) {
            stmt.bindString(4, TypeCode);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public DicItemMstEntity readEntity(Cursor cursor, int offset) {
        DicItemMstEntity entity = new DicItemMstEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // ItemName
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // ItemRepresen
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // TypeCode
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, DicItemMstEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setItemName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setItemRepresen(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setTypeCode(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(DicItemMstEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(DicItemMstEntity entity) {
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
