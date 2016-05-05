package com.evilsoulm.keep_nice.model.dao.entity;


import com.google.gson.Gson;

import java.util.Map;

public class Collection {

    /**
     * __type : Pointer
     * className : _User
     * objectId : 563c1d9xxxx749ea071246
     */

    private UserEntity user;
    /**
     * __type : Pointer
     * className : Entry
     * objectId : 56403b2e60b259ca8e31cc4b
     */

    private Map.Entry entry;
    /**
     * user : {"__type":"Pointer","className":"_User","objectId":"563c1d9xxxx749ea071246"}
     * entry : {"__type":"Pointer","className":"Entry","objectId":"56403b2e60b259ca8e31cc4b"}
     * createdAt : 2015-11-10T01:44:43.588Z
     * updatedAt : 2015-11-10T01:44:43.671Z
     * objectId : 56414c0b00b0023c3ab7da21
     */

    private String createdAt;
    private String updatedAt;
    private String objectId;

    public static Collection objectFromData(String str) {

        return new Gson().fromJson(str, Collection.class);
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Map.Entry getEntry() {
        return entry;
    }

    public void setEntry(Map.Entry entry) {
        this.entry = entry;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public static class UserEntity {
        private String __type;
        private String className;
        private String objectId;

        public static UserEntity objectFromData(String str) {

            return new Gson().fromJson(str, UserEntity.class);
        }

        public String get__type() {
            return __type;
        }

        public void set__type(String __type) {
            this.__type = __type;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public String getObjectId() {
            return objectId;
        }

        public void setObjectId(String objectId) {
            this.objectId = objectId;
        }
    }

}
