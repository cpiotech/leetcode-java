package com.cp.interview.design;

import java.util.*;

/**
 * Created by curry on 10/29/17.
 */
public class EncodeandDecodeTinyURL {
    public static class Codec {
        Map<Integer, String> map = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            map.put(longUrl.hashCode(), longUrl);
            return "http://tinyurl.com/" + longUrl.hashCode();
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        System.out.println(codec.encode("https://leetcode.com/problems/design-tinyurl"));
        System.out.println(codec.decode(codec.encode("https://leetcode.com/problems/design-tinyurl")));
        System.out.println((char)(14 - 10 + 'a'));
        System.out.println(4 + 'a');
    }
}
