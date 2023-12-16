### 미션 해결 전략 
#### 1. 본인이 이해하고 구현한 내용에 기반해 '다른 근무자와 순서를 바꿔야 하는 경우'를 자신만의 예시를 들어 설명하세요. (필수)

```java
private List<Integer> weekList;
private List<String> workerList;

public static final int WEEKDAY = 0;
public static final int WEEKDAY_HOLIDAY = 1;
public static final int WEEKEND = 2;
```

| index (일)  |  1   | 2  | 3  |  4   |  5   |  6   |
|:----------:|:----:|:--:|:--:|:----:|:----:|:----:|
|  weekList  |  0   | 0  | 0  |  0   |  1   |  2   |
| workerList |  빨강  | 주황 | 노랑 |  초록  |  초록  |  파랑  |

(1) 평일 비상 근무 순번 `weekdayWorkers`과 휴일 비상 근무 순번 `weekendWorkers`를 바탕으로, `weekList`에 맞게 근무자를 배정하여 `workerList`를 생성합니다.

(2) `workerList`를 탐색하며 현재 `curIndex`번째 이름이 지난번 `prevIndex`번째 이름과 같은지 확인합니다.

(3) `curIndex`번째에서 겹치는 경우, 해당 인덱스의 `weekList`의 값이 `1 or 2`면 (3-1)로, `0`이면 (3-2)로 넘어갑니다.

(3-1) `weekList`의 값이 `1 or 2`인 다음 인덱스 `nextIndex`를 찾습니다. `curIndex`와 `nextIndex`의 `workerList` 값을 변경합니다.

(3-2) `weekList`의 값이 `0`인 다음 인덱스 `nextIndex`를 찾습니다. `curIndex`와 `nextIndex`의 `workerList` 값을 변경합니다.

(4) 만약 `nextIndex`가 존재하지 않는 경우, `weekdayWorkers` 또는 `weekendWorkers`에서 다음 근무자 이름을 찾아서 대입합니다.

| index (일)  |   1   |  2   |  3   |  4   | 5  |  6  |
|:----------:|:-----:|:----:|:----:|:----:|:--:|:---:|
|  weekList  |   0   |  0   |  0   |  0   | 1  |  2  |
| workerList |  빨강  | 주황 | 노랑 |  초록  | 파랑 | 초록  |

* 이 예제에서는 `curIndex=5`에서 문제가 생기므로, 다음 `weekList` 값이 `1 or 2`인 `nextIndex=6`을 찾습니다. `5`와 `6`의 `workerList` 값을 바꾸어 다음과 같이 변합니다.

#### 2. 요구사항에서 제시한 앞의 날짜부터 순서를 변경하는 방법 외에 다른 방법이 있다면 어떤 방식이 있는지, 이 방법은 기존에 제시된 방식과 비교해 어떤 차이가 있는지 설명하세요. (선택)

뒤의 날짜부터 순서를 변경하는 방법이 있습니다.

이 경우, `curIndex`와 `nextIndex(>curIndex)`의 데이터를 바꾸어버리고 계속해서 앞으로 가버리면, `nextIndex`의 데이터가 주변에 연속된 데이터를 갖는지에 대한 검사를 할 수 없습니다.
따라서, 전체 데이터에 문제가 없을 때까지 계속 탐색해야합니다. 

앞의 날짜부터 변경하게 되면, `curIndex`와 `nextIndex(>curIndex)`의 데이터를 바꾸어버리고 뒤로 가게되고, 반드시 `nextIndex`의 유효성을 거치게 되어 있습니다.
따라서, 한 번의 탐색으로 전체 데이터를 유효하게 바꿀 수 있습니다.

결론적으로, 뒤의 날짜부터 순서를 변경하는 방법은 앞의 날짜부터 순서를 변경하는 방법보다 평균적으로 높은 시간복잡도를 갖습니다.