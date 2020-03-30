package com.epam.aminev.structural.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * {@link ProxyException} indicates that something wrong goes
 * with proxy service
 */
@Slf4j
public class ProxyException extends RuntimeException {
    public ProxyException(String message) {
        super(message);
        log.error(message);
    }
}
