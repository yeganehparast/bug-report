package com.bug.backend.entity;

public enum BugState {
  NEW("NEW"),

  IN_PROGRESS("IN-PROGRESS"),

  IN_REVIEW("IN-REVIEW"),

  DONE("DONE");

  private String value;

  BugState(String value) {
    this.value = value;
  }

  public static BugState fromValue(String state) {
    for (BugState b : BugState.values()) {
      if (b.value.equals(state)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + state + "'");
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
