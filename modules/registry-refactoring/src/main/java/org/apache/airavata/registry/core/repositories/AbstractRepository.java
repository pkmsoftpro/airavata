/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
*/
package org.apache.airavata.registry.core.repositories;

import org.apache.airavata.registry.core.utils.JPAUtils;
import org.apache.airavata.registry.core.utils.ObjectMapperSingleton;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository<T, E, Id> {
    private final static Logger logger = LoggerFactory.getLogger(AbstractRepository.class);

    private Class<T> thriftGenericClass;
    private Class<E> dbEntityGenericClass;

    public AbstractRepository(Class<T> thriftGenericClass, Class<E> dbEntityGenericClass){
        this.thriftGenericClass = thriftGenericClass;
        this.dbEntityGenericClass = dbEntityGenericClass;
    }

    public T create(T t){
        return update(t);
    }

    public  T update(T t){
        Mapper mapper = ObjectMapperSingleton.getInstance();
        E entity = mapper.map(t, dbEntityGenericClass);
        E persistedCopy = JPAUtils.execute(entityManager -> entityManager.merge(entity));
        return mapper.map(persistedCopy, thriftGenericClass);
    }

    public boolean delete(Id id){
        JPAUtils.execute(entityManager -> {
            E entity = entityManager.find(dbEntityGenericClass, id);
            entityManager.remove(entity);
            return entity;
        });
        return true;
    }

    public T get(Id id){
        E entity = JPAUtils.execute(entityManager -> entityManager
                .find(dbEntityGenericClass, id));
        Mapper mapper = ObjectMapperSingleton.getInstance();
        return mapper.map(entity, thriftGenericClass);
    }

    public List<T> select(String query, int limit, int offset){
        List resultSet = (List) JPAUtils.execute(entityManager -> entityManager.createQuery(query).setFirstResult(offset)
                .setMaxResults(offset).getResultList());
        Mapper mapper = ObjectMapperSingleton.getInstance();
        List<T> gatewayList = new ArrayList<>();
        resultSet.stream().forEach(rs -> gatewayList.add(mapper.map(rs, thriftGenericClass)));
        return gatewayList;
    }
}