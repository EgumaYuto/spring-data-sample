package main.java.io.github.yutoeguma.controller;

import main.java.io.github.yutoeguma.entity.Member;
import main.java.io.github.yutoeguma.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


/**
 * spring db with maihamadb
 */
@RestController
@RequestMapping(path="/api")
public class SpringDBSampleController {

    @Autowired
    private MemberRepository memberRepository;

    /**
     * select all record
     */
    @GetMapping(path="/all")
    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }

    /**
     * Memberの中から正式会員で絞り込む
     */
    @GetMapping(path="/part/{code}")
    public List<Member> getPartMember(@PathVariable String code) {
        return memberRepository.findByMemberStatusCode(code);
    }

    /**
     * 一件挿入
     */
    @PostMapping(path="/save/{account}")
    public Member saveMember(@PathVariable String account) {
        Member member = new Member();
        member.setMemberName(account);
        member.setMemberAccount(account);
        member.setMemberStatusCode("FML");
        member.setRegisterDatetime(Timestamp.valueOf(LocalDateTime.now()));
        member.setRegisterUser("cabos");
        member.setUpdateDatetime(Timestamp.valueOf(LocalDateTime.now()));
        member.setUpdateUser("cabos");
        member.setVersionNo(0L);
        return memberRepository.save(member);
    }

    /**
     * 全件削除
     */
    @DeleteMapping(path="/delete/{account}")
    @Transactional
    public String delete(@PathVariable String account) {
        memberRepository.deleteByMemberAccount(account);
        return account;
    }
}
