package com.p2p.proper.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p2p.proper.core.models.MagicPlayer;

/**
 * @author mbmartinez
 */
public interface MagicPlayerRepo extends JpaRepository<MagicPlayer, Long> {

}
