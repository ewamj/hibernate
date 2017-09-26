package com.infoshareacademy.entities;

import javax.persistence.*;
import java.util.Date;

@NamedQueries({
        @NamedQuery(query = "SELECT u FROM User u WHERE name LIKE CONCAT(:name,'%')", name = "com.infoshareacademy.entities.User.userByName"),
        @NamedQuery(query = "SELECT COUNT(u) FROM User u WHERE name LIKE CONCAT(:name,'%')", name = "com.infoshareacademy.entities.User.userCountByName")
})
@Entity
@Table(name = "T_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "login")
    private String login;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "timestamp")
    private Date timestamp;

    @ManyToOne// default : (fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private Group groupId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Group getGroupId() {
        return groupId;
    }

    public void setGroupId(Group groupId) {
        this.groupId = groupId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
