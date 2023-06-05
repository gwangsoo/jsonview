package com.xrfriends.jsonview.dto;

public abstract class AbstractAuditingDTO<T> {

    public abstract T getId();

    public abstract void setId(T d);

}
