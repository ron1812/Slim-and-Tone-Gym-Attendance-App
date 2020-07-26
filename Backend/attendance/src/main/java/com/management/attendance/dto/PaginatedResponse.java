package com.management.attendance.dto;

public class PaginatedResponse<T> extends Response {

   public PaginatedResponse(T result) {
      super(Status.SUCCESS, result, null, null);
   }

   public PaginatedResponse() {
      super(Status.SUCCESS, null, null, null);
   }

   public PaginatedResponse(T result, Pagination pagination) {
      super(Status.SUCCESS, result, pagination, null);
   }
}
