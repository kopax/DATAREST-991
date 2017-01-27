/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.greglturnquist.payroll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Greg Turnquist
 */
// tag::code[]
@RepositoryRestController
public class ManagerController {

	@Autowired
	private ManagerRepository managerRepository;

	@Autowired
	public ManagerController(ManagerRepository managerRepository) {
		this.managerRepository = managerRepository;
	}

	@RequestMapping(value = "/greg")
	public ResponseEntity<Resource<Manager>> index() {
		Manager greg = this.managerRepository.findByName("greg");
		Resource<Manager> resource = new Resource<>(greg);
		return ResponseEntity.ok(resource);
	}

}
// end::code[]