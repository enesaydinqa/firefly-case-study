*** Keywords ***
Get Request "${path}"
    log to console  ${BASE_URL}${path}
    ${response}=    GET  ${BASE_URL}${path}
    Should Not Be Empty  ${response.json()}
    Log  ${response.json()}
    Set Global Variable  ${response}

Status Code "${code}" Check
    Should Be Equal As Strings  ${response.reason}  OK
    Status Should Be    ${code}  ${response}

Response Value Check
     Should Not Be Empty  ${response.json()}${RESPONSE_TOTAL}
     Should Not Be Empty  ${response.json()}${RESPONSE_PAGES}
     Should Not Be Empty  ${response.json()}${RESPONSE_PAGE}