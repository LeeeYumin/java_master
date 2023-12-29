select * from tab;

create table product (
 product_code char(8) primary key, -- P2023-01
 product_name varchar2(100) not null,
 product_desc varchar2(300) not null,
 origin_price number not null,
 sale_price number,
 like_it number default 3, --추천수
 image varchar2(50)
);

select * from product;
--DROP TABLE product;

insert into product values('P2023-01', '과테말라 원두', '과테말라산 원두입니다.', 5000, 4500, 5, '과테말라.jpg');
insert into product values('P2023-02', '니카라구아 더치', '니카라구아 더치원두입니다', 5500, 4500, 3, '니카라구아 더치.jpg');
insert into product values('P2023-03', '브라질산토스', '브라질산토스 맛있는 커피입니다.', 3500, 3000, 5, '브라질산토스.jpg');
insert into product values('P2023-04', '에티오피아 예가체프', '많이 들어본 그 예가체프 맞음.', 4000, 3500, 4, '에티오피아 예가체프.jpg');
insert into product values('P2023-05', '케냐 오크라톡신', '케냐 오크라톡신(독성없음)', 4500, 3000, 4, '케냐 오크라톡신.jpg');
insert into product values('P2023-06', '코스타리카 따라주', '코스타리카 따라주~', 3000, 2500, 5, '코스타리카 따라주.jpg');

commit;