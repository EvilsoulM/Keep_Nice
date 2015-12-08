package com.evilsoulm;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class KeepNiceDaoGenerator {
    private final static String SCHEMA_NAME = "com.evilsoulm.keep_nice.model.dao";
    private static int VERSION = 1;

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(VERSION, SCHEMA_NAME);
        schema.enableKeepSectionsByDefault();

        createUser(schema);

        new DaoGenerator().generateAll(schema, "model/src/main/java");
    }

    private static void createUser(Schema schema) {
        Entity entity = schema.addEntity("User");
        entity.setTableName("user");
        entity.addLongProperty("userId").primaryKey();
        entity.addStringProperty("name").notNull();
        entity.addStringProperty("age").notNull();
    }
}
