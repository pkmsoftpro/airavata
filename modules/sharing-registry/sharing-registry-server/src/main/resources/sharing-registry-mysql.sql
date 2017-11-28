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

CREATE TABLE DOMAIN (
  DOMAIN_ID VARCHAR(255) NOT NULL,
  NAME VARCHAR(255) NOT NULL,
  DESCRIPTION VARCHAR(255),
  CREATED_TIME BIGINT NOT NULL,
  UPDATED_TIME BIGINT NOT NULL,
  PRIMARY KEY (DOMAIN_ID)
)ENGINE=InnoDB DEFAULT CHARACTER SET=latin1;

CREATE TABLE SHARING_USER (
  USER_ID VARCHAR(255) NOT NULL,
  DOMAIN_ID VARCHAR(255) NOT NULL,
  USER_NAME VARCHAR(255) NOT NULL,
  FIRST_NAME VARCHAR (255),
  LAST_NAME VARCHAR (255),
  EMAIL VARCHAR (255),
  ICON BLOB,
  CREATED_TIME BIGINT NOT NULL,
  UPDATED_TIME BIGINT NOT NULL,
  PRIMARY KEY (USER_ID, DOMAIN_ID),
  FOREIGN KEY (DOMAIN_ID) REFERENCES DOMAIN(DOMAIN_ID) ON DELETE CASCADE ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARACTER SET=latin1;

CREATE TABLE USER_GROUP (
  GROUP_ID VARCHAR(255) NOT NULL,
  DOMAIN_ID VARCHAR(255) NOT NULL,
  NAME VARCHAR(255) NOT NULL,
  DESCRIPTION VARCHAR(255),
  OWNER_ID VARCHAR(255) NOT NULL,
  GROUP_TYPE VARCHAR(255) NOT NULL,
  GROUP_CARDINALITY VARCHAR(255) NOT NULL,
  CREATED_TIME BIGINT NOT NULL,
  UPDATED_TIME BIGINT NOT NULL,
  PRIMARY KEY (GROUP_ID, DOMAIN_ID),
  FOREIGN KEY (OWNER_ID, DOMAIN_ID) REFERENCES SHARING_USER(USER_ID, DOMAIN_ID) ON DELETE CASCADE ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARACTER SET=latin1;

CREATE TABLE GROUP_OWNER (
  OWNER_ID VARCHAR(255) NOT NULL,
  GROUP_ID VARCHAR(255) NOT NULL,
  DOMAIN_ID VARCHAR(255) NOT NULL,
  PRIMARY KEY (OWNER_ID, DOMAIN_ID),
  FOREIGN KEY (OWNER_ID, DOMAIN_ID) REFERENCES SHARING_USER(USER_ID, DOMAIN_ID) ON DELETE CASCADE ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARACTER SET=latin1;

CREATE TABLE GROUP_ADMIN (
  ADMIN_ID VARCHAR(255) NOT NULL,
  GROUP_ID VARCHAR(255) NOT NULL,
  DOMAIN_ID VARCHAR(255) NOT NULL,
  PRIMARY KEY (ADMIN_ID, GROUP_ID, DOMAIN_ID),
  FOREIGN KEY (ADMIN_ID, DOMAIN_ID) REFERENCES SHARING_USER(USER_ID, DOMAIN_ID) ON DELETE CASCADE ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARACTER SET=latin1;

CREATE TABLE GROUP_MEMBERSHIP (
  PARENT_ID VARCHAR(255) NOT NULL,
  CHILD_ID VARCHAR(255) NOT NULL,
  DOMAIN_ID VARCHAR(255) NOT NULL,
  CHILD_TYPE VARCHAR(255) NOT NULL,
  CREATED_TIME BIGINT NOT NULL,
  UPDATED_TIME BIGINT NOT NULL,
  PRIMARY KEY (PARENT_ID, CHILD_ID, DOMAIN_ID),
  FOREIGN KEY (PARENT_ID, DOMAIN_ID) REFERENCES USER_GROUP(GROUP_ID, DOMAIN_ID) ON DELETE CASCADE ON UPDATE NO ACTION,
  FOREIGN KEY (CHILD_ID, DOMAIN_ID) REFERENCES USER_GROUP(GROUP_ID, DOMAIN_ID) ON DELETE CASCADE ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARACTER SET=latin1;

CREATE TABLE ENTITY_TYPE (
  ENTITY_TYPE_ID VARCHAR(255) NOT NULL,
  DOMAIN_ID VARCHAR(255) NOT NULL,
  NAME VARCHAR(255) NOT NULL,
  DESCRIPTION VARCHAR(255),
  CREATED_TIME BIGINT NOT NULL,
  UPDATED_TIME BIGINT NOT NULL,
  PRIMARY KEY (ENTITY_TYPE_ID, DOMAIN_ID),
  FOREIGN KEY (DOMAIN_ID) REFERENCES DOMAIN(DOMAIN_ID) ON DELETE CASCADE ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARACTER SET=latin1;

CREATE TABLE PERMISSION_TYPE (
  PERMISSION_TYPE_ID VARCHAR(255) NOT NULL,
  DOMAIN_ID VARCHAR(255) NOT NULL,
  NAME VARCHAR(255) NOT NULL,
  DESCRIPTION VARCHAR(255),
  CREATED_TIME BIGINT NOT NULL,
  UPDATED_TIME BIGINT NOT NULL,
  PRIMARY KEY (PERMISSION_TYPE_ID, DOMAIN_ID),
  FOREIGN KEY (DOMAIN_ID) REFERENCES DOMAIN(DOMAIN_ID) ON DELETE CASCADE ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARACTER SET=latin1;

CREATE TABLE ENTITY (
  ENTITY_ID VARCHAR(255) NOT NULL,
  DOMAIN_ID VARCHAR(255) NOT NULL,
  ENTITY_TYPE_ID VARCHAR(255) NOT NULL,
  OWNER_ID VARCHAR(255) NOT NULL,
  PARENT_ENTITY_ID VARCHAR(255),
  NAME VARCHAR(255) NOT NULL,
  DESCRIPTION VARCHAR(255),
  BINARY_DATA BLOB,
  FULL_TEXT TEXT,
  SHARED_COUNT BIGINT DEFAULT 0,
  ORIGINAL_ENTITY_CREATION_TIME BIGINT NOT NULL,
  CREATED_TIME BIGINT NOT NULL,
  UPDATED_TIME BIGINT NOT NULL,
  PRIMARY KEY (ENTITY_ID, DOMAIN_ID),
  FOREIGN KEY (ENTITY_TYPE_ID, DOMAIN_ID) REFERENCES ENTITY_TYPE(ENTITY_TYPE_ID, DOMAIN_ID) ON DELETE CASCADE ON UPDATE NO ACTION,
  FOREIGN KEY (OWNER_ID, DOMAIN_ID) REFERENCES SHARING_USER(USER_ID, DOMAIN_ID) ON DELETE CASCADE ON UPDATE NO ACTION,
  FOREIGN KEY (PARENT_ENTITY_ID, DOMAIN_ID) REFERENCES ENTITY(ENTITY_ID, DOMAIN_ID) ON DELETE CASCADE ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARACTER SET=latin1;

ALTER TABLE ENTITY ADD FULLTEXT FULL_TEXT_INDEX(FULL_TEXT);

CREATE TABLE SHARING (
  PERMISSION_TYPE_ID VARCHAR(255) NOT NULL,
  ENTITY_ID VARCHAR(255) NOT NULL,
  DOMAIN_ID VARCHAR (255) NOT NULL,
  GROUP_ID VARCHAR(255) NOT NULL,
  SHARING_TYPE VARCHAR(255) NOT NULL,
  INHERITED_PARENT_ID VARCHAR(255),
  CREATED_TIME BIGINT NOT NULL,
  UPDATED_TIME BIGINT NOT NULL,
  PRIMARY KEY (PERMISSION_TYPE_ID, ENTITY_ID, GROUP_ID, DOMAIN_ID, INHERITED_PARENT_ID),
  CONSTRAINT `SHARING_PERMISSION_TYPE_ID_DOMAIN_ID_FK` FOREIGN KEY (PERMISSION_TYPE_ID, DOMAIN_ID) REFERENCES PERMISSION_TYPE(PERMISSION_TYPE_ID, DOMAIN_ID) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `SHARING_ENTITY_ID_DOMAIN_ID_FK` FOREIGN KEY (ENTITY_ID, DOMAIN_ID) REFERENCES ENTITY(ENTITY_ID, DOMAIN_ID) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `SHARING_INHERITED_PARENT_ID_DOMAIN_ID_FK` FOREIGN KEY (INHERITED_PARENT_ID, DOMAIN_ID) REFERENCES ENTITY(ENTITY_ID, DOMAIN_ID) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `SHARING_GROUP_ID_DOMAIN_ID_FK` FOREIGN KEY (GROUP_ID, DOMAIN_ID) REFERENCES USER_GROUP(GROUP_ID, DOMAIN_ID) ON DELETE CASCADE ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARACTER SET=latin1;

CREATE TABLE CONFIGURATION
(
  CONFIG_KEY VARCHAR(255) NOT NULL,
  CONFIG_VALUE VARCHAR(255) NOT NULL,
  PRIMARY KEY(CONFIG_KEY, CONFIG_VALUE)
)ENGINE=InnoDB DEFAULT CHARACTER SET=latin1;

INSERT INTO CONFIGURATION (CONFIG_KEY, CONFIG_VALUE) VALUES('sharing_reg_version', '0.17');