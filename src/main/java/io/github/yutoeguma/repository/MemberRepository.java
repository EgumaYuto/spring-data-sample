package main.java.io.github.yutoeguma.repository;

import main.java.io.github.yutoeguma.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author yuto
 */
public interface MemberRepository extends CrudRepository<Member, Long> {

    /**
     * 全ての会員を取得する
     * @return 会員のリスト
     */
    public List<Member> findAll();

    /**
     * member_status_code で絞り込みをかけるメソッド<br>
     * 内部処理はspringによって自動生成される
     *
     * @param memberStatusCode 会員ステータスコード
     * @return 会員のリスト
     */
    public List<Member> findByMemberStatusCode(String memberStatusCode);

    public void deleteByMemberAccount(String memberAccount);
}
