package com.p2p.commons.core.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p2p.commons.core.models.Card;
import com.p2p.commons.core.models.Expansion;

/**
 * @author mbmartinez
 */
public interface CardRepo extends JpaRepository<Card, Long> {

    List<Card> findByExpansion(Expansion expansion);

}
