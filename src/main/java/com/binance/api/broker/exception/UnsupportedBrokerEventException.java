package com.binance.api.broker.exception;

public class UnsupportedBrokerEventException extends IllegalArgumentException {
  private static final long serialVersionUID = -1852755188564122928L;

  public UnsupportedBrokerEventException(String message) {
    super(message);
  }
}
