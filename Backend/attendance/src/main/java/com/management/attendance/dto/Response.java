package com.management.attendance.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.ZonedDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class Response {

   @JsonIgnore
   private Status status;

   private Object result;
   private Pagination pagination;
   private Error error;

   protected Response(Status status, Object result, Pagination pagination, Error error) {
      this.status = status;
      this.result = result;
      this.pagination = pagination;
      this.error = error;
   }

   public Status getStatus() {
      return status;
   }

   public Object getResult() {
      return result;
   }

   public Pagination getPagination() {
      return pagination;
   }

   public Error getError() {
      return error;
   }

   public enum Status {SUCCESS, ERROR}

   public static class Pagination {

      private int pageIndex;
      private int pageSize;
      private int pageTotal;
      private long total;

      public Pagination(int pageIndex, int pageSize, int pageTotal,long total) {
         this.pageIndex = pageIndex;
         this.pageSize = pageSize;
         this.pageTotal = pageTotal;
         this.total = total;
      }

      public int getPageIndex() {
         return pageIndex;
      }

      public int getPageSize() {
         return pageSize;
      }

      public int getPageTotal() {
         return pageTotal;
      }

      public long getTotal() { return total; }
   }

   public static class Error {

      @JsonFormat(shape = JsonFormat.Shape.STRING)
      private ZonedDateTime timestamp;
      private String type;
      private String[] params;
      private String message;

      public Error(String type, String[] params, String message) {
         this.type = type;
         this.params = params;
         this.message = message;
         this.timestamp = ZonedDateTime.now();
      }

      public String getType() {
         return type;
      }

      public String[] getParams() {
         return params;
      }

      public String getMessage() {
         return message;
      }

      public ZonedDateTime getTimestamp() {
         return timestamp;
      }
   }
}
