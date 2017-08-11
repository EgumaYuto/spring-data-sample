package main.java.io.github.yutoeguma.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

/**
 * @author yuto
 */
@Entity
@Data
public class Member {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "member_id")
    private Long memberId;
    @Column(name = "member_name")
    private String memberName;
    @Column(name = "member_account", unique = true)
    private String memberAccount;
    @Column(name = "formalized_datetime")
    private Timestamp formalizedDatetime;
    @Column(name = "birthdate")
    private Timestamp birthdate;
    @Column(name = "member_status_code")
    private String memberStatusCode;
    @Column(name = "register_datetime")
    private Timestamp registerDatetime;
    @Column(name = "register_user")
    private String registerUser;
    @Column(name = "update_datetime")
    private Timestamp updateDatetime;
    @Column(name = "update_user")
    private String updateUser;
    @Column(name = "version_no")
    private Long versionNo;

    @ManyToOne
    @JoinColumn(name="member_status_code", referencedColumnName="member_status_code", insertable=false, updatable=false)
    private MemberStatus memberStatus;
}
