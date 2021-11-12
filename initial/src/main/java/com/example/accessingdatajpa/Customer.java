package com.example.accessingdatajpa;

import javax.persistence.*;

/**
 * @ClassName Customer
 * @Description Customer类用@Entity注解，表示它是一个JPA实体,如果没有@Table这个注释，则需要类名与表名相同
 * @Author XiaoShuMu
 * @Version 1.0
 * @Create 2021-11-12 11:19
 * @Blog https://www.cnblogs.com/WLCYSYS/
 **/
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstName;
    private String lastName;

    /**
     * @Description: 默认构造函数只是为了 JPA 而存在。
     * @Param: []
     * @return: 
     * @Author: XiaoShuMu
     * @Date: 2021/11/12
     */
    protected Customer() {

    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, firstName='%s', lastName=%s]", id, firstName, lastName);
    }

}
