package com.p2p.proper.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p2p.proper.core.models.Meetup;

/**
 * @author mbmartinez
 */
public interface MeetupRepo extends JpaRepository<Meetup, Long> {

}
