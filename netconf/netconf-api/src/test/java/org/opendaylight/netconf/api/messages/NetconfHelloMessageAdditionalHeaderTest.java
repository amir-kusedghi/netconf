/*
 * Copyright (c) 2014 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.netconf.api.messages;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class NetconfHelloMessageAdditionalHeaderTest {


    private String customHeader = "[user;1.1.1.1:40;tcp;client;]";
    private NetconfHelloMessageAdditionalHeader header;

    @Before
    public void setUp() throws Exception {
        header = new NetconfHelloMessageAdditionalHeader("user", "1.1.1.1", "40", "tcp", "client");
    }

    @Test
    public void testGetters() throws Exception {
        assertEquals(header.getAddress(), "1.1.1.1");
        assertEquals(header.getUserName(), "user");
        assertEquals(header.getPort(), "40");
        assertEquals(header.getTransport(), "tcp");
        assertEquals(header.getSessionIdentifier(), "client");
    }

    @Test
    public void testStaticConstructor() throws Exception {
        NetconfHelloMessageAdditionalHeader hdr = NetconfHelloMessageAdditionalHeader.fromString(customHeader);
        assertEquals(hdr.toString(), this.header.toString());
        assertEquals(hdr.toFormattedString(), this.header.toFormattedString());
    }
}
