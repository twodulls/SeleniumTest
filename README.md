[테스트 수행 환경]
- Browser : Chrome v86.0.4240.80
- OS : Mac 10.15.3
- IDE : IntelliJ 2019.3

[적용기술]
- Selenium, PageFactory, LomBok, Yaml, logback, TestNG, ExtentReport

[테스트 수행 전 확인사항]
- src/test/resources/data.yml 파일에 티몬 계정 id, pw 값을 입력해야 한다.

[테스트 시나리오]
1. 티몬 접속
2. 티몬 로그인 후 로그인 여부 확
3. 검색어 입력 후 검색(검색어 : 아이패드)
4. 검색어 확인 및 검색 결과 수 확인
5. 첫번째 리스트 아이템의 상품 상세화면 진입
6. 상품 제목 확인
