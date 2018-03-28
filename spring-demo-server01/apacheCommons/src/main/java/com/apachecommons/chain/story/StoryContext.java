package com.apachecommons.chain.story;

import java.util.HashMap;

import org.apache.commons.chain.impl.ContextBase;

/**
 * 责任链上下文
 * 
 * @author liuxl
 * 2017-10-11 下午6:29:25
 */
public class StoryContext extends ContextBase {

    private static final long serialVersionUID = 1L;

    @SuppressWarnings({ "rawtypes", "serial", "unchecked" })
    public static HashMap<String, HashMap<String, String>> STORY_CONTENT = new HashMap() {
        {
            put("ch01", new HashMap() {
                {
                    put("1", "从前有个人.\n");
                }
            });
            put("ch02", new HashMap() {
                {
                    put("1", "他捡到钱.\n");
                    put("2", "他碰到个美女.\n");
                    put("3", "他中了彩票.\n");
                }
            });
            put("ch03", new HashMap() {
                {
                    put("1", "他捡到钱.\n");
                    put("2", "他碰到个美女.\n");
                    put("3", "他中了彩票.\n");
                }
            });
        }
    };
}
