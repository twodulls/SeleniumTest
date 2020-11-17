package com.test.testdata;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Getter
@Setter
public class TestData {

    private String headless;        //셀레늄 헤드리스 모드
    private String targetUrl;       //테스트 대상 url

    private String id;              //아이디
    private String pw;              //패스워드

    private String searchKeyword;   //검색어

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
}
