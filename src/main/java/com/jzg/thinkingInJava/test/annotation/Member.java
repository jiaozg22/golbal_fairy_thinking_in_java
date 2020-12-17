package com.jzg.thinkingInJava.test.annotation;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 接口
 * @date 2020/11/14 13:09
 */
@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30) String firstName;
    @SQLString(50) String lastName;
    @SQLInteger Integer age;
    @SQLString(value=30,constraints = @Constraints(primaryKey = true)) String handle;
    static int memberCount;
    public String toString(){
        return handle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getHandle() {
        return handle;
    }

    public static int getMemberCount() {
        return memberCount;
    }
}
