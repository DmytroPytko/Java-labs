package com.dimon.Repository;

import com.dimon.domain.Replacement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplacementRepository extends JpaRepository<Replacement, Long> {

}
