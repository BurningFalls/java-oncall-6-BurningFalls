## 구현할 기능 목록

- [] 월과 시작 요일 입력 받기: InputView.inputMonthDay
- [] 월이 1부터 12 사이의 숫자인지 확인: MonthDay.isMonth1to12
- [] 요일이 맞는 형식인지 확인: MonthDay.isDayValidate
- [] 평일 비상 근무 순서 입력받기: InputView.inputWeekdayWorkers
- [] 휴일 비상 근무 순서 입력받기: InputView.inputWeekendWorkers
- [] Workers 입력이 유효한 형식인지 확인: Workers.isValidInput
- [] Workers 입력을 콤마 기준으로 분리하기: Workers.divideWithComma
- [] 근무자의 이름이 최대 5자 이하인지 확인: Workers.isNameUnder5Char
- [] 근무자의 닉네임이 중복되지 않는지 확인: Workers.isNameDuplicate
- [] 근무자가 최소 5명 최대 35명인지 확인: Workers.isCount5to35
- [] 평일 비상 근무와 휴일 비상 근무의 길이가 일치하는지: Workers.isSameLength
- [] 평일 비상 근무와 휴일 비상 근무자 명단 구성이 일치하는지: Workers.isContainsAll
- [] 평일 휴일 List 만들기: oncallController.makeWeekList
- [] 근무 명단 만들기: oncallController.makeWorkerList
- [] 서로 위치 바꾸기: oncallController.changePosition
- [] 근무 명단 유효성 체크하기 (유효하지 않으면 위치 바꾸기): oncallController.isWorkerListValidate
- [] 근무 명단 출력하기: OutputView.printWorkerList