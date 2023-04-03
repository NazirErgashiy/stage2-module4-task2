package com.mjc.stage2.impl;


import com.mjc.stage2.Connection;

public class ProxyConnection implements Connection {
    private final RealConnection REAL_CONNECTION;

    public ProxyConnection(RealConnection realConnection) {
        this.REAL_CONNECTION = realConnection;
    }

    public void reallyClose() {
        REAL_CONNECTION.close();
    }

    @Override
    public void close(){
        ConnectionPool.getInstance().releaseConnection(this.REAL_CONNECTION);
    }

    public boolean isClosed(){
        return REAL_CONNECTION.isClosed();
    }
}
