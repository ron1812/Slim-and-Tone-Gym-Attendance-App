package com.management.attendance.repository;

import com.management.attendance.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

    @Query("SELECT p FROM Member p where concat(lower(p.firstName),lower(p.lastName)) like %:name%")
    Page<Member> findByName(String name, Pageable page);
}
