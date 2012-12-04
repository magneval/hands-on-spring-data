/*
* Copyright 2012 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.springframework.data.samples._01_jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;
import org.springframework.data.samples._01_jpa.domain.Customer;

@RestResource
public interface CustomersRepository extends PagingAndSortingRepository<Customer,Long>, QueryDslPredicateExecutor<Customer> {

    @Query("select c from Customer c where length(c.firstName) = length(c.lastName) and length(c.firstName) = :l")
    Iterable<Customer> findWithEqualLengthNames(@Param("l") int length);
}
