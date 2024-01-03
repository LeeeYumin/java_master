    // var : 함수레벨로 정의됨.  let, const : block 레벨
        // 앞으로 실습하면서는 let, const 을 주로 쓸 것임   
        var name = 'Hwang'; //함수 밖에서 선언되는 변수(전역변수)
        function myfunc(){
            var name='Hong'; //여기 name 앞의 var가 따로 없다면 Hong 이 출력됨. (블럭의 의미 없음)
            console.log(name);
            console.log(this);
        }
        myfunc();
        console.log(name);

        let age = 20; //블럭단위 변수 유지. 블럭 단위로 의미있는 값을 가짐. 그래서? let은 중복선언 불가임.
        function myfunc2(){ 
            let age = 22;
            console.log(age); //22 출력
        }
        myfunc2();
        console.log(age); //20 출력
        let obj ={
            id : 'Hong', //속성 : 값
            age : 20,
            show : function(){
                console.log(this);
            }
        }
        obj.show();

        document.body.addEventListener('click', function(){
            console.log(this);
        })

        // 1.<script>안에 쓰면 전역 영역. window 객체.
        // 2.함수 안에서 쓰여져도 window 객체.
        // 3.객체로 선언하면 자기 자신(object)을 가리킴.
        // 4.이벤트 : body안에서 선언.. 이벤트 실행 대상.

        console.log(this);

        // let show = 'Hello';
        // function show(){ //이미 선언되어있다고 에러뜸.
        //     consloe.log('show'); 
        // }
        
        // ()실행 규칙
        let show = function(){ //변수 이름을 함수로 쓴 예
            console.log('show');
            //return undefined; 따로 선언안하면 이거 뜸.
            return '반환값'; //반환할 값이 있다면 이렇게.
        }
        console.log(show()); //()는 함수를 실행하겠습니다~ 라는 뜻

        (function(){
            console.log('익명함수');
        })(); //함수를 이렇게 묶어주고 실행도 가능. 익명함수 라는 구문 출력됨 
        
        //변수 만드는 규칙 (명명규칙) 함수 만드는 규칙이랑 비슷함.. 관례적인거 따라간다
        function showMyName(){
            console.log('홍길동'); //3이상의 단어 조합은 카멜
        }

        //상수선언 const
        const height = 167.9;
        height = 169; //에러뜸! 상수는 한번 값이 담기면 변경 불가

        const friend = {
            name: '홍길동',
             phone: '010-1111'
        }
        friend.phone = '010-2222'; //상수의 값을 바꾸는 건 불가. 근데 참조 위치의 값을 바꾸는 건 가능.

        //friend = {} 배열도 참조값. 