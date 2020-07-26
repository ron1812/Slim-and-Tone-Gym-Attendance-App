package com.management.attendance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class CustomError {
  @JsonProperty("ErrorCode")
  private String errorCode;

  @JsonProperty("Message")
  private String message;

  public CustomError errorCode(String errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  @NotNull
  @Size(min=1,max=128)
  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public CustomError message(String message) {
    this.message = message;
    return this;
  }

  @NotNull
  @Size(min=1,max=500)
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomError customError = (CustomError) o;
    return Objects.equals(this.errorCode, customError.errorCode) &&
        Objects.equals(this.message, customError.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorCode, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomError {\n");
    
    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

