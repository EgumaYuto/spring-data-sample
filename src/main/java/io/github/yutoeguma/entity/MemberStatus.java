package main.java.io.github.yutoeguma.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author yuto
 */
@Entity
@Data
public class MemberStatus {

    @Id
    @Column(name = "member_status_code")
    private String memberStatusCode;
    @Column(name = "member_status_name")
    private String memberStatusName;
    @Column(name = "description")
    private String description;
}
