package com.serv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lambda2 {
	public static void main(String[] args) {

		List<ReviewVO> review = new ArrayList<>();
		review.add(new ReviewVO("순신", "리뷰3"));
		review.add(new ReviewVO("기자", "리뷰2"));
		review.add(new ReviewVO("길동", "리뷰1"));

		review.sort(new Comparator<ReviewVO>() {
			@Override
			public int compare(ReviewVO o1, ReviewVO o2) {
				return o1.getContent().compareTo(o2.getContent());
			}

		});

		System.out.println(review);
	}

}