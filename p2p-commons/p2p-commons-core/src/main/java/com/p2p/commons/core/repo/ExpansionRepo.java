package com.p2p.commons.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p2p.commons.core.models.Expansion;

/**
 * @author mbmartinez
 */
public interface ExpansionRepo extends JpaRepository<Expansion, Long> {

    public Expansion findByCode(String code);

}
