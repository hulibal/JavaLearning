package com.Algorithm;

public class reverseWordsTest {

	public static void main(String[] args) {
		String s = "ooototo";
		System.out.println(s.length());
		String[] tmp = s.split("o", 0);
		for (String str : tmp) {
			System.out.println(str.length() + ":" + str);
		}
		System.out.println(new reverseWordsTest()
				.reverseWordsII("the sky is blue fdgdfgfdg"));
	}

	public String reverseWordsII(String s) {
		char[] arr = s.toCharArray();
		int start = 0, end = 0;
		for (; end < arr.length; end++) {
			if (arr[end] == ' ') {
				reverse(arr, start, end - 1);
				start = end + 1;
			}
		}
		reverse(arr, start, end - 1);
		reverse(arr, 0, arr.length - 1);
		return new String(arr);
	}

	public String reverseWords(String s) {
		StringBuilder result = new StringBuilder();
		char[] arr = s.toCharArray();
		int start = 0, end = arr.length - 1;

		while (start < arr.length && end >= 0
				&& (arr[start] == ' ' || arr[end] == ' ')) {
			if (arr[start] == ' ')
				start++;
			if (arr[end] == ' ')
				end--;
		}
		if (end < 0)
			return "";
		reverse(arr, start, end);
		for (int j = start; j < end; j++) {
			if (arr[j] == ' ') {
				reverse(arr, start, j - 1);
				result.append(arr, start, j - start);
				result.append(' ');
				while (arr[j] == ' ')
					j++;
				start = j;
			}
		}
		reverse(arr, start, end);
		result.append(arr, start, end - start + 1);
		return result.toString();
	}

	public void reverse(char[] arr, int start, int end) {
		for (int i = start; i < end + start - i; i++) {
			char tmp = arr[i];
			arr[i] = arr[end + start - i];
			arr[end + start - i] = tmp;
		}
	}
}
