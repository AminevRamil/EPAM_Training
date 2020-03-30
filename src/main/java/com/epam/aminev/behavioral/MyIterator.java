package com.epam.aminev.behavioral;

import com.epam.aminev.structural.proxy.Account;
import com.epam.aminev.structural.proxy.ProxyService;

public interface MyIterator {
    Account getNext();
    boolean hasNext();
}
