## 표괴물 사전 과제

#### 1차 FeedBack

1. return true false + if 없애기
2. continue; break; return 없애기
3. 네이밍 바꾸기
4. 상속 + 인터페이스 활용하여 중복제거하기



#### Naming Best Practice

1. **무의미한 이름을 피해라**

   ex) abc, temp, data...

2. **의미있는 이름을 부여하라**

   ex) getPD() (x) , getPayDate() (o)

3. **의도가 드러난다면 되도록 짧은 이름을 선호하라**

   ex) getPayDate() (o) , retreivePaymentDate() (x)

4. **비슷한 이름을 피해라**

   유사한 이름만큼 나쁜 건 없다.
   예를 들어 변수 이름이 employee와 employees는 모두 같으며 마지막만 다르다.
   이런 유사성은 미묘한 버그를 이끌고 코드 리뷰를 어렵게 한다.

5. **축약형 보다 서술형이 더 좋다**

   getLiquidityIndicator()가 getLInd()보다 좋다.
   축약형을 선택하는 경우는 축약형으로도 개발자의 의도가 명백히 전달되는 경우 만이다.
   긴 이름을 사용하게 되는 이유 중 하나는 한 메소드에서 여러 일을 하려 하기 때문이다.
   이런 경우 메소드를 분할 하는 것을 고려해라.
   예를 들어, loadAndUpdateAllInstrumentRecords()는 loadInstruments()와 updateInstruments()로 분할 될 수 있다.

6. **Java 코딩 컨벤션을 따르라**

7. **일관적인 네이밍을 사용하고 동의어는 피해라**

   같은 동작을 하는 메소드들은 일관적인 이름을 사용하라.

   예를 들어 각기 다른 모듈에서 destroy(), kill(), finish()를 사용하는 것은 좋지 않다.



#### JAVA Convention

![](https://user-images.githubusercontent.com/33652399/58450085-54180700-8148-11e9-9234-7eaa032431ba.PNG)

