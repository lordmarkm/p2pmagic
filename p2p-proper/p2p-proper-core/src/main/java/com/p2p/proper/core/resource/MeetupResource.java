package com.p2p.proper.core.resource;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.p2p.proper.core.dto.MeetupInfo;
import com.p2p.proper.core.models.Meetup;
import com.p2p.proper.core.repo.MeetupRepo;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.http.HttpStatus.*;

/**
 * @author mbmartinez
 */
@Api(value = "", description = "Meetup operations")
@RequestMapping({"/meetup", "/m"})
@RestController
public class MeetupResource {

    @Autowired
    private MeetupRepo meetupRepo;

    @Autowired
    private Mapper mapper;

    @ApiOperation("Get all meetups")
    @RequestMapping(method = GET)
    public ResponseEntity<Page<MeetupInfo>> findAll(
            @ApiParam(defaultValue = "0") @RequestParam int page, 
            @ApiParam(defaultValue = "10") @RequestParam int length) {

        Pageable pageRequest = new PageRequest(page, length);
        Page<Meetup> meetups = meetupRepo.findAll(pageRequest);

        List<MeetupInfo> meetupInfos = Lists.newArrayList();
        for (Meetup meetup : meetups) {
            meetupInfos.add(mapper.map(meetup, MeetupInfo.class));
        }

        Page<MeetupInfo> meetupInfoPage = new PageImpl<>(meetupInfos, pageRequest, meetups.getTotalElements());
        return new ResponseEntity<>(meetupInfoPage, OK);
    }

    @ApiOperation("Create a meetup")
    @RequestMapping(method = POST)
    @PreAu
    public ResponseEntity<MeetupInfo> create() {
        
    }
}
