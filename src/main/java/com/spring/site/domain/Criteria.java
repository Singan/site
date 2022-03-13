package com.spring.site.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criteria {

    /** 현재 페이지 번호 */
    private int currentPageNo;

    /** 페이지당 출력할 데이터 개수 */
    private int recordsPerPage;

    /** 화면 하단에 출력할 페이지 사이즈 */
    private int pageSize;

    private int recordsStart;
    public Criteria(int currentPageNo) {
        this.currentPageNo = currentPageNo;
        this.recordsPerPage = 10;
        this.pageSize = 10;
        this.recordsStart = (currentPageNo - 1) * recordsPerPage;
    }


}
