package com.p2p.admin.cm.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;

/**
 * @author mbmartinez
 */
@Api(value = "", description = "Card operations")
@RequestMapping({"/card", "/c"})
@RestController
public class CardResource {

}
