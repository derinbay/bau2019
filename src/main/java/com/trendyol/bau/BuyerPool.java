package com.trendyol.bau;

/**
 * Created by taylan.derinbay on 26.11.2019
 */
public class BuyerPool {

    public static Buyer aBuyer() {
        return new Buyer("test2019@bau.com", "123qwe", "test", "test");
    }

    public static Buyer aBuyerWithEmptyPassword() {
        return new Buyer("test2019@bau.com", "", "test", "test");
    }
}
