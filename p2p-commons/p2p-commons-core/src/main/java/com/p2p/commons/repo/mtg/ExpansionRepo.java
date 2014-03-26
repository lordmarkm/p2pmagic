package com.p2p.commons.repo.mtg;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p2p.commons.models.mtg.Expansion;

/**
 * @author mbmartinez
 */
public interface ExpansionRepo extends JpaRepository<Expansion, Long> {

}
