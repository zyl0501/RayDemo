package com.ray.greendao;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;

public class MyClass {
    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "com.example.administrator.mobilepacsviewer.model");

        addSearchTemplate(schema);
        addQueryInfoRet(schema);
        addDepartOrder(schema);
        addOrganizationOrder(schema);
        addIpAddress(schema);

        new DaoGenerator().generateAll(schema, "E:\\workspace\\RayDemo\\greendaogenerate\\generate");
    }

    private static void addSearchTemplate(Schema schema) {
        Entity entity = schema.addEntity("SearchTemplateEntity");
        entity.addIdProperty();
        entity.addStringProperty("SearchName");
        entity.addStringProperty("AccessionNumber");
        entity.addStringProperty("Name");
        entity.addStringProperty("MedRecNO");
        entity.addStringProperty("OrganizationID");
        entity.addStringProperty("RequestDeptName");
        entity.addStringProperty("PatientClass");
        entity.addStringProperty("ServiceSectID");
        entity.addStringProperty("RequestedDateStart");
        entity.addStringProperty("RequestedDateEnd");

        int Page;
        int Rows;
    }

    private static void addQueryInfoRet(Schema schema) {
        Entity entity = schema.addEntity("QueryInfoRet");
        entity.addIdProperty();
        entity.addStringProperty("AccessionNumber");
        entity.addStringProperty("Name");
        entity.addStringProperty("Sex");
        entity.addStringProperty("Age");
        entity.addStringProperty("AgeUnit");
        entity.addStringProperty("ServiceSectID");
        entity.addStringProperty("ServiceText");
        entity.addStringProperty("ObservationDate");
        entity.addStringProperty("MedRecNO");
        entity.addStringProperty("PatientClass");
        entity.addStringProperty("InPatientNO");
        entity.addStringProperty("OutPatientNO");
        entity.addStringProperty("PointOfCare");
        entity.addStringProperty("Bed");
        entity.addStringProperty("OrganizationID");
        entity.addStringProperty("RequestOrgName");
        entity.addStringProperty("RequestDeptName");
        entity.addStringProperty("ProviderName");
        entity.addStringProperty("RequestedDate");
        entity.addStringProperty("ProcedureName");
        entity.addStringProperty("ObservationUID").unique();
    }

    private static void addCustomerOrder(Schema schema) {
        Entity customer = schema.addEntity("Customer");
        customer.addIdProperty();
        customer.addStringProperty("name").notNull();

        Entity order = schema.addEntity("Order");
        order.setTableName("ORDERS"); // "ORDER" is a reserved keyword
        order.addIdProperty();
        Property orderDate = order.addDateProperty("date").getProperty();
        Property customerId = order.addLongProperty("customerId").notNull().getProperty();
        order.addToOne(customer, customerId);

        ToMany customerToOrders = customer.addToMany(order, customerId);
        customerToOrders.setName("orders");
        customerToOrders.orderAsc(orderDate);
    }

    private static void addIpAddress(Schema schema) {
        Entity customer = schema.addEntity("IPAddressEntity");
        customer.addIdProperty();
        customer.addStringProperty("IPName");
        customer.addStringProperty("IPLogInAddr");
        customer.addStringProperty("IPImageAddr");
    }

    private static void addDepartOrder(Schema schema) {
        Entity customer = schema.addEntity("DepartmentEntity");
        customer.addIdProperty();
        customer.addStringProperty("DeptName").notNull();
    }

    private static void addOrganizationOrder(Schema schema) {
        Entity customer = schema.addEntity("OrganizationEntity");
        customer.addIdProperty();
        customer.addStringProperty("OrganizationID").notNull();
        customer.addStringProperty("OrganizationName").notNull();
    }

    private static void addExamSub(Schema schema){
        Entity customer = schema.addEntity("ExamSubEntity");
        customer.addIdProperty();
        customer.addStringProperty("CreateDate");
        customer.addStringProperty("Memo");
        customer.addStringProperty("ObjectType");
        customer.addStringProperty("ObjectUID");
        customer.addStringProperty("PatientMasterID");
        customer.addStringProperty("RelatedObject");
        customer.addStringProperty("RemindEndDate");
        customer.addStringProperty("RemindStartDate");
        customer.addStringProperty("SubscriptionSeq");
        customer.addStringProperty("SubscriptionType");
        customer.addStringProperty("UserUID");
    }
}
