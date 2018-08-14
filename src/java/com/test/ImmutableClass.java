/*
 * Iman Tech Solutions,
 * Hyderabad, India
 * 
 */
package com.test;

import java.util.Date;

/**
 *
 * @author Lokesh Kotha
 */
public final class ImmutableClass {

    private final Date remindingDate;
    private final String name;
    private final String mobile;

    public ImmutableClass(Date remindingDate, String name, String mobile) {
        if (remindingDate.getTime() < System.currentTimeMillis()) {
            throw new IllegalArgumentException("Can not set reminder for past time: " + remindingDate);
        }
        this.remindingDate = new Date(remindingDate.getTime());
        this.name = name;
        this.mobile = mobile;
    }

    public Date getRemindingDate() {
        return remindingDate;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

}
