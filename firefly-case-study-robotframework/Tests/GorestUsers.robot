*** Settings ***
Documentation     Firefly Case Study
Library           RequestsLibrary
Library           DebugLibrary
Resource          ../Resources/keyword.resource
Default Tags      users

Test Setup        Set Log Level    TRACE

*** Variables ***
${BASE_URL}               https://gorest.co.in/public/v1
${RESPONSE_TOTAL}         [meta][pagination][total]
${RESPONSE_PAGES}         [meta][pagination][pages]
${RESPONSE_PAGE}          [meta][pagination][page]

*** Test Cases ***
Gorest Get Users
      ${response}=    GET  ${BASE_URL}/users
      Should Not Be Empty  ${response.json()}
      Status Should Be  200   ${response}
      Should Not Be Empty  ${response.json()}${RESPONSE_TOTAL}
      Should Not Be Empty  ${response.json()}${RESPONSE_PAGES}
      Should Not Be Empty  ${response.json()}${RESPONSE_PAGE}

*** Test Cases ***
Scenario: Gorest Get Users with Gherkin Style
    Given Get Request "/users"
    When Status Code "200" Check
    Then Response Value Check