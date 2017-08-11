package main.java.io.github.yutoeguma.repository;

import main.java.io.github.yutoeguma.entity.MemberStatus;
import org.springframework.data.repository.CrudRepository;

/**
 * @author yuto
 */
public interface MemberStatusRepository extends CrudRepository<MemberStatus, String> {
}
