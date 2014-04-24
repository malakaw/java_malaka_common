package com.malaka.common.thread.multi.lock;
/**
 *项目名：Malaka_java_common
 *包名：com.malaka.common.thread.multi.lock
 *创建日期：2013-12-3
 *作者：malaka.weng@vipshop.com
 */
public class MyCount {
	private String oid;         //账号
    private int cash;             //账户余额

    MyCount(String oid, int cash) {
            this.oid = oid;
            this.cash = cash;
    }

    public String getOid() {
            return oid;
    }

    public void setOid(String oid) {
            this.oid = oid;
    }

    public int getCash() {
            return cash;
    }

    public void setCash(int cash) {
            this.cash = cash;
    }

    @Override
    public String toString() {
            return "MyCount{" +
                            "oid='" + oid + '\'' +
                            ", cash=" + cash +
                            '}';
    } 
}
