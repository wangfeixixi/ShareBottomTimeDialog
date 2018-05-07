package com.wangfeixixi.edittext;


public class EmojiUtils {
    /**
     * 过滤emoji表情（因为emoji表情版本太多，所以只可以过滤大部分，或者说常用的表情）
     *
     * @param source
     * @return
     */
    public static String filterEmoji(String source) {
        StringBuilder afterFilterString = new StringBuilder();
        if (source != null && source != "") {
            int len = source.length();
            for (int i = 0; i < len; i++) {
                char codePoint = source.charAt(i);
                if (!isEmojiCharacter(codePoint)) { //如果匹配,则该字符是Emoji表情
                    afterFilterString.append(codePoint);
                }
            }
        }
        return afterFilterString.toString();
    }


    /**
     * 判断字符串是否是Emoji表情（因为emoji表情版本太多，所以只可以判断大部分，或者说常用的表情）
     *
     * @param source
     * @return true 表示包含emoji表情
     */
    public static boolean containsEmoji(String source) {
        int len = source.length();
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
            if (isEmojiCharacter(codePoint)) { //如果匹配,则该字符是Emoji表情
                return true;
            }
        }
        return false;
    }


    /**
     * 判断单个字符是否是Emoji表情
     *
     * @param codePoint 比较的单个字符
     * @return true 表示该字符是Emoji表情
     */
    private static boolean isEmojiCharacter(char codePoint) {
        boolean temp = (codePoint == 0x0) || (codePoint == 0x9)
                || (codePoint == 0xA) || (codePoint == 0xD)
                || ((codePoint >= 0x20) && (codePoint <= 0xD7FF))
                || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
                || ((codePoint >= 0x10000)
                && (codePoint <= 0x10FFFF));

        return !temp;
    }
}
