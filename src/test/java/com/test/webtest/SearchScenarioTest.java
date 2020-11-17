package com.test.webtest;

import com.test.common.BaseTest;
import com.test.pagefactory.DealInfo;
import com.test.pagefactory.SearchHome;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import com.test.pagefactory.TmonHome;

public class SearchScenarioTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(SearchScenarioTest.class);
    public TmonHome home;
    public SearchHome searchHome;
    public DealInfo dealInfo;

    @Test(groups = "login")
    public void loginTest(){
        //target url 접속
        driver.get(targetUrl);

        home = new TmonHome(driver);

        //예외처리 - 타임슬롯 팝업 닫기
//        if( home.isDisplayed(home.time_box_close)){
//            home.closeTimeBox();
//        }
        //특정 시간 대에서 타임슬롯 팝업이 한번 더 노출되고 있어 예외처리 함.
        while(home.isDisplayed(home.time_box_close)){
            home.closeTimeBox();
            if( !home.isDisplayed(home.time_box_close)){
                break;
            }
        }

        //로그인 시도
        wait.until(ExpectedConditions.visibilityOf(home.login));
        home.clickLogin();

        home.loginToCoupang(ID, PW);

        //로그인 확인
        assertThat(true, is(home.isDisplayed(home.logout)));
        logger.debug("로그인 성공!!");
    }

    @Test(groups = "login")
    public void searchTest(){
        //메인 화면에서 키워드 입력 후 검색 결과 화면 이동
        home.inputSearchKeyword(keyword);

        //검색 결과 확인
        searchHome = new SearchHome(driver);

        //아이패드 검색어 확인
        String searchKeywordResult = searchHome.getText(searchHome.searchKeywordResult);
        logger.debug("searchKeywordResult : {}", searchKeywordResult);
        assertThat(searchKeywordResult, equalTo(keyword));

        //검색 결과 건수 확인
        String searchResultCount = searchHome.getText(searchHome.searchResultCount);
        logger.debug("searchResultCount : {}", searchResultCount);
        assertThat(searchResultCount, notNullValue());
    }

    @Test(dependsOnGroups = "login")
    public void dealInfoTest() throws InterruptedException {
        //driver 제어를 위한 현재 열려있는 브라우져 확인
        String parentWindow = driver.getWindowHandle();

        //첫번째 리스트 아이템 클릭
        searchHome.click(searchHome.searchResultFirstItem);

        /*
        * 리스트 아이템 클릭 시 새 탭이 열리면서 딜상세 화면으로 이동한다.
        * 따라서 driver 에서 제어하기 위해서는 새 탭이 열린 화면의 브라우져에서 제어한다고 알려야 한다.
        * driver.switchTo().window(childWindow); 요 코드를 수행하지 않으면 기존에 열린 브라우져에서 엘리먼트를 찾기 때문에
        * no such element 에러 메서지가 계속 뜬다.
         */
        String childWindow = null;
        for(String childs: driver.getWindowHandles()){
            if(!childs.equals(parentWindow)){
                childWindow = childs;
                break;
            }
        }
        driver.switchTo().window(childWindow);

        dealInfo = new DealInfo(driver);

        String title = dealInfo.title.getText();
        logger.debug("deal Title : {}", title);
        Assert.assertNotNull(title);


    }
}
