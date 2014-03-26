package com.p2p.commons.repo.player;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p2p.commons.models.player.MagicPlayer;

/**
 * @author mbmartinez
 */
public interface MagicPlayerRepo extends JpaRepository<MagicPlayer, Long> {

}
