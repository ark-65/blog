package io.ark.hope.repository;

import io.ark.hope.domain.UserMember;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ark
 */
public interface UserMemberRepository extends JpaRepository<UserMember, Long> {
}
