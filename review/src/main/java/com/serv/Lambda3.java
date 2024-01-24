package com.serv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lambda3 {
	public static void main(String[] args) {

		List<ReviewVO> review = new ArrayList<>();
		review.add(new ReviewVO("순신", "리뷰3"));
		review.add(new ReviewVO("기자", "리뷰2"));
		review.add(new ReviewVO("길동", "리뷰1"));

		review.sort((ReviewVO o1, ReviewVO o2) -> {
				return o1.getContent().compareTo(o2.getContent());
			}

		);
		
		
		//review.sort((ReviewVO o1, ReviewVO o2) -> o1.getContent().compareTo(o2.getContent()));
		//위에거 이렇게 한줄로도 가능
		

		System.out.println(review);
	}

}