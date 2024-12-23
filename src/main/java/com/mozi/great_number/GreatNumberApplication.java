package com.mozi.great_number;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

public class GreatNumberApplication {

	static final int SIZE_OF_SUBSTRING = 3;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력해주세요: ");
		String input = scanner.nextLine();
		System.out.println(calculateGreatString(input));

	}

	public static int calculateGreatString(String input) {

		String result = "-1";

		for (int i = 0; i < input.length(); i++) {

			// 숫자 묶음이 3개가 안될 경우
			if (isPossibleSubstring(input, i)) {
				break;
			}

			String subString = input.substring(i, i + SIZE_OF_SUBSTRING);

			// substring이 전부 같은 숫자이고 동시에 기존에 저장된 substring보다 클 경우
			if (isAllSameNumber(subString) && isMaxNumber(result, subString)) {
				result = subString;
			}
		}

		return Integer.parseInt(result);
	}

	// 묶음 가능한 substring 판별 메서드
	public static boolean isPossibleSubstring(String input, int i) {
		return input.length() - i < SIZE_OF_SUBSTRING;
	}

	// substring이 전부 같은 숫자인지 판별하는 메서드
	public static boolean isAllSameNumber(String string) {

		char first = string.charAt(0);
		for (char c : string.toCharArray()) {
			if (c != first) return false;
		}
		return true;
	}

	// 두 스트링 중 10진수가 큰 값을 반환하는 메서드
	public static boolean isMaxNumber(String result, String subString) {
		return Integer.parseInt(result) < Integer.parseInt(subString);
	}

}
