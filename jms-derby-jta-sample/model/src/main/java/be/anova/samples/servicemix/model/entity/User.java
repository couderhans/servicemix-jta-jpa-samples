/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.    
 */
package be.anova.samples.servicemix.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "User0")
@XmlRootElement(name = "User0")
@Access(value = AccessType.FIELD)
@Entity
// User is a reserved keyword for derby, so use a different table name.
@Table(name = "User0")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Embedded
    ContactInfo contactInfo;

    // Collection of embeddables
    @XmlElementWrapper(name = "adresses")
    @XmlElement(name = "address")
    @ElementCollection
    @CollectionTable(name = "user_addresses")
    private Set<Address> addresses = new HashSet<Address>();
    @Basic
    private String user_name;

    @Basic
    private String user;

    public User() {
    }

    public User(ContactInfo c, String u_n, String u) {
        contactInfo = c;
        user = u;
        user_name = u_n;

    }

    public void addAddress(Address a) {
        addresses.add(a);
    }

    public String toString() {
        String res = user_name + " " + user + " " + contactInfo;

        for (Address a : addresses) {
            res += "\n" + a.toString();
        }
        return res;
    }
}
