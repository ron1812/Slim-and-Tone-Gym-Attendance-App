package com.management.attendance.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PaginationUtils {

    protected static int defaultPageSize = 20 ;

    protected static int maxPageSize = 50;

    public static Pageable processPagination(int pageIndex, int pageSize){
        pageIndex = pageIndex < 0 ? 0 : pageIndex;
        pageSize = pageSize < 0 ? defaultPageSize : pageSize;
        if (pageSize > maxPageSize)
            pageSize = maxPageSize;

        return PageRequest.of(pageIndex,pageSize);
    }
}
