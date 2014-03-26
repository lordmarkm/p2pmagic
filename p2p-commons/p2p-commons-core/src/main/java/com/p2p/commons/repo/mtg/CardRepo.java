package com.p2p.commons.repo.mtg;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p2p.commons.models.mtg.Card;

/**
 * @author mbmartinez
 */
public interface CardRepo extends JpaRepository<Card, Long> {

}
