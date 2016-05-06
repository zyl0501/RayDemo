package com.example.administrator.mobilepacsviewer.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.example.administrator.mobilepacsviewer.model.QueryInfoRet;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "QUERY_INFO_RET".
*/
public class QueryInfoRetDao extends AbstractDao<QueryInfoRet, Long> {

    public static final String TABLENAME = "QUERY_INFO_RET";

    /**
     * Properties of entity QueryInfoRet.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property AccessionNumber = new Property(1, String.class, "AccessionNumber", false, "ACCESSION_NUMBER");
        public final static Property Name = new Property(2, String.class, "Name", false, "NAME");
        public final static Property Sex = new Property(3, String.class, "Sex", false, "SEX");
        public final static Property Age = new Property(4, String.class, "Age", false, "AGE");
        public final static Property AgeUnit = new Property(5, String.class, "AgeUnit", false, "AGE_UNIT");
        public final static Property ServiceSectID = new Property(6, String.class, "ServiceSectID", false, "SERVICE_SECT_ID");
        public final static Property ServiceText = new Property(7, String.class, "ServiceText", false, "SERVICE_TEXT");
        public final static Property ObservationDate = new Property(8, String.class, "ObservationDate", false, "OBSERVATION_DATE");
        public final static Property MedRecNO = new Property(9, String.class, "MedRecNO", false, "MED_REC_NO");
        public final static Property PatientClass = new Property(10, String.class, "PatientClass", false, "PATIENT_CLASS");
        public final static Property InPatientNO = new Property(11, String.class, "InPatientNO", false, "IN_PATIENT_NO");
        public final static Property OutPatientNO = new Property(12, String.class, "OutPatientNO", false, "OUT_PATIENT_NO");
        public final static Property PointOfCare = new Property(13, String.class, "PointOfCare", false, "POINT_OF_CARE");
        public final static Property Bed = new Property(14, String.class, "Bed", false, "BED");
        public final static Property OrganizationID = new Property(15, String.class, "OrganizationID", false, "ORGANIZATION_ID");
        public final static Property RequestOrgName = new Property(16, String.class, "RequestOrgName", false, "REQUEST_ORG_NAME");
        public final static Property RequestDeptName = new Property(17, String.class, "RequestDeptName", false, "REQUEST_DEPT_NAME");
        public final static Property ProviderName = new Property(18, String.class, "ProviderName", false, "PROVIDER_NAME");
        public final static Property RequestedDate = new Property(19, String.class, "RequestedDate", false, "REQUESTED_DATE");
        public final static Property ProcedureName = new Property(20, String.class, "ProcedureName", false, "PROCEDURE_NAME");
        public final static Property ObservationUID = new Property(21, String.class, "ObservationUID", false, "OBSERVATION_UID");
    };


    public QueryInfoRetDao(DaoConfig config) {
        super(config);
    }
    
    public QueryInfoRetDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"QUERY_INFO_RET\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"ACCESSION_NUMBER\" TEXT," + // 1: AccessionNumber
                "\"NAME\" TEXT," + // 2: Name
                "\"SEX\" TEXT," + // 3: Sex
                "\"AGE\" TEXT," + // 4: Age
                "\"AGE_UNIT\" TEXT," + // 5: AgeUnit
                "\"SERVICE_SECT_ID\" TEXT," + // 6: ServiceSectID
                "\"SERVICE_TEXT\" TEXT," + // 7: ServiceText
                "\"OBSERVATION_DATE\" TEXT," + // 8: ObservationDate
                "\"MED_REC_NO\" TEXT," + // 9: MedRecNO
                "\"PATIENT_CLASS\" TEXT," + // 10: PatientClass
                "\"IN_PATIENT_NO\" TEXT," + // 11: InPatientNO
                "\"OUT_PATIENT_NO\" TEXT," + // 12: OutPatientNO
                "\"POINT_OF_CARE\" TEXT," + // 13: PointOfCare
                "\"BED\" TEXT," + // 14: Bed
                "\"ORGANIZATION_ID\" TEXT," + // 15: OrganizationID
                "\"REQUEST_ORG_NAME\" TEXT," + // 16: RequestOrgName
                "\"REQUEST_DEPT_NAME\" TEXT," + // 17: RequestDeptName
                "\"PROVIDER_NAME\" TEXT," + // 18: ProviderName
                "\"REQUESTED_DATE\" TEXT," + // 19: RequestedDate
                "\"PROCEDURE_NAME\" TEXT," + // 20: ProcedureName
                "\"OBSERVATION_UID\" TEXT UNIQUE );"); // 21: ObservationUID
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"QUERY_INFO_RET\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, QueryInfoRet entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String AccessionNumber = entity.getAccessionNumber();
        if (AccessionNumber != null) {
            stmt.bindString(2, AccessionNumber);
        }
 
        String Name = entity.getName();
        if (Name != null) {
            stmt.bindString(3, Name);
        }
 
        String Sex = entity.getSex();
        if (Sex != null) {
            stmt.bindString(4, Sex);
        }
 
        String Age = entity.getAge();
        if (Age != null) {
            stmt.bindString(5, Age);
        }
 
        String AgeUnit = entity.getAgeUnit();
        if (AgeUnit != null) {
            stmt.bindString(6, AgeUnit);
        }
 
        String ServiceSectID = entity.getServiceSectID();
        if (ServiceSectID != null) {
            stmt.bindString(7, ServiceSectID);
        }
 
        String ServiceText = entity.getServiceText();
        if (ServiceText != null) {
            stmt.bindString(8, ServiceText);
        }
 
        String ObservationDate = entity.getObservationDate();
        if (ObservationDate != null) {
            stmt.bindString(9, ObservationDate);
        }
 
        String MedRecNO = entity.getMedRecNO();
        if (MedRecNO != null) {
            stmt.bindString(10, MedRecNO);
        }
 
        String PatientClass = entity.getPatientClass();
        if (PatientClass != null) {
            stmt.bindString(11, PatientClass);
        }
 
        String InPatientNO = entity.getInPatientNO();
        if (InPatientNO != null) {
            stmt.bindString(12, InPatientNO);
        }
 
        String OutPatientNO = entity.getOutPatientNO();
        if (OutPatientNO != null) {
            stmt.bindString(13, OutPatientNO);
        }
 
        String PointOfCare = entity.getPointOfCare();
        if (PointOfCare != null) {
            stmt.bindString(14, PointOfCare);
        }
 
        String Bed = entity.getBed();
        if (Bed != null) {
            stmt.bindString(15, Bed);
        }
 
        String OrganizationID = entity.getOrganizationID();
        if (OrganizationID != null) {
            stmt.bindString(16, OrganizationID);
        }
 
        String RequestOrgName = entity.getRequestOrgName();
        if (RequestOrgName != null) {
            stmt.bindString(17, RequestOrgName);
        }
 
        String RequestDeptName = entity.getRequestDeptName();
        if (RequestDeptName != null) {
            stmt.bindString(18, RequestDeptName);
        }
 
        String ProviderName = entity.getProviderName();
        if (ProviderName != null) {
            stmt.bindString(19, ProviderName);
        }
 
        String RequestedDate = entity.getRequestedDate();
        if (RequestedDate != null) {
            stmt.bindString(20, RequestedDate);
        }
 
        String ProcedureName = entity.getProcedureName();
        if (ProcedureName != null) {
            stmt.bindString(21, ProcedureName);
        }
 
        String ObservationUID = entity.getObservationUID();
        if (ObservationUID != null) {
            stmt.bindString(22, ObservationUID);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public QueryInfoRet readEntity(Cursor cursor, int offset) {
        QueryInfoRet entity = new QueryInfoRet( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // AccessionNumber
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // Name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // Sex
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // Age
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // AgeUnit
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // ServiceSectID
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // ServiceText
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // ObservationDate
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // MedRecNO
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // PatientClass
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // InPatientNO
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // OutPatientNO
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // PointOfCare
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // Bed
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // OrganizationID
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // RequestOrgName
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // RequestDeptName
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // ProviderName
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), // RequestedDate
            cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20), // ProcedureName
            cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21) // ObservationUID
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, QueryInfoRet entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setAccessionNumber(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setSex(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setAge(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setAgeUnit(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setServiceSectID(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setServiceText(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setObservationDate(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setMedRecNO(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setPatientClass(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setInPatientNO(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setOutPatientNO(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setPointOfCare(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setBed(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setOrganizationID(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setRequestOrgName(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setRequestDeptName(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setProviderName(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setRequestedDate(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setProcedureName(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
        entity.setObservationUID(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(QueryInfoRet entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(QueryInfoRet entity) {
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
